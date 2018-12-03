package givers.form

import givers.form.Mapping.ErrorSpec
import givers.form.generated.Forms
import play.api.libs.json.{JsDefined, JsValue}

import scala.util.{Failure, Try}

object Form extends Forms {
  def apply[T](errorPrefix: String, mapping: Mapping[T]) = new Form(errorPrefix, mapping)
}

class Form[T](errorPrefix: String, mapping: Mapping[T]) {
  def bindFromRequest()(implicit request: play.api.mvc.Request[_]): Try[T] = {
    bind {
      request.body match {
        case body: play.api.mvc.AnyContent if body.asJson.isDefined => body.asJson.get
        case body: play.api.libs.json.JsValue => body
        case _ => throw new Exception("Unable to parse body as json.")
      }
    }
  }

  def bind(json: JsValue): Try[T] = {
    mapping
      .bind(JsDefined(json))
      .recoverWith { case e: ValidationException =>
        Failure(e.addPrefix(errorPrefix))
      }
  }

  def fill(data: T): FilledForm[T] = new FilledForm(mapping, data)

  def getAllErrors(): Set[ErrorSpec] = {
    mapping.getAllErrors().map { error =>
      error.addPrefix(errorPrefix)
    }
  }
}

class FilledForm[T](mapping: Mapping[T], data: T) {
  def toJson = mapping.unbind(data)
}
