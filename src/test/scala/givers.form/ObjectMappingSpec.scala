package givers.form

import givers.form.Mapping.Field
import givers.form.generated.ObjectMapping2
import helpers.BaseSpec
import play.api.libs.json._
import utest.{Tests, _}

import scala.util.{Failure, Success}


object ObjectMappingSpec extends BaseSpec {
  val tests = Tests {
    "ObjectMapping" - {
      "converts" - {
        case class TestObj(a: String, b: Int)
        val mapping = new ObjectMapping2(
          TestObj.apply,
          TestObj.unapply,
          Field("a" -> Mappings.text(allowEmpty = false)),
          Field("b" -> Mappings.number(min = 10))
        )

        "succeeds" - {
          assert(mapping.bind(JsDefined(Json.obj("a" -> "value", "b" -> "11"))) == Success(TestObj("value", 11)))
        }

        "fails" - {
          val expected = new ValidationException(Seq(
            new ValidationMessage("a", "error.required"),
            new ValidationMessage("b", "error.min", 10)
          ))
          assert(mapping.bind(JsDefined(Json.obj("a" -> "", "b" -> "9"))) == Failure(expected))
        }

        "partially fails" - {
          * - {
            val expected = new ValidationException(Seq(new ValidationMessage("a", "error.required")))
            assert(mapping.bind(JsDefined(Json.obj("a" -> "", "b" -> "11"))) == Failure(expected))
          }

          * - {
            val expected = new ValidationException(Seq(new ValidationMessage("b", "error.min", 10)))
            assert(mapping.bind(JsDefined(Json.obj("a" -> "v", "b" -> "9"))) == Failure(expected))
          }
        }
      }
    }
  }
}
