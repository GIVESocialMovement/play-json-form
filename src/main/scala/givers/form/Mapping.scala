package givers.form

import givers.form.Mapping.{ErrorSpec, Field}
import play.api.libs.json._

import scala.collection.mutable
import scala.util.{Failure, Success, Try}


object Mapping {
  case class Field[T](key: String, mapping: Mapping[T])

  object Field {
    def apply[T](tuple: (String, Mapping[T])): Field[T] = Field(tuple._1, tuple._2)
  }

  def error(key: String, args: Any*): ValidationException = {
    new ValidationException(Seq(new ValidationMessage(key, args:_*)))
  }

  case class ErrorSpec(key: String, argCount: Int = 0) {
    def addPrefix(prefix: String) = {
      this.copy(key = ValidationMessage.addPrefix(prefix, key))
    }
  }
}

trait Mapping[T] { self =>

  private[this] val allErrors: mutable.Set[ErrorSpec] = mutable.Set.empty

  def addError(error: String, argCount: Int = 0) = {
    allErrors.add(ErrorSpec(error, argCount))
  }

  def getAllErrors() = allErrors.toSet

  def bind(value: JsLookupResult, context: BindContext): Try[T]
  def unbind(value: T, context: UnbindContext): JsValue

  def pipe[R](bind: T => R, unbind: R => T): Mapping[R] = {
    transform[R](
      bind = { (v, _) => Success(bind(v)) },
      unbind = { (v, _) => unbind(v) }
    )
  }

  def transform[R](bind: (T, BindContext) => Try[R], unbind: (R, UnbindContext) => T, errors: ErrorSpec*): Mapping[R] = {
    val forward = bind
    val backward = unbind

    new Mapping[R] {
      self.getAllErrors().foreach { error =>
        addError(error.key, error.argCount)
      }

      errors.foreach { error =>
        addError(error.key, error.argCount)
      }

      def bind(value: JsLookupResult, context: BindContext): Try[R] = {
        self.bind(value, context).flatMap { t => forward(t, context) }
      }

      def unbind(value: R, context: UnbindContext): JsValue = {
        self.unbind(backward(value, context), context)
      }
    }
  }

  def verifying(error: => String, fn: T => Boolean): Mapping[T] = validate(error)(fn)

  def validate(error: => String, args: Any*)(fn: T => Boolean): Mapping[T] = new Mapping[T] {

    self.getAllErrors().foreach { error =>
      addError(error.key, error.argCount)
    }
    addError(error, args.size)

    def bind(value: JsLookupResult, context: BindContext): Try[T] = {
      self.bind(value, context).flatMap { v =>
        if (fn(v)) {
          Success(v)
        } else {
          Failure(Mapping.error(error, args:_*))
        }
      }
    }

    def unbind(value: T, context: UnbindContext): JsValue = self.unbind(value, context)
  }
}

trait ValueMapping[T] extends Mapping[T] {

  addError("error.required")

  def bind(value: JsLookupResult, context: BindContext): Try[T] = {
    value.toOption.filterNot(_ == JsNull) match {
      case Some(v) => bind(v, context)
      case None => Failure(Mapping.error("error.required"))
    }
  }

  protected[this] def bind(value: JsValue, context: BindContext): Try[T]
  def unbind(value: T, context: UnbindContext): JsValue
}

object ObjectMapping {
  def bind(value: JsValue, fields: Seq[Field[_]], context: BindContext): Try[Seq[_]] = {
    val results = fields
      .foldLeft(mutable.LinkedHashMap.empty[String, Try[_]]) { case (map, field) =>
        map ++ Seq(
          field.key -> field.mapping.bind(value \ field.key, BindContext(map, Some(context)))
        )
      }

    if (results.forall(_._2.isSuccess)) {
      Success(results.toList.map(_._2.get))
    } else {
      val exs = results
        .toList
        .flatMap {
          case (_, Success(_)) => None
          case (key, Failure(e: ValidationException)) => Some(e.messages.map(_.addPrefix(key)))
          case (_, Failure(NotApplicableException)) => None
          case (key, Failure(e)) => throw new Exception(s"Unhandled exception when processing `$key`", e)
        }
        .flatten
      Failure(new ValidationException(exs))
    }
  }

  def unbind(values: Seq[Any], fields: Seq[Field[_]], context: UnbindContext): JsValue = {
    val currentContext = UnbindContext(
      current = fields.map(_.key).zip(values).toMap,
      parentOpt = Some(context)
    )
    val fs = fields
      .zip(values)
      .map { case (f, v) =>
        f.key -> unbind(f.mapping, v, currentContext)
      }

    JsObject(fs.toList)
  }

  private[this] def unbind[T](mapping: Mapping[T], value: Any, context: UnbindContext) = {
    mapping.unbind(value.asInstanceOf[T], context)
  }
}

trait ObjectMapping[T] extends ValueMapping[T] { self =>
  def fields: Seq[Field[_]]


  override def getAllErrors(): Set[ErrorSpec] = {
    fields
      .flatMap { field =>
        field.mapping.getAllErrors().map { error =>
          error.addPrefix(field.key)
        }
      }
      .toSet
  }
}


