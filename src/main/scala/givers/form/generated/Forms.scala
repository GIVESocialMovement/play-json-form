package givers.form.generated

import givers.form.Form

import givers.form.Mapping

trait Forms {
  def apply[T, A0](apply: (A0) => T, unapply: T => Option[(A0)], f0: (String, Mapping[A0])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0))
  }
  def apply[T, A0, A1](apply: (A0, A1) => T, unapply: T => Option[(A0, A1)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1))
  }
  def apply[T, A0, A1, A2](apply: (A0, A1, A2) => T, unapply: T => Option[(A0, A1, A2)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2))
  }
  def apply[T, A0, A1, A2, A3](apply: (A0, A1, A2, A3) => T, unapply: T => Option[(A0, A1, A2, A3)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3))
  }
  def apply[T, A0, A1, A2, A3, A4](apply: (A0, A1, A2, A3, A4) => T, unapply: T => Option[(A0, A1, A2, A3, A4)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4))
  }
  def apply[T, A0, A1, A2, A3, A4, A5](apply: (A0, A1, A2, A3, A4, A5) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6](apply: (A0, A1, A2, A3, A4, A5, A6) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7](apply: (A0, A1, A2, A3, A4, A5, A6, A7) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18]), f19: (String, Mapping[A19])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18]), f19: (String, Mapping[A19]), f20: (String, Mapping[A20])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20))
  }
  def apply[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18]), f19: (String, Mapping[A19]), f20: (String, Mapping[A20]), f21: (String, Mapping[A21])): Form[T] = {
    new Form(ObjectMappings.obj(apply, unapply, f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21))
  }
}