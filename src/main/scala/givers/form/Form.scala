package givers.form

import givers.form.generated.Forms
import play.api.libs.json.{JsDefined, JsValue}

import scala.util.Try

object Form extends Forms {
  def apply[T](mapping: ObjectMapping[T]) = new Form(mapping)
}

class Form[T](mapping: ObjectMapping[T]) {
  def bindFromRequest()(implicit request: play.api.mvc.Request[_]): Try[T] = {
    bind {
      request.body match {
        case body: play.api.mvc.AnyContent if body.asJson.isDefined => body.asJson.get
        case body: play.api.libs.json.JsValue => body
        case _ => throw new Exception("Unable to parse body as json.")
      }
    }
  }

  def bind(json: JsValue): Try[T] = mapping.bind(JsDefined(json))

  def fill(data: T): FilledForm[T] = new FilledForm(mapping, data)
}

class FilledForm[T](mapping: ObjectMapping[T], data: T) {
  def toJson = mapping.unbind(data)
}
