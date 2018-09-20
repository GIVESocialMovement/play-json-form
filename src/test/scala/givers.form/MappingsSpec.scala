package givers.form

import helpers.BaseSpec
import play.api.libs.json._
import utest.Tests
import utest._

import scala.util.{Failure, Success}


object MappingsSpec extends BaseSpec {
  val tests = Tests {
    "boolean" - {
      "binds/unbinds boolean" - {
        assert(Mappings.boolean.bind(JsDefined(JsBoolean(true))) == Success(true))
        assert(Mappings.boolean.unbind(true) == JsBoolean(true))
        assert(Mappings.boolean.bind(JsDefined(JsBoolean(false))) == Success(false))
        assert(Mappings.boolean.unbind(false) == JsBoolean(false))
      }

      "binds string" - {
        assert(Mappings.boolean.bind(JsDefined(JsString("true"))) == Success(true))
        assert(Mappings.boolean.bind(JsDefined(JsString("false"))) == Success(false))
      }

      "binds missing" - {
        assert(Mappings.boolean.bind(JsDefined(JsNull)) == Success(false))
        assert(Mappings.boolean.bind(JsUndefined("")) == Success(false))
      }

      "binds invalid" - {
        assert(Failure(Mapping.error("error.boolean")) == Mappings.boolean.bind(JsDefined(JsString("random"))))
        assert(Failure(Mapping.error("error.boolean")) == Mappings.boolean.bind(JsDefined(JsNumber(100L))))
      }
    }

    "email" - {
      "binds/unbind string" - {
        assert(Mappings.email.bind(JsDefined(JsString(" a@b "))) == Success("a@b"))
      }

      "binds invalid" - {
        assert(Mappings.email.bind(JsDefined(JsString(" ab "))) == Failure(Mapping.error("error.email")))
        assert(Mappings.email.bind(JsDefined(JsString(""))) == Failure(Mapping.error("error.email")))
      }
    }

    "text (not trimmed, allows empty)" - {
      "binds/unbinds string" - {
        assert(Mappings.text(trim = false).bind(JsDefined(JsString(""))) == Success(""))
        assert(Mappings.text(trim = false).bind(JsDefined(JsString(" txt "))) == Success(" txt "))
        assert(Mappings.text(trim = false).unbind(" txt ") == JsString(" txt "))
      }

      "binds invalid" - {
        assert(Mappings.text().bind(JsDefined(JsBoolean(true))) == Failure(Mapping.error("error.invalid")))
        assert(Mappings.text().bind(JsDefined(JsNumber(100L))) == Failure(Mapping.error("error.invalid")))
        assert(Mappings.text().bind(JsDefined(JsNumber(100L))) == Failure(Mapping.error("error.invalid")))
      }
    }

    "text (trimmed, limit length)" - {
      "binds/unbinds string" - {
        assert(Mappings.text(maxLength = 3).bind(JsDefined(JsString(" txt "))) == Success("txt"))
        assert(Mappings.text(maxLength = 3).unbind(" txt ") == JsString(" txt "))
      }

      "binds invalid" - {
        assert(Mappings.text(maxLength = 3).bind(JsDefined(JsString("aaaa"))) == Failure(Mapping.error("error.maxLength", 3)))
      }
    }

    "text (trimmed, forbids empty)" - {
      "binds/unbinds string" - {
        assert(Mappings.text(allowEmpty = false).bind(JsDefined(JsString(" txt "))) == Success("txt"))
        assert(Mappings.text(allowEmpty = false).unbind(" txt ") == JsString(" txt "))
      }

      "binds empty" - {
        assert(Mappings.text(allowEmpty = false).bind(JsDefined(JsString("  "))) == Failure(Mapping.error("error.required")))
      }
    }

    "long" - {
      "binds/unbinds number" - {
        assert(Mappings.longNumber(min = 99, max = 101).bind(JsDefined(JsNumber(100))) == Success(100L))
        assert(Mappings.longNumber().bind(JsDefined(JsNumber(100))) == Success(100L))
        assert(Mappings.longNumber().unbind(100L) == JsNumber(BigDecimal(100L)))
      }

      "binds string" - {
        assert(Mappings.longNumber().bind(JsDefined(JsString("100"))) == Success(100L))
        assert(Mappings.longNumber().bind(JsDefined(JsString("-100"))) == Success(-100L))
      }

      "validates" - {
        assert(Mappings.longNumber(min = 10L).bind(JsDefined(JsNumber(9L))) == Failure(Mapping.error("error.min", 10L)))
        assert(Mappings.longNumber(max = 10L).bind(JsDefined(JsNumber(11L))) == Failure(Mapping.error("error.max", 10L)))
      }

      "binds invalid" - {
        assert(Mappings.longNumber().bind(JsDefined(JsBoolean(true))) == Failure(Mapping.error("error.number")))
        assert(Mappings.longNumber().bind(JsDefined(JsString("aaa"))) == Failure(Mapping.error("error.number")))
      }
    }

    "int" - {
      "binds/unbinds number" - {
        assert(Mappings.number(min = 99, max = 101).bind(JsDefined(JsNumber(100))) == Success(100))
        assert(Mappings.number().bind(JsDefined(JsNumber(100))) == Success(100))
        assert(Mappings.number().unbind(100) == JsNumber(100))
      }

      "binds string" - {
        assert(Mappings.number().bind(JsDefined(JsString("100"))) == Success(100))
        assert(Mappings.number().bind(JsDefined(JsString("-100"))) == Success(-100))
      }

      "validates" - {
        assert(Mappings.number(min = 10).bind(JsDefined(JsNumber(9))) == Failure(Mapping.error("error.min", 10)))
        assert(Mappings.number(max = 10).bind(JsDefined(JsNumber(11))) == Failure(Mapping.error("error.max", 10)))
      }

      "binds invalid" - {
        assert(Mappings.number().bind(JsDefined(JsBoolean(true))) == Failure(Mapping.error("error.number")))
        assert(Mappings.number().bind(JsDefined(JsString("aaa"))) == Failure(Mapping.error("error.number")))
      }
    }

    "optional" - {
      "binds/unbinds empty" - {
        assert(Mappings.opt(Mappings.boolean).bind(JsUndefined("")) == Success(None))
        assert(Mappings.opt(Mappings.boolean).bind(JsDefined(JsNull)) == Success(None))
        assert(Mappings.opt(Mappings.boolean).unbind(None) == JsNull)
      }

      "binds an empty string" - {
        // In Play's Form, an empty string is converted back to None.
        assert(Mappings.opt(Mappings.text, translateEmptyStringToNone = true).bind(JsDefined(JsString(""))) == Success(None))
        // For the normal mode, we don't do that.
        assert(Mappings.opt(Mappings.text).bind(JsDefined(JsString(""))) == Success(Some("")))
      }

      "binds/unbinds value" - {
        assert(Mappings.opt(Mappings.boolean).bind(JsDefined(JsBoolean(true))) == Success(Some(true)))
        assert(Mappings.opt(Mappings.boolean).unbind(Some(true)) == JsBoolean(true))
      }
    }

    "seq" - {
      "binds invalid" - {
        assert(Mappings.seq(Mappings.boolean, nonEmpty = true).bind(JsDefined(JsArray())) == Failure(Mapping.error("error.required")))
        assert(Mappings.seq(Mappings.boolean).bind(JsDefined(JsNull)) == Failure(Mapping.error("error.required")))
        assert(Mappings.seq(Mappings.boolean).bind(JsUndefined("")) == Failure(Mapping.error("error.required")))
      }

      "binds/unbinds empty array" - {
        assert(Mappings.seq(Mappings.boolean, translateNoneToEmpty = true).bind(JsDefined(JsNull)) == Success(Seq.empty))
        assert(Mappings.seq(Mappings.boolean, translateNoneToEmpty = true).bind(JsUndefined("")) == Success(Seq.empty))
        assert(Mappings.seq(Mappings.boolean).bind(JsDefined(JsArray())) == Success(Seq.empty))
        assert(Mappings.seq(Mappings.boolean).unbind(Seq.empty) == JsArray())
      }

      "binds/unbinds value" - {
        assert(Mappings.seq(Mappings.boolean, nonEmpty = true).bind(JsDefined(JsArray(Seq(JsBoolean(true))))) == Success(Seq(true)))
        assert(Mappings.seq(Mappings.boolean).bind(JsDefined(JsArray(Seq(JsBoolean(true), JsBoolean(false))))) == Success(Seq(true, false)))
        assert(Mappings.seq(Mappings.boolean).unbind(Seq(true, false)) == JsArray(Seq(JsBoolean(true), JsBoolean(false))))
      }
    }

    "obj" - {
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
        assert(m.bind(JsDefined(params)) == Success(expected))
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
        assert(m.bind(JsDefined(params)) == Success(expected))
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
        assert(m.bind(JsDefined(params)) == Success(expected))
        assert(m.unbind(expected) == params)
      }
    }
  }
}
