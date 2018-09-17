package givers.form

import helpers.BaseSpec
import play.api.libs.json._
import utest.Tests
import utest._

import scala.util.{Failure, Success, Try}

object MappingSpec extends BaseSpec {
  val tests = Tests {
    "ValueMapping" - {
      val mapping = new ValueMapping[Boolean] {
        protected[this] def bind(value: JsValue): Try[Boolean] = Success(true)
        def unbind(value: Boolean): JsValue = JsBoolean(true)
      }

      "binds/unbind" - {
        assert(mapping.bind(JsDefined(JsString("dontcare"))) == Success(true))
        assert(mapping.unbind(false) == JsBoolean(true))
      }

      "binds empty" - {
        assert(mapping.bind(JsUndefined("")) == Failure(Mapping.error("error.required")))
        assert(mapping.bind(JsDefined(JsNull)) == Failure(Mapping.error("error.required")))
      }
    }

    "Mapping" - {
      val mapping = new Mapping[String] {
        def bind(value: JsLookupResult): Try[String] = Success(value.as[String])
        def unbind(value: String): JsValue = JsString(value)
      }

      "validates" - {
        val validator = mock[String => Boolean]
        val validatedMapping = mapping.validate("error")(validator.apply)

        "succeeds" - {
          when(validator.apply(any())).thenReturn(true)
          assert(validatedMapping.bind(JsDefined(JsString("input"))) == Success("input"))

          verify(validator).apply("input")
        }

        "fails" - {
          when(validator.apply(any())).thenReturn(false)
          assert(validatedMapping.bind(JsDefined(JsString("input"))) == Failure(Mapping.error("error")))

          verify(validator).apply("input")
        }
      }

      "transform" - {
        val transformedMapping = mapping.transform[String](
          bind = { s =>
            if (s == "shouldFail") {
              Failure(Mapping.error("error"))
            } else {
              Success(s"bound $s")
            }
          },
          unbind = { s => s"unbound $s"}
        )

        "binds" - {
          assert(transformedMapping.bind(JsDefined(JsString("input"))) == Success("bound input"))
          assert(transformedMapping.bind(JsDefined(JsString("shouldFail"))) == Failure(Mapping.error("error")))
        }

        "unbinds" - {
          assert(transformedMapping.unbind("input") == JsString("unbound input"))
        }
      }
    }
  }
}
