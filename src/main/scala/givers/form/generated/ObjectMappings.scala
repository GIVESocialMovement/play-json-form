package givers.form.generated

import givers.form.Mapping.Field

import givers.form.ObjectMapping

import givers.form.Mapping

trait ObjectMappings {
  def obj[T, A0](apply: (A0) => T, unapply: T => Option[(A0)], f0: (String, Mapping[A0])): ObjectMapping[T] = {
    new ObjectMapping1(apply, unapply, Field(f0))
  }
  def mapping[T, A0](f0: (String, Mapping[A0]))(apply: (A0) => T)(unapply: T => Option[(A0)]): ObjectMapping[T] = {
    new ObjectMapping1(apply, unapply, Field(f0))
  }
  def obj[T, A0, A1](apply: (A0, A1) => T, unapply: T => Option[(A0, A1)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1])): ObjectMapping[T] = {
    new ObjectMapping2(apply, unapply, Field(f0), Field(f1))
  }
  def mapping[T, A0, A1](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]))(apply: (A0, A1) => T)(unapply: T => Option[(A0, A1)]): ObjectMapping[T] = {
    new ObjectMapping2(apply, unapply, Field(f0), Field(f1))
  }
  def obj[T, A0, A1, A2](apply: (A0, A1, A2) => T, unapply: T => Option[(A0, A1, A2)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2])): ObjectMapping[T] = {
    new ObjectMapping3(apply, unapply, Field(f0), Field(f1), Field(f2))
  }
  def mapping[T, A0, A1, A2](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]))(apply: (A0, A1, A2) => T)(unapply: T => Option[(A0, A1, A2)]): ObjectMapping[T] = {
    new ObjectMapping3(apply, unapply, Field(f0), Field(f1), Field(f2))
  }
  def obj[T, A0, A1, A2, A3](apply: (A0, A1, A2, A3) => T, unapply: T => Option[(A0, A1, A2, A3)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3])): ObjectMapping[T] = {
    new ObjectMapping4(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3))
  }
  def mapping[T, A0, A1, A2, A3](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]))(apply: (A0, A1, A2, A3) => T)(unapply: T => Option[(A0, A1, A2, A3)]): ObjectMapping[T] = {
    new ObjectMapping4(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3))
  }
  def obj[T, A0, A1, A2, A3, A4](apply: (A0, A1, A2, A3, A4) => T, unapply: T => Option[(A0, A1, A2, A3, A4)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4])): ObjectMapping[T] = {
    new ObjectMapping5(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4))
  }
  def mapping[T, A0, A1, A2, A3, A4](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]))(apply: (A0, A1, A2, A3, A4) => T)(unapply: T => Option[(A0, A1, A2, A3, A4)]): ObjectMapping[T] = {
    new ObjectMapping5(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4))
  }
  def obj[T, A0, A1, A2, A3, A4, A5](apply: (A0, A1, A2, A3, A4, A5) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5])): ObjectMapping[T] = {
    new ObjectMapping6(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]))(apply: (A0, A1, A2, A3, A4, A5) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5)]): ObjectMapping[T] = {
    new ObjectMapping6(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6](apply: (A0, A1, A2, A3, A4, A5, A6) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6])): ObjectMapping[T] = {
    new ObjectMapping7(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]))(apply: (A0, A1, A2, A3, A4, A5, A6) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6)]): ObjectMapping[T] = {
    new ObjectMapping7(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7](apply: (A0, A1, A2, A3, A4, A5, A6, A7) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7])): ObjectMapping[T] = {
    new ObjectMapping8(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7)]): ObjectMapping[T] = {
    new ObjectMapping8(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8])): ObjectMapping[T] = {
    new ObjectMapping9(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8)]): ObjectMapping[T] = {
    new ObjectMapping9(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9])): ObjectMapping[T] = {
    new ObjectMapping10(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9)]): ObjectMapping[T] = {
    new ObjectMapping10(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10])): ObjectMapping[T] = {
    new ObjectMapping11(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)]): ObjectMapping[T] = {
    new ObjectMapping11(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11])): ObjectMapping[T] = {
    new ObjectMapping12(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)]): ObjectMapping[T] = {
    new ObjectMapping12(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12])): ObjectMapping[T] = {
    new ObjectMapping13(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)]): ObjectMapping[T] = {
    new ObjectMapping13(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13])): ObjectMapping[T] = {
    new ObjectMapping14(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)]): ObjectMapping[T] = {
    new ObjectMapping14(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14])): ObjectMapping[T] = {
    new ObjectMapping15(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)]): ObjectMapping[T] = {
    new ObjectMapping15(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15])): ObjectMapping[T] = {
    new ObjectMapping16(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)]): ObjectMapping[T] = {
    new ObjectMapping16(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16])): ObjectMapping[T] = {
    new ObjectMapping17(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)]): ObjectMapping[T] = {
    new ObjectMapping17(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17])): ObjectMapping[T] = {
    new ObjectMapping18(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16), Field(f17))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)]): ObjectMapping[T] = {
    new ObjectMapping18(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16), Field(f17))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18])): ObjectMapping[T] = {
    new ObjectMapping19(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16), Field(f17), Field(f18))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)]): ObjectMapping[T] = {
    new ObjectMapping19(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16), Field(f17), Field(f18))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18]), f19: (String, Mapping[A19])): ObjectMapping[T] = {
    new ObjectMapping20(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16), Field(f17), Field(f18), Field(f19))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18]), f19: (String, Mapping[A19]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)]): ObjectMapping[T] = {
    new ObjectMapping20(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16), Field(f17), Field(f18), Field(f19))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18]), f19: (String, Mapping[A19]), f20: (String, Mapping[A20])): ObjectMapping[T] = {
    new ObjectMapping21(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16), Field(f17), Field(f18), Field(f19), Field(f20))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18]), f19: (String, Mapping[A19]), f20: (String, Mapping[A20]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)]): ObjectMapping[T] = {
    new ObjectMapping21(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16), Field(f17), Field(f18), Field(f19), Field(f20))
  }
  def obj[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => T, unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)], f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18]), f19: (String, Mapping[A19]), f20: (String, Mapping[A20]), f21: (String, Mapping[A21])): ObjectMapping[T] = {
    new ObjectMapping22(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16), Field(f17), Field(f18), Field(f19), Field(f20), Field(f21))
  }
  def mapping[T, A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](f0: (String, Mapping[A0]), f1: (String, Mapping[A1]), f2: (String, Mapping[A2]), f3: (String, Mapping[A3]), f4: (String, Mapping[A4]), f5: (String, Mapping[A5]), f6: (String, Mapping[A6]), f7: (String, Mapping[A7]), f8: (String, Mapping[A8]), f9: (String, Mapping[A9]), f10: (String, Mapping[A10]), f11: (String, Mapping[A11]), f12: (String, Mapping[A12]), f13: (String, Mapping[A13]), f14: (String, Mapping[A14]), f15: (String, Mapping[A15]), f16: (String, Mapping[A16]), f17: (String, Mapping[A17]), f18: (String, Mapping[A18]), f19: (String, Mapping[A19]), f20: (String, Mapping[A20]), f21: (String, Mapping[A21]))(apply: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => T)(unapply: T => Option[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)]): ObjectMapping[T] = {
    new ObjectMapping22(apply, unapply, Field(f0), Field(f1), Field(f2), Field(f3), Field(f4), Field(f5), Field(f6), Field(f7), Field(f8), Field(f9), Field(f10), Field(f11), Field(f12), Field(f13), Field(f14), Field(f15), Field(f16), Field(f17), Field(f18), Field(f19), Field(f20), Field(f21))
  }
}

object ObjectMappings extends ObjectMappings