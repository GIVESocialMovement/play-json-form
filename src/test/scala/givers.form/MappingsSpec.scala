package givers.form

import givers.form.Mapping.ErrorSpec
import helpers.BaseSpec
import play.api.libs.json._
import utest.Tests
import utest._

import scala.util.{Failure, Success}


object MappingsSpec extends BaseSpec {
  val tests = Tests {
    "boolean" - {
      "binds/unbinds boolean" - {
        assert(Mappings.boolean.bind(JsDefined(JsBoolean(true)), Context.empty) == Success(true))
        assert(Mappings.boolean.unbind(true) == JsBoolean(true))
        assert(Mappings.boolean.bind(JsDefined(JsBoolean(false)), Context.empty) == Success(false))
        assert(Mappings.boolean.unbind(false) == JsBoolean(false))
      }

      "binds string" - {
        assert(Mappings.boolean.bind(JsDefined(JsString("true")), Context.empty) == Success(true))
        assert(Mappings.boolean.bind(JsDefined(JsString("false")), Context.empty) == Success(false))
      }

      "binds missing" - {
        assert(Mappings.boolean(translateAbsenceToFalse = true).bind(JsDefined(JsNull), Context.empty) == Success(false))
        assert(Mappings.boolean(translateAbsenceToFalse = true).bind(JsUndefined(""), Context.empty) == Success(false))
      }

      "binds invalid" - {
        assert(Mappings.boolean.bind(JsUndefined(""), Context.empty) == Failure(Mapping.error("error.required")))
        assert(Failure(Mapping.error("error.boolean")) == Mappings.boolean.bind(JsDefined(JsString("random")), Context.empty))
        assert(Failure(Mapping.error("error.boolean")) == Mappings.boolean.bind(JsDefined(JsNumber(100L)), Context.empty))
      }

      "all errors" - {
        assert(Mappings.boolean.getAllErrors() == Set(ErrorSpec("error.boolean"), ErrorSpec("error.required")))
      }
    }

    "email" - {
      "binds/unbind string" - {
        assert(Mappings.email.bind(JsDefined(JsString(" a@b ")), Context.empty) == Success("a@b"))
      }

      "binds invalid" - {
        assert(Mappings.email.bind(JsDefined(JsString(" ab ")), Context.empty) == Failure(Mapping.error("error.email")))
        assert(Mappings.email.bind(JsDefined(JsString("")), Context.empty) == Failure(Mapping.error("error.email")))
      }

      "all errors" - {
        assert(Mappings.email.getAllErrors() == Set(ErrorSpec("error.email"), ErrorSpec("error.invalid")))
      }
    }

    "text (not trimmed, allows empty)" - {
      "binds/unbinds string" - {
        assert(Mappings.text(trim = false).bind(JsDefined(JsString("")), Context.empty) == Success(""))
        assert(Mappings.text(trim = false).bind(JsDefined(JsString(" txt ")), Context.empty) == Success(" txt "))
        assert(Mappings.text(trim = false).unbind(" txt ") == JsString(" txt "))
      }

      "binds invalid" - {
        assert(Mappings.text().bind(JsDefined(JsBoolean(true)), Context.empty) == Failure(Mapping.error("error.invalid")))
        assert(Mappings.text().bind(JsDefined(JsNumber(100L)), Context.empty) == Failure(Mapping.error("error.invalid")))
        assert(Mappings.text().bind(JsDefined(JsNumber(100L)), Context.empty) == Failure(Mapping.error("error.invalid")))
      }

      "all errors" - {
        assert(Mappings.text().getAllErrors() == Set(ErrorSpec("error.invalid")))
      }
    }

    "text (trimmed, limit length)" - {
      "binds/unbinds string" - {
        assert(Mappings.text(maxLength = 3).bind(JsDefined(JsString(" txt ")), Context.empty) == Success("txt"))
        assert(Mappings.text(maxLength = 3).unbind(" txt ") == JsString(" txt "))
      }

      "binds invalid" - {
        assert(Mappings.text(maxLength = 3).bind(JsDefined(JsString("aaaa")), Context.empty) == Failure(Mapping.error("error.maxLength", 3)))
      }

      "all errors" - {
        println(Mappings.text(maxLength = 3).getAllErrors())
        assert(Mappings.text(maxLength = 3).getAllErrors() == Set(ErrorSpec("error.invalid"), ErrorSpec("error.maxLength", 1)))
      }
    }

    "text (trimmed, forbids empty)" - {
      "binds/unbinds string" - {
        assert(Mappings.text(allowEmpty = false).bind(JsDefined(JsString(" txt ")), Context.empty) == Success("txt"))
        assert(Mappings.text(allowEmpty = false).unbind(" txt ") == JsString(" txt "))
      }

      "binds empty" - {
        assert(Mappings.text(allowEmpty = false).bind(JsDefined(JsString("  ")), Context.empty) == Failure(Mapping.error("error.required")))
      }

      "all errors" - {
        assert(Mappings.text(allowEmpty = false).getAllErrors() == Set(ErrorSpec("error.invalid"), ErrorSpec("error.required")))
      }
    }

    "long" - {
      "binds/unbinds number" - {
        assert(Mappings.longNumber(min = 99, max = 101).bind(JsDefined(JsNumber(100)), Context.empty) == Success(100L))
        assert(Mappings.longNumber().bind(JsDefined(JsNumber(100)), Context.empty) == Success(100L))
        assert(Mappings.longNumber().unbind(100L) == JsNumber(BigDecimal(100L)))
      }

      "binds string" - {
        assert(Mappings.longNumber().bind(JsDefined(JsString("100")), Context.empty) == Success(100L))
        assert(Mappings.longNumber().bind(JsDefined(JsString("-100")), Context.empty) == Success(-100L))
      }

      "validates" - {
        assert(Mappings.longNumber(min = 10L).bind(JsDefined(JsNumber(9L)), Context.empty) == Failure(Mapping.error("error.min", 10L)))
        assert(Mappings.longNumber(max = 10L).bind(JsDefined(JsNumber(11L)), Context.empty) == Failure(Mapping.error("error.max", 10L)))
      }

      "binds invalid" - {
      "all errors" - {
        assert(Mappings.longNumber().getAllErrors() == Set(ErrorSpec("error.number"), ErrorSpec("error.required")))
        assert(Mappings.longNumber(min = 10L).getAllErrors() == Set(ErrorSpec("error.number"), ErrorSpec("error.required"), ErrorSpec("error.min", 1)))
        assert(Mappings.longNumber(max = 10L).getAllErrors() == Set(ErrorSpec("error.number"), ErrorSpec("error.required"), ErrorSpec("error.max", 1)))
      }
        assert(Mappings.longNumber().bind(JsDefined(JsBoolean(true)), Context.empty) == Failure(Mapping.error("error.number")))
        assert(Mappings.longNumber().bind(JsDefined(JsString("aaa")), Context.empty) == Failure(Mapping.error("error.number")))
      }

      "all errors" - {
        assert(Mappings.longNumber().getAllErrors() == Set(ErrorSpec("error.number"), ErrorSpec("error.required")))
        assert(Mappings.longNumber(min = 10L).getAllErrors() == Set(ErrorSpec("error.number"), ErrorSpec("error.required"), ErrorSpec("error.min", 1)))
        assert(Mappings.longNumber(max = 10L).getAllErrors() == Set(ErrorSpec("error.number"), ErrorSpec("error.required"), ErrorSpec("error.max", 1)))
      }
    }

    "int" - {
      "binds/unbinds number" - {
        assert(Mappings.number(min = 99, max = 101).bind(JsDefined(JsNumber(100)), Context.empty) == Success(100))
        assert(Mappings.number().bind(JsDefined(JsNumber(100)), Context.empty) == Success(100))
        assert(Mappings.number().unbind(100) == JsNumber(100))
      }

      "binds string" - {
        assert(Mappings.number().bind(JsDefined(JsString("100")), Context.empty) == Success(100))
        assert(Mappings.number().bind(JsDefined(JsString("-100")), Context.empty) == Success(-100))
      }

      "validates" - {
        assert(Mappings.number(min = 10).bind(JsDefined(JsNumber(9)), Context.empty) == Failure(Mapping.error("error.min", 10)))
        assert(Mappings.number(max = 10).bind(JsDefined(JsNumber(11)), Context.empty) == Failure(Mapping.error("error.max", 10)))
      }

      "binds invalid" - {
        assert(Mappings.number().bind(JsDefined(JsBoolean(true)), Context.empty) == Failure(Mapping.error("error.number")))
        assert(Mappings.number().bind(JsDefined(JsString("aaa")), Context.empty) == Failure(Mapping.error("error.number")))
      }

      "all errors" - {
        assert(Mappings.number().getAllErrors() == Set(ErrorSpec("error.number"), ErrorSpec("error.required")))
        assert(Mappings.number(min = 10).getAllErrors() == Set(ErrorSpec("error.number"), ErrorSpec("error.required"), ErrorSpec("error.min", 1)))
        assert(Mappings.number(max = 10).getAllErrors() == Set(ErrorSpec("error.number"), ErrorSpec("error.required"), ErrorSpec("error.max", 1)))
      }
    }

    "optional" - {
      "binds/unbinds empty" - {
        assert(Mappings.opt(Mappings.boolean).bind(JsUndefined(""), Context.empty) == Success(None))
        assert(Mappings.opt(Mappings.boolean).bind(JsDefined(JsNull), Context.empty) == Success(None))
        assert(Mappings.opt(Mappings.boolean).unbind(None) == JsNull)
      }

      "binds an empty string" - {
        // In Play's Form, an empty string is converted back to None.
        assert(Mappings.opt(Mappings.text, translateEmptyStringToNone = true).bind(JsDefined(JsString("")), Context.empty) == Success(None))
        // For the normal mode, we don't do that.
        assert(Mappings.opt(Mappings.text).bind(JsDefined(JsString("")), Context.empty) == Success(Some("")))
      }

      "binds/unbinds value" - {
        assert(Mappings.opt(Mappings.boolean).bind(JsDefined(JsBoolean(true)), Context.empty) == Success(Some(true)))
        assert(Mappings.opt(Mappings.boolean).unbind(Some(true)) == JsBoolean(true))
      }
    }

    "seq" - {
      "binds empty" - {
        assert(Mappings.seq(Mappings.boolean, nonEmpty = true).bind(JsDefined(JsArray()), Context.empty) == Failure(Mapping.error("error.required")))
        assert(Mappings.seq(Mappings.boolean).bind(JsDefined(JsNull), Context.empty) == Failure(Mapping.error("error.required")))
        assert(Mappings.seq(Mappings.boolean).bind(JsUndefined(""), Context.empty) == Failure(Mapping.error("error.required")))
      }

      "binds invalid element" - {
        val result = Mappings.seq(Mappings.boolean).bind(
          value = JsDefined(
            JsArray(Seq(
              JsString("invalid"),
              JsString("true"),
              JsNumber(2),
              JsString("false")
            ))
          ),
          context = Context.empty
        )
        val expected = Failure(
          new ValidationException(Seq(
            new ValidationMessage("item.error.boolean", 0),
            new ValidationMessage("item.error.boolean", 2)
          ))
        )
        assert(result == expected)
      }

      "binds/unbinds empty array" - {
        assert(Mappings.seq(Mappings.boolean, translateNoneToEmpty = true).bind(JsDefined(JsNull), Context.empty) == Success(Seq.empty))
        assert(Mappings.seq(Mappings.boolean, translateNoneToEmpty = true).bind(JsUndefined(""), Context.empty) == Success(Seq.empty))
        assert(Mappings.seq(Mappings.boolean).bind(JsDefined(JsArray()), Context.empty) == Success(Seq.empty))
        assert(Mappings.seq(Mappings.boolean).unbind(Seq.empty) == JsArray())
      }

      "binds/unbinds value" - {
        assert(Mappings.seq(Mappings.boolean, nonEmpty = true).bind(JsDefined(JsArray(Seq(JsBoolean(true)))), Context.empty) == Success(Seq(true)))
        assert(Mappings.seq(Mappings.boolean).bind(JsDefined(JsArray(Seq(JsBoolean(true), JsBoolean(false)))), Context.empty) == Success(Seq(true, false)))
        assert(Mappings.seq(Mappings.boolean).unbind(Seq(true, false)) == JsArray(Seq(JsBoolean(true), JsBoolean(false))))
      }

      "all errors" - {
        assert(Mappings.seq(Mappings.number(min = 10)).getAllErrors() == Set(
          ErrorSpec("error.required"),
          ErrorSpec("error.invalid"),
          ErrorSpec("item.error.required", 1),
          ErrorSpec("item.error.number", 1),
          ErrorSpec("item.error.min", 2),
        ))
      }
    }

    "obj" - {
      "binds invalid" - {
        case class Simple(b: Seq[Boolean])
        case class Complex(a: Seq[Simple])
        val m = Mappings.obj(
          Complex.apply,
          Complex.unapply,
          "a" -> Mappings.seq(Mappings.obj(
              Simple.apply,
              Simple.unapply,
              "b" -> Mappings.seq(Mappings.boolean)
            )
          )
        )
        val params = Json.obj(
          "a" -> Seq(Json.obj("b" -> Seq("invalid")), Json.obj("b" -> Seq("invalid", "invalid"))),
        )
        val expected = Failure(
          new ValidationException(Seq(
            new ValidationMessage("a.item.b.item.error.boolean", 0, 0),
            new ValidationMessage("a.item.b.item.error.boolean", 1, 0),
            new ValidationMessage("a.item.b.item.error.boolean", 1, 1)
          ))
        )
        assert(m.bind(JsDefined(params), Context.empty) == expected)
      }

      "binds/unbinds single" - {
        // A case class with one value is a special case because its unapply function doesn't return a tuple, so we explicitly test it.
        case class Obj(a: String)
        val m = Mappings.obj(
          Obj.apply,
          Obj.unapply,
          "a" -> Mappings.text()
        )
        val params = Json.obj("a" -> "value")
        val expected = Obj("value")
        assert(m.bind(JsDefined(params), Context.empty) == Success(expected))
        assert(m.unbind(expected) == params)
      }

      "binds/unbinds simple" - {
        case class Obj(a: String, n: Long)
        val m = Mappings.obj(
          Obj.apply,
          Obj.unapply,
          "a" -> Mappings.text(),
          "n" -> Mappings.longNumber()
        )
        val params = Json.obj("a" -> "value", "n" -> 100L)
        val expected = Obj("value", 100)
        assert(m.bind(JsDefined(params), Context.empty) == Success(expected))
        assert(m.unbind(expected) == params)
      }

      "binds/unbinds complex" - {
        case class Simple(b: Boolean)
        case class Complex(a: Seq[Simple], nOpt: Option[Long], s: Simple)
        val m = Mappings.obj(
          Complex.apply,
          Complex.unapply,
          "a" -> Mappings.seq(Mappings.obj(
            Simple.apply,
            Simple.unapply,
            "b" -> Mappings.boolean
          )),
          "n" -> Mappings.opt(Mappings.longNumber),
          "s" -> Mappings.obj(
            Simple.apply,
            Simple.unapply,
            "bb" -> Mappings.boolean
          )
        )
        val params = Json.obj(
          "a" -> Seq(Json.obj("b" -> false), Json.obj("b" -> true)),
          "n" -> 100L,
          "s" -> Json.obj("bb" -> false)
        )
        val expected = Complex(
          a = Seq(Simple(false), Simple(true)),
          nOpt = Some(100L),
          s = Simple(false)
        )
        assert(m.bind(JsDefined(params), Context.empty) == Success(expected))
        assert(m.unbind(expected) == params)
      }
    }
  }
}
