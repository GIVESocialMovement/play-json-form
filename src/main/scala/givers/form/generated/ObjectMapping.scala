package givers.form.generated

import givers.form.Mapping.Field

import givers.form.ObjectMapping

import givers.form.BindContext

import givers.form.UnbindContext

import play.api.libs.json.JsValue

import play.api.libs.json.JsObject

import play.api.libs.json.Json

import scala.util.Try

class ObjectMapping1[T, A0](apply: (A0) => T, unapply: T => Option[(A0)], f0: Field[A0]) extends ObjectMapping[T] {
  val fields = Seq(f0)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = Seq(valueTuple)
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping2[T, A0, A1](apply: (A0, A1) => T, unapply: T => Option[(A0, A1)], f0: Field[A0], f1: Field[A1]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping3[T, A0, A1, A2](apply: (A0, A1, A2) => T, unapply: T => Option[(A0, A1, A2)], f0: Field[A0], f1: Field[A1], f2: Field[A2]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping4[T, A0, A1, A2, A3](apply: (A0, A1, A2, A3) => T, unapply: T => Option[(A0, A1, A2, A3)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping5[T, A0, A1, A2, A3, A4](apply: (A0, A1, A2, A3, A4) => T, unapply: T => Option[(A0, A1, A2, A3, A4)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping6[T, A0, A1, A2, A3, A4, A5](apply: (A0, A1, A2, A3, A4, A5) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping7[T, A0, A1, A2, A3, A4, A5, A6](apply: (A0, A1, A2, A3, A4, A5, A6) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping8[T, A0, A1, A2, A3, A4, A5, A6, A7](apply: (A0, A1, A2, A3, A4, A5, A6, A7) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping9[T, A0, A1, A2, A3, A4, A5, A6, A7, A8](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping10[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping11[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping12[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping13[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11], f12: Field[A12]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11], items(12).asInstanceOf[A12]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping14[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11], f12: Field[A12], f13: Field[A13]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11], items(12).asInstanceOf[A12], items(13).asInstanceOf[A13]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping15[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11], f12: Field[A12], f13: Field[A13], f14: Field[A14]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11], items(12).asInstanceOf[A12], items(13).asInstanceOf[A13], items(14).asInstanceOf[A14]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping16[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11], f12: Field[A12], f13: Field[A13], f14: Field[A14], f15: Field[A15]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11], items(12).asInstanceOf[A12], items(13).asInstanceOf[A13], items(14).asInstanceOf[A14], items(15).asInstanceOf[A15]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping17[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11], f12: Field[A12], f13: Field[A13], f14: Field[A14], f15: Field[A15], f16: Field[A16]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11], items(12).asInstanceOf[A12], items(13).asInstanceOf[A13], items(14).asInstanceOf[A14], items(15).asInstanceOf[A15], items(16).asInstanceOf[A16]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping18[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11], f12: Field[A12], f13: Field[A13], f14: Field[A14], f15: Field[A15], f16: Field[A16], f17: Field[A17]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11], items(12).asInstanceOf[A12], items(13).asInstanceOf[A13], items(14).asInstanceOf[A14], items(15).asInstanceOf[A15], items(16).asInstanceOf[A16], items(17).asInstanceOf[A17]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping19[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11], f12: Field[A12], f13: Field[A13], f14: Field[A14], f15: Field[A15], f16: Field[A16], f17: Field[A17], f18: Field[A18]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11], items(12).asInstanceOf[A12], items(13).asInstanceOf[A13], items(14).asInstanceOf[A14], items(15).asInstanceOf[A15], items(16).asInstanceOf[A16], items(17).asInstanceOf[A17], items(18).asInstanceOf[A18]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping20[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11], f12: Field[A12], f13: Field[A13], f14: Field[A14], f15: Field[A15], f16: Field[A16], f17: Field[A17], f18: Field[A18], f19: Field[A19]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11], items(12).asInstanceOf[A12], items(13).asInstanceOf[A13], items(14).asInstanceOf[A14], items(15).asInstanceOf[A15], items(16).asInstanceOf[A16], items(17).asInstanceOf[A17], items(18).asInstanceOf[A18], items(19).asInstanceOf[A19]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping21[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11], f12: Field[A12], f13: Field[A13], f14: Field[A14], f15: Field[A15], f16: Field[A16], f17: Field[A17], f18: Field[A18], f19: Field[A19], f20: Field[A20]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11], items(12).asInstanceOf[A12], items(13).asInstanceOf[A13], items(14).asInstanceOf[A14], items(15).asInstanceOf[A15], items(16).asInstanceOf[A16], items(17).asInstanceOf[A17], items(18).asInstanceOf[A18], items(19).asInstanceOf[A19], items(20).asInstanceOf[A20]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}

class ObjectMapping22[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)], f0: Field[A0], f1: Field[A1], f2: Field[A2], f3: Field[A3], f4: Field[A4], f5: Field[A5], f6: Field[A6], f7: Field[A7], f8: Field[A8], f9: Field[A9], f10: Field[A10], f11: Field[A11], f12: Field[A12], f13: Field[A13], f14: Field[A14], f15: Field[A15], f16: Field[A16], f17: Field[A17], f18: Field[A18], f19: Field[A19], f20: Field[A20], f21: Field[A21]) extends ObjectMapping[T] {
  val fields = Seq(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21)
  def bind(value: JsValue, context: BindContext): Try[T] = {
    ObjectMapping.bind(value, fields, context).map(items => apply(items(0).asInstanceOf[A0], items(1).asInstanceOf[A1], items(2).asInstanceOf[A2], items(3).asInstanceOf[A3], items(4).asInstanceOf[A4], items(5).asInstanceOf[A5], items(6).asInstanceOf[A6], items(7).asInstanceOf[A7], items(8).asInstanceOf[A8], items(9).asInstanceOf[A9], items(10).asInstanceOf[A10], items(11).asInstanceOf[A11], items(12).asInstanceOf[A12], items(13).asInstanceOf[A13], items(14).asInstanceOf[A14], items(15).asInstanceOf[A15], items(16).asInstanceOf[A16], items(17).asInstanceOf[A17], items(18).asInstanceOf[A18], items(19).asInstanceOf[A19], items(20).asInstanceOf[A20], items(21).asInstanceOf[A21]))
  }
  def unbind(value: T, context: UnbindContext): JsValue = {
    val valueTuple = unapply(value).get
    val values = valueTuple.productIterator.toList
    ObjectMapping.unbind(values, fields, context)
  }
}