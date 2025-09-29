package givers.form

import scala.deriving.Mirror

object Utils {
  // scala2 like unapply method (without Option)
  def unapply[T <: Product](using mirror: Mirror.ProductOf[T]): T => mirror.MirroredElemTypes = Tuple.fromProductTyped
}
