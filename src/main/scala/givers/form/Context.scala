package givers.form

import scala.util.Try

object Context {
  val empty = Context(Map.empty, None)
}

// Using Context supports processing params in steps.
// A real world example:
//   we need a currency in order to construct a form that processes an amount.
//   Because, for example, KRW is a zero-decimal currency and doesn't need to be multiplied by 100, while
//   USD does.
case class Context(
  current: Map[String, Try[_]],
  parentOpt: Option[Context]
)
