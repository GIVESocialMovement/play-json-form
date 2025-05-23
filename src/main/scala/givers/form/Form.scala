package givers.form

import givers.form.Mapping.{ErrorSpec, Field}
import givers.form.generated.Forms
import play.api.libs.json.{JsDefined, JsValue}

import scala.reflect.ClassTag
import scala.reflect.runtime.universe.TypeTag
import scala.util.{Failure, Try}

object Form extends Forms {
  def apply[T](errorPrefix: String, mapping: Mapping[T]) = new Form(errorPrefix, mapping)

  def apply[T: TypeTag: ClassTag](errorPrefix: String, mappings: Seq[(String, Mapping[_])]): Form[T] = {
    new Form(errorPrefix, new ObjectMappingList[T](mappings.map { m => Field(m._1, m._2) }))
  }
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
      .bind(JsDefined(json), BindContext.empty)
      .recoverWith { case e: ValidationException =>
        assert(e.messages.nonEmpty, "The form is misconfigured. UnapplicableException is raised incorrectly.")
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
  def toJson = mapping.unbind(data, UnbindContext.empty)
}
