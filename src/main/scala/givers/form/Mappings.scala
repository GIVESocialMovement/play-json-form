package givers.form

import givers.form.generated.ObjectMappings
import play.api.libs.json._

import scala.util.{Failure, Success, Try}


object Mappings extends ObjectMappings {
  val text: Mapping[String] = text()
  def text(
    trim: Boolean = true,
    allowEmpty: Boolean = true,
    maxLength: Int = Int.MaxValue,
    coerceToString: Boolean = true
  ): Mapping[String] = {
    Some
      .apply(new Mapping[String] {

        if (!coerceToString) {
          addError("error.invalid")
        }

        def bind(value: JsLookupResult, context: BindContext): Try[String] = {
          bind(value.toOption.filterNot(_ == JsNull).getOrElse(JsString("")))
        }

        protected[this] def bind(value: JsValue): Try[String] = try {
          Success(value.as[String])
        } catch {
          case _: Exception =>
            if (coerceToString) {
              Success(value match {
                case v: JsString => v.value
                case v: JsBoolean => v.value.toString
                case v: JsNumber => v.value.toString
                case v: JsArray => v.toString
                case JsNull => ""
                case v: JsObject => v.toString
              })
            } else {
              Failure(Mapping.error("error.invalid"))
            }
        }

        def unbind(value: String, context: UnbindContext): JsValue = JsString(value)
      })
      .map { mapping =>
        if (trim) {
          mapping.transform[String](
            bind = { (s, _) => Success(s.trim()) },
            unbind = { (v, _) => v }
          )
        } else {
          mapping
        }
      }
      .map { mapping =>
        if (maxLength != Int.MaxValue) {
          mapping.validate("error.maxLength", maxLength)(_.length <= maxLength)
        } else {
          mapping
        }
      }
      .map { mapping =>
        if (allowEmpty) {
          mapping
        } else {
          mapping.validate("error.required")(_.nonEmpty)
        }
      }
      .get
  }

  val email = text.validate("error.email") { s =>
    s.contains("@")
  }

  val boolean: Mapping[Boolean] = boolean()
  def boolean(translateAbsenceToFalse: Boolean = false): Mapping[Boolean] = new Mapping[Boolean] {

    addError("error.required")
    addError("error.boolean")

    def bind(value: JsLookupResult, context: BindContext): Try[Boolean] = try {
      value.toOption.filterNot(_ == JsNull) match {
        case Some(v: JsBoolean) => Success(v.value)
        case Some(v: JsString) => Success(v.value.toBoolean)
        case None =>
          if (translateAbsenceToFalse) {
            Success(false)
          } else {
            Failure(Mapping.error("error.required"))
          }
        case _ => throw new Exception()
      }
    } catch {
      case _: Exception => Failure(Mapping.error("error.boolean"))
    }

    def unbind(value: Boolean, context: UnbindContext): JsValue = JsBoolean(value)
  }

  val longNumber: Mapping[Long] = longNumber()
  def longNumber(min: Long = Long.MinValue, max: Long = Long.MaxValue): Mapping[Long] = {
    val m = new ValueMapping[Long] {
      addError("error.number")

      protected[this] def bind(value: JsValue, context: BindContext): Try[Long] = try {
        Success
          .apply(
            value match {
              case v: JsNumber => v.value.toLong
              case v: JsString => v.value.toLong
              case _ => throw new Exception()
            }
          )
      } catch {
        case _: Exception => Failure(Mapping.error("error.number"))
      }

      def unbind(value: Long, context: UnbindContext): JsValue = JsNumber(BigDecimal(value))
    }

    if (min != Long.MinValue) {
      m.validate("error.min", min)(_ >= min)
    } else if (max != Long.MaxValue) {
      m.validate("error.max", max)(_ <= max)
    } else {
      m
    }
  }

  val number: Mapping[Int] = number()
  def number(min: Int = Int.MinValue, max: Int = Int.MaxValue): Mapping[Int] = {
    val m = new ValueMapping[Int] {
      addError("error.number")

      protected[this] def bind(value: JsValue, context: BindContext): Try[Int] = try {
        Success
          .apply(
            value match {
              case v: JsNumber => v.value.toInt
              case v: JsString => v.value.toInt
              case _ => throw new Exception()
            }
          )
      } catch {
        case _: Exception => Failure(Mapping.error("error.number"))
      }

      def unbind(value: Int, context: UnbindContext): JsValue = JsNumber(BigDecimal(value))
    }

    if (min != Int.MinValue) {
      m.validate("error.min", min)(_ >= min)
    } else if (max != Int.MaxValue) {
      m.validate("error.max", max)(_ <= max)
    } else {
      m
    }
  }

  def seq[T](mapping: Mapping[T], nonEmpty: Boolean = false, translateNoneToEmpty: Boolean = false): Mapping[Seq[T]] = {
    Some
      .apply(
        new Mapping[Seq[T]] {
          addError("error.required")
          addError("error.invalid")

          mapping.getAllErrors().foreach { error =>
            addError(ValidationMessage.addPrefix("item", error.key), error.argCount + 1)
          }

          def bind(value: JsLookupResult, context: BindContext): Try[Seq[T]] = {
            value.toOption.filterNot(_ == JsNull) match {
              case Some(v) => bind(v, context)
              case None =>
                // In Play's form, a missing key is translated to an empty Seq.
                if (translateNoneToEmpty) {
                  Success(Seq.empty)
                } else {
                  Failure(Mapping.error("error.required"))
                }
            }
          }

          protected[this] def bind(value: JsValue, context: BindContext): Try[Seq[T]] = {
            value match {
              case array: JsArray => build(array, context: BindContext)
              case _ => Failure(Mapping.error("error.invalid"))
            }
          }

          protected[this] def build(array: JsArray, context: BindContext): Try[Seq[T]] = {
            val items = array.value.map { v => mapping.bind(JsDefined(v), context) }

            if (items.forall(_.isSuccess)) {
              Success(items.map(_.get))
            } else {
              Failure {
               new ValidationException(
                  items
                    .zipWithIndex
                    .collect { case (Failure(e), index) => index -> e }
                    .flatMap {
                      case (index, ex :ValidationException) => ex.messages.map { m => m.addPrefix("item").prependArg(index) }
                      case (_, e) => throw e
                    }
                )
              }
            }
          }

          def unbind(value: Seq[T], context: UnbindContext): JsValue = JsArray(value.map { v => mapping.unbind(v, context) })
        }
      )
      .map { mapping =>
        if (nonEmpty) {
          mapping.validate("error.required")(_.nonEmpty)
        } else {
          mapping
        }
      }
      .get
  }

  def opt[T](mapping: Mapping[T], translateEmptyStringToNone: Boolean = false): Mapping[Option[T]] = new Mapping[Option[T]] {
    def bind(value: JsLookupResult, context: BindContext): Try[Option[T]] = {
      value.toOption match {
        // In Play's Form, an empty string is converted back to None.
        case Some(v: JsString) if v.value.isEmpty && translateEmptyStringToNone => Success(None)
        case Some(v) => bind(v, context)
        case None => Success(None)
      }
    }

    protected[this] def bind(value: JsValue, context: BindContext): Try[Option[T]] = {
      if (value == JsNull) {
        Success(None)
      } else {
        mapping.bind(JsDefined(value), context).map(Some.apply)
      }
    }

    def unbind(value: Option[T], context: UnbindContext): JsValue = {
      value.map { v => mapping.unbind(v, context) }.getOrElse(JsNull)
    }
  }
}
