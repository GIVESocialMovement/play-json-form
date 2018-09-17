package givers.form

import helpers.BaseSpec
import play.api.libs.json._
import play.api.test.FakeRequest
import utest.{Tests, _}

import scala.util.{Failure, Success}


object FormSpec extends BaseSpec {

  case class TestObj(a: String, b: Int)
  val form = Form(
    TestObj.apply,
    TestObj.unapply,
    "a" -> Mappings.text(allowEmpty = false),
    "b" -> Mappings.number()
  )
  val obj = TestObj("test", 123)
  val json = Json.obj("a" -> "test", "b" -> 123)

  val tests = Tests {
    "Form" - {
      "bindFromRequest" - {
        "binds JsValue" - {
          val req = FakeRequest("POST", "/").withBody(json)
          assert(form.bindFromRequest()(req) == Success(obj))
        }

        "binds AnyContent" - {
          val req = FakeRequest("POST", "/").withJsonBody(json)
          assert(form.bindFromRequest()(req) == Success(obj))
        }

        "binds invalid" - {
          * - {
            val req = FakeRequest("POST", "/").withTextBody("random")
            val ex = intercept[Exception](form.bindFromRequest()(req))
            assert(ex.getMessage == "Unable to parse body as json.")
          }

          * - {
            val req = FakeRequest("POST", "/").withBody(JsString("random"))
            assert(form.bindFromRequest()(req) == Failure(new ValidationException(Seq(
              new ValidationMessage("a", "error.required"),
              new ValidationMessage("b", "error.required")
            ))))
          }
        }
      }

      "binds and fills" - {

        assert(form.fill(obj).toJson == json)
        assert(form.bind(json) == Success(obj))
      }
    }
  }
}
