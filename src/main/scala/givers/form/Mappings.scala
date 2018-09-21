package givers.form

import givers.form.generated.ObjectMappings
import play.api.libs.json._

import scala.util.{Failure, Success, Try}


object Mappings extends ObjectMappings {
  val text: Mapping[String] = text()
  def text(
    trim: Boolean = true,
    allowEmpty: Boolean = true,
    maxLength: Int = Int.MaxValue
  ): Mapping[String] = {
    Some
      .apply(new Mapping[String] {
        def bind(value: JsLookupResult): Try[String] = {
          bind(value.toOption.filterNot(_ == JsNull).getOrElse(JsString("")))
        }

        protected[this] def bind(value: JsValue): Try[String] = try {
          Success(value.as[String])
        } catch {
          case _: Exception => Failure(Mapping.error("error.invalid"))
        }

        def unbind(value: String): JsValue = JsString(value)
      })
      .map { mapping =>
        if (trim) {
          mapping.transform[String](
            bind = { s => Success(s.trim()) },
            unbind = identity
          )
        } else {
          mapping
        }
      }
      .map { mapping =>
        mapping.validate("error.maxLength", maxLength)(_.length <= maxLength)
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
    s.nonEmpty && s.contains("@")
  }

  val boolean: Mapping[Boolean] = boolean()
  def boolean(translateAbsenceToFalse: Boolean = false): Mapping[Boolean] = new Mapping[Boolean] {
    def bind(value: JsLookupResult): Try[Boolean] = try {
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

    def unbind(value: Boolean): JsValue = JsBoolean(value)
  }

  val longNumber: Mapping[Long] = longNumber()
  def longNumber(min: Long = Long.MinValue, max: Long = Long.MaxValue): Mapping[Long] = new ValueMapping[Long] {
    protected[this] def bind(value: JsValue): Try[Long] = try {
      Success
          .apply(
            value match {
              case v: JsNumber => v.value.toLong
              case v: JsString => v.value.toLong
              case _ => throw new Exception()
            }
          )
          .flatMap { v =>
            if (v < min) {
              Failure(Mapping.error("error.min", min))
            } else if (v > max) {
              Failure(Mapping.error("error.max", max))
            } else {
              Success(v)
            }
          }
    } catch {
      case _: Exception => Failure(Mapping.error("error.number"))
    }

    def unbind(value: Long): JsValue = JsNumber(BigDecimal(value))
  }

  val number: Mapping[Int] = number()
  def number(min: Int = Int.MinValue, max: Int = Int.MaxValue): Mapping[Int] = new ValueMapping[Int] {
    protected[this] def bind(value: JsValue): Try[Int] = try {

      Success
        .apply(
          value match {
            case v: JsNumber => v.value.toInt
            case v: JsString => v.value.toInt
            case _ => throw new Exception()
          }
        )
        .flatMap { v =>
          if (v < min) {
            Failure(Mapping.error("error.min", min))
          } else if (v > max) {
            Failure(Mapping.error("error.max", max))
          } else {
            Success(v)
          }
        }
    } catch {
      case _: Exception => Failure(Mapping.error("error.number"))
    }

    def unbind(value: Int): JsValue = JsNumber(BigDecimal(value))
  }

  def seq[T](mapping: Mapping[T], nonEmpty: Boolean = false, translateNoneToEmpty: Boolean = false): Mapping[Seq[T]] = {
    Some
      .apply(
        new Mapping[Seq[T]] {
          def bind(value: JsLookupResult): Try[Seq[T]] = {
            value.toOption.filterNot(_ == JsNull) match {
              case Some(v) => bind(v)
              case None =>
                // In Play's form, a missing key is translated to an empty Seq.
                if (translateNoneToEmpty) {
                  Success(Seq.empty)
                } else {
                  Failure(Mapping.error("error.required"))
                }
            }
          }

          protected[this] def bind(value: JsValue): Try[Seq[T]] = {
            value match {
              case array: JsArray => build(array)
              case _ => Failure(Mapping.error("error.invalid"))
            }
          }

          protected[this] def build(array: JsArray): Try[Seq[T]] = {
            val items = array.value.map { v => mapping.bind(JsDefined(v)) }

            if (items.forall(_.isSuccess)) {
              Success(items.map(_.get))
            } else {
              Failure(new Exception())
            }
          }

          def unbind(value: Seq[T]): JsValue = JsArray(value.map(mapping.unbind))
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

  def optional[T](mapping: Mapping[T]): Mapping[Option[T]] = opt(mapping)

  def opt[T](mapping: Mapping[T], translateEmptyStringToNone: Boolean = false): Mapping[Option[T]] = new Mapping[Option[T]] {
    def bind(value: JsLookupResult): Try[Option[T]] = {
      value.toOption match {
        // In Play's Form, an empty string is converted back to None.
        case Some(v: JsString) if v.value.isEmpty && translateEmptyStringToNone => Success(None)
        case Some(v) => bind(v)
        case None => Success(None)
      }
    }

    protected[this] def bind(value: JsValue): Try[Option[T]] = {
      if (value == JsNull) {
        Success(None)
      } else {
        mapping.bind(JsDefined(value)).map(Some.apply)
      }
    }

    def unbind(value: Option[T]): JsValue = {
      value.map(mapping.unbind).getOrElse(JsNull)
    }
  }
}
