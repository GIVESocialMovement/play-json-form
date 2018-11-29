package givers.form

import givers.form.Mapping.Field
import play.api.libs.json._

import scala.util.{Failure, Success, Try}


object Mapping {
  case class Field[T](key: String, mapping: Mapping[T])

  object Field {
    def apply[T](tuple: (String, Mapping[T])): Field[T] = Field(tuple._1, tuple._2)
  }

  def error(message: String, args: Any*): ValidationException = {
    new ValidationException(Seq(new ValidationMessage("", message, args:_*)))
  }
}

trait Mapping[T] { self =>
  def bind(value: JsLookupResult): Try[T]
  def unbind(value: T): JsValue

  def pipe[R](bind: T => R, unbind: R => T): Mapping[R] = {
    transform[R](
      bind = { v => Success(bind(v)) },
      unbind = unbind
    )
  }

  def transform[R](bind: T => Try[R], unbind: R => T): Mapping[R] = {
    val forward = bind
    val backward = unbind

    new Mapping[R] {
      def bind(value: JsLookupResult): Try[R] = {
        self.bind(value).flatMap(forward)
      }

      def unbind(value: R): JsValue = {
        self.unbind(backward(value))
      }
    }
  }

  def verifying(error: => String, fn: T => Boolean): Mapping[T] = validate(error)(fn)

  def validate(error: => String, args: Any*)(fn: T => Boolean): Mapping[T] = new Mapping[T] {
    def bind(value: JsLookupResult): Try[T] = {
      self.bind(value).flatMap { v =>
        if (fn(v)) {
          Success(v)
        } else {
          Failure(Mapping.error(error, args:_*))
        }
      }
    }

    def unbind(value: T): JsValue = self.unbind(value)
  }
}

trait ValueMapping[T] extends Mapping[T] {
  def bind(value: JsLookupResult): Try[T] = {
    value.toOption.filterNot(_ == JsNull) match {
      case Some(v) => bind(v)
      case None => Failure(Mapping.error("error.required"))
    }
  }

  protected[this] def bind(value: JsValue): Try[T]
  def unbind(value: T): JsValue
}

object ObjectMapping {
  def convert(value: JsValue, fields: Seq[Field[_]]): Try[Seq[_]] = {
    val results = fields
      .map { field =>
        field.mapping.bind(value \ field.key)
      }

    if (results.forall(_.isSuccess)) {
      Success(results.map(_.get))
    } else {
      Failure {
        new ValidationException(
          results.zip(fields)
            .collect {
              case (Failure(e: ValidationException), field) => e.messages.map(_.addPrefix(field.key))
              case (Failure(e), field) => throw new Exception(s"Unhandled exception when processing `${field.key}`", e)
            }
            .flatten
        )
      }
    }
  }
}

trait ObjectMapping[T] extends ValueMapping[T] { self =>
  def fields: Seq[Field[_]]

  // This supports processing params in steps.
  // A real world example:
  //   we need a currency in order to construct a form that processes an amount.
  //   Because, for example, KRW is a zero-decimal currency and doesn't need to be multiplied by 100, while
  //   USD does.
  def andThen[Q](
    bind: T => ObjectMapping[Q],
    unbind: Q => T
  ): ObjectMapping[Q] = {
    val transformBind = bind
    val transformUnbind = unbind

    new ObjectMapping[Q] {
      override def fields: Seq[Field[_]] = throw new UnsupportedOperationException()

      override def bind(value: JsValue): Try[Q] = {
        self.bind(value).flatMap { t =>
          val m = transformBind(t)
          m.bind(JsDefined(value))
        }
      }

      override def unbind(value: Q): JsValue = {
        val t = transformUnbind(value)
        transformBind(t).unbind(value).as[JsObject] ++ self.unbind(transformUnbind(value)).as[JsObject]
      }
    }
  }
}


