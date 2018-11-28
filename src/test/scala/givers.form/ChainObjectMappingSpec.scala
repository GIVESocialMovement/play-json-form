package givers.form

import helpers.BaseSpec
import play.api.libs.json.{JsDefined, Json}
import utest.{Tests, _}

import scala.util.{Failure, Success}

object ChainObjectMappingSpec extends BaseSpec {

  case class FirstStep(value: String)
  case class SecondStep(first: String, value: Int)
  case class ThirdStep(first: String, second: Int, value: Boolean)
  val mapping = Mappings
    .obj(
      FirstStep.apply,
      FirstStep.unapply,
      "first" -> Mappings.text(allowEmpty = false)
    )
    .andThen[SecondStep](
      bind = { first =>
        Mappings.obj(
          SecondStep.apply,
          SecondStep.unapply,
          "first" -> Mappings.text.pipe[String]({ _ => first.value }, identity),
          "second" -> Mappings.number
        )
      },
      unbind = { second => FirstStep(second.first) }
    )
    .andThen[ThirdStep](
      bind = { second =>
        Mappings.obj(
          ThirdStep.apply,
          ThirdStep.unapply,
          "first" -> Mappings.text.pipe[String]({ _ => second.first }, identity),
          "second" -> Mappings.number.pipe[Int]({ _ => second.value }, identity),
          "third" -> Mappings.boolean
        )
      },
      unbind = { third => SecondStep(third.first, third.second) }
    )

  val tests = Tests {
    "ChainedObjectMapping" - {
      "bind" - {
        val json = Json.obj("first" -> "test", "second" -> 123, "third" -> true)
        assert(mapping.bind(JsDefined(json)) == Success(ThirdStep("test", 123, true)))
      }

      "fails on first" - {
        val json = Json.obj("first" -> "")
        assert(mapping.bind(JsDefined(json)) == Failure(new ValidationException(Seq(new ValidationMessage("first", "error.required")))))
      }

      "fails on second" - {
        val json = Json.obj("first" -> "test", "second" -> "aaa")
        assert(mapping.bind(JsDefined(json)) == Failure(new ValidationException(Seq(new ValidationMessage("second", "error.number")))))
      }

      "fails on third" - {
        val json = Json.obj("first" -> "test", "second" -> "123", "third" -> "hello")
        assert(mapping.bind(JsDefined(json)) == Failure(new ValidationException(Seq(new ValidationMessage("third", "error.boolean")))))
      }

      "unbind" - {
        assert(mapping.unbind(ThirdStep("test", 123, true)) == Json.obj("first" -> "test", "second" -> 123, "third" -> true))
      }
    }
  }
}
