package givers.form

import scala.util.Try

// Using Context supports processing params in steps.
// A real world example:
//   we need a currency in order to construct a form that processes an amount.
//   Because, for example, KRW is a zero-decimal currency and doesn't need to be multiplied by 100, while
//   USD does.
object BindContext {
  val empty = BindContext(Map.empty, None)
}

case class BindContext(
  current: scala.collection.Map[String, Try[_]],
  parentOpt: Option[BindContext]
)

object UnbindContext {
  val empty = UnbindContext(Map.empty, None)
}
case class UnbindContext(
  current: scala.collection.Map[String, Any],
  parentOpt: Option[UnbindContext]
)
