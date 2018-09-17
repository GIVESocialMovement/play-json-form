package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import givers.form.{Form, Mapping, ValidationException}
import givers.form.Mappings._
import play.api.libs.json.Json

case class Product(itemName: String, price: Long)

object HomeController {
  val priceRegex = "^([0-9]+).([0-9][0-9])$".r

  val price = text.transform[Long](
    bind = {
      case priceRegex(whole, decimals) => Success(whole.toLong * 100 + decimals.toLong)
      case _ => Failure(Mapping.error("error.number"))
    },
    unbind = { cents => s"${cents / 100}.${(cents % 100).formatted("%02d")}" }
  )

  val form = Form(
    mapping(
      "name" -> text(allowEmpty = false),
      "price" -> price
    )(Product.apply)(Product.unapply)
  )
}

@Singleton
class HomeController @Inject()()(
  implicit ec: ExecutionContext,
  cc: ControllerComponents
) extends AbstractController(cc) {

  import HomeController._

  def showForm = Action { _ =>
    Ok(views.html.index(
      form.fill(Product("iphone", 59999L)).toJson
    ))
  }

  def submit = Action(parse.json) { implicit request =>
    form.bindFromRequest() match {
      case Success(data) =>
        println(data)
        Ok(Json.obj("success" -> true))
      case Failure(e: ValidationException) =>
        Ok(Json.obj("success" -> false, "messages" -> e.messages.map { m => s"${m.key}.${m.message}" }))
      case Failure(e) =>
        Ok(Json.obj("success" -> false, "messages" -> Seq(e.getMessage)))
    }
  }
}
