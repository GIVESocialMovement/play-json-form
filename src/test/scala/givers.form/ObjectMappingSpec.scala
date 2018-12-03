package givers.form

import givers.form.Mapping.ErrorSpec
import helpers.BaseSpec
import play.api.libs.json._
import utest.{Tests, _}

import scala.util.{Failure, Success}


object ObjectMappingSpec extends BaseSpec {
  val tests = Tests {
    "ObjectMapping" - {
      "converts" - {
        case class TestObj(a: String, b: Int, c: NestedObj)
        case class NestedObj(num: Int)
        val mapping = Mappings.obj(
          TestObj.apply,
          TestObj.unapply,
          "a" -> Mappings.text(allowEmpty = false),
          "b" -> Mappings.number(min = 10),
          "c" -> Mappings.obj(
            NestedObj.apply,
            NestedObj.unapply,
            "num" -> Mappings.number
          )
        )

        "lists all errors" - {
          println(mapping.getAllErrors() == Set(
            ErrorSpec("a.error.required"),
            ErrorSpec("b.error.required"),
            ErrorSpec("b.error.min", 1),
            ErrorSpec("b.error.number"),
            ErrorSpec("c.num.error.required"),
            ErrorSpec("c.num.error.number"),
          ))
        }

        "succeeds" - {
          val json = Json.obj("a" -> "value", "b" -> "11", "c" -> Json.obj("num" -> "12"))
          assert(mapping.bind(JsDefined(json)) == Success(TestObj("value", 11, NestedObj(12))))
        }

        "fails" - {
          val expected = new ValidationException(Seq(
            new ValidationMessage("a.error.required"),
            new ValidationMessage("b.error.min", 10),
            new ValidationMessage("c.num.error.number")
          ))
          val json = Json.obj("a" -> "", "b" -> "9", "c" -> Json.obj("num" -> "nan"))
          println(mapping.bind(JsDefined(json)))
          assert(mapping.bind(JsDefined(json)) == Failure(expected))
        }

        "partially fails" - {
          * - {
            val json = Json.obj("a" -> "", "b" -> "11", "c" -> Json.obj("num" -> "12"))
            val expected = new ValidationException(Seq(new ValidationMessage("a.error.required")))
            assert(mapping.bind(JsDefined(json)) == Failure(expected))
          }

          * - {
            val json = Json.obj("a" -> "v", "b" -> "9", "c" -> Json.obj("num" -> "12"))
            val expected = new ValidationException(Seq(new ValidationMessage("b.error.min", 10)))
            assert(mapping.bind(JsDefined(json)) == Failure(expected))
          }

          * - {
            val json = Json.obj("a" -> "v", "b" -> "19", "c" -> Json.obj("num" -> ""))
            val expected = new ValidationException(Seq(new ValidationMessage("c.num.error.number")))
            assert(mapping.bind(JsDefined(json)) == Failure(expected))
          }
        }
      }
    }
  }
}
