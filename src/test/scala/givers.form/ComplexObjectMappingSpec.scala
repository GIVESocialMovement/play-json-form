package givers.form

import givers.form.Mapping.ErrorSpec
import helpers.BaseSpec
import play.api.libs.json.{JsDefined, Json}
import utest.{Tests, _}

import scala.util.{Failure, Success}

object ComplexObjectMappingSpec extends BaseSpec {

  case class Nested(third: String)
  case class Complex(first: String, second: String, nested: Nested)
  val mapping = Mappings
    .obj(
      Complex.apply,
      Complex.unapply,
      "first" -> Mappings.text(allowEmpty = false),
      "second" -> Mappings.text(allowEmpty = false).transform[String](
        bind = { (value, context) =>
          context.current("first") match {
            case Success(first) => Success(s"$value-$first")
            case _ => Failure(NotApplicableException)
          }
        },
        unbind = { (value, context) =>
          if (context.current.get("first").contains("f")) {
            value.split("-").head
          } else {
            "first-is-not-f"
          }
        }
      ),
      "nested" -> Mappings.obj(
        Nested.apply,
        Nested.unapply,
        "third"  -> Mappings.text(allowEmpty = false).transform[String](
          bind = { (value, context) =>
            context.parentOpt.map(_.current("second")) match {
              case Some(Success(second)) => Success(s"$value-$second")
              case _ => Failure(NotApplicableException)
            }
          },
          unbind = { (value, _) => value.split("-").head }
        )
      )
    )

  val tests = Tests {
    "ComplexObjectMapping" - {
      "bind" - {
        val json = Json.obj("first" -> "f", "second" -> "s", "nested" -> Json.obj("third" -> "t"))
        assert(mapping.bind(JsDefined(json), BindContext.empty) == Success(Complex("f", "s-f", Nested("t-s-f"))))
      }

      "fails on first" - {
        val json = Json.obj("first" -> "", "second" -> "s",  "nested" -> Json.obj("third" -> "t"))
        assert(mapping.bind(JsDefined(json), BindContext.empty) == Failure(new ValidationException(Seq(new ValidationMessage("first.error.required")))))
      }

      "fails on second" - {
        val json = Json.obj("first" -> "f", "second" -> "",  "nested" -> Json.obj("third" -> "t"))
        assert(mapping.bind(JsDefined(json), BindContext.empty) == Failure(new ValidationException(Seq(new ValidationMessage("second.error.required")))))
      }

      "fails on third" - {
        val json = Json.obj("first" -> "f", "second" -> "s",  "nested" -> Json.obj("third" -> ""))
        assert(mapping.bind(JsDefined(json), BindContext.empty) == Failure(new ValidationException(Seq(new ValidationMessage("nested.third.error.required")))))
      }

      "unbind" - {
        assert(mapping.unbind(Complex("f", "s-f", Nested("t-s-f")), UnbindContext.empty) == Json.obj("first" -> "f", "second" -> "s", "nested" -> Json.obj("third" -> "t")))
        assert(mapping.unbind(Complex("a", "s-a", Nested("t-s-a")), UnbindContext.empty) == Json.obj("first" -> "a", "second" -> "first-is-not-f", "nested" -> Json.obj("third" -> "t")))
      }

      "all errors" - {
        assert(mapping.getAllErrors() == Set(
          ErrorSpec("first.error.required"),
          ErrorSpec("second.error.required"),
          ErrorSpec("nested.third.error.required"),
        ))
      }
    }
  }
}
