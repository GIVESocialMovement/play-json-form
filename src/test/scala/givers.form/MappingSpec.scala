package givers.form

import givers.form.helpers.BaseSpec
import play.api.libs.json._
import utest.Tests
import utest._

import scala.util.{Failure, Success, Try}

object MappingSpec extends BaseSpec {
  val tests = Tests {
    "ValueMapping" - {
      val mapping = new ValueMapping[Boolean] {
        protected[this] def bind(value: JsValue, context: BindContext): Try[Boolean] = Success(true)
        def unbind(value: Boolean, context: UnbindContext): JsValue = JsBoolean(true)
      }

      "binds/unbind" - {
        assert(mapping.bind(JsDefined(JsString("dontcare")), BindContext.empty) == Success(true))
        assert(mapping.unbind(false, UnbindContext.empty) == JsBoolean(true))
      }

      "binds empty" - {
        assert(mapping.bind(JsUndefined(""), BindContext.empty) == Failure(Mapping.error("error.required")))
        assert(mapping.bind(JsDefined(JsNull), BindContext.empty) == Failure(Mapping.error("error.required")))
      }
    }

    "Mapping" - {
      val mapping = new Mapping[String] {
        def bind(value: JsLookupResult, context: BindContext): Try[String] = Success(value.as[String])
        def unbind(value: String, context: UnbindContext): JsValue = JsString(value)
      }

      "validates" - {
        val validator = mock[String => Boolean]
        val validatedMapping = mapping.validate("error")(validator.apply)

        "succeeds" - {
          when(validator.apply(any())).thenReturn(true)
          assert(validatedMapping.bind(JsDefined(JsString("input")), BindContext.empty) == Success("input"))

          verify(validator).apply("input")
        }

        "fails" - {
          when(validator.apply(any())).thenReturn(false)
          assert(validatedMapping.bind(JsDefined(JsString("input")), BindContext.empty) == Failure(Mapping.error("error")))

          verify(validator).apply("input")
        }
      }

      "transform" - {
        val transformedMapping = mapping.transform[String](
          bind = { (s, _) =>
            if (s == "shouldFail") {
              Failure(Mapping.error("error"))
            } else {
              Success(s"bound $s")
            }
          },
          unbind = { (s, _) => s"unbound $s"}
        )

        "binds" - {
          assert(transformedMapping.bind(JsDefined(JsString("input")), BindContext.empty) == Success("bound input"))
          assert(transformedMapping.bind(JsDefined(JsString("shouldFail")), BindContext.empty) == Failure(Mapping.error("error")))
        }

        "unbinds" - {
          assert(transformedMapping.unbind("input", UnbindContext.empty) == JsString("unbound input"))
        }
      }
    }
  }
}
