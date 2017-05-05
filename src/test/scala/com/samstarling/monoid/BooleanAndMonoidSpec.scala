package com.samstarling.monoid

import org.specs2.mutable.Specification

class BooleanAndMonoidSpec extends Specification {

  val monoid = new BooleanAndMonoid()

  "BooleanOrMonoid" >> {
    "#combine" >> {
      "has the correct 'or' logic" in {
        monoid.combine(true, true) ==== true
        monoid.combine(false, false) ==== false
        monoid.combine(true, false) ==== false
        monoid.combine(false, true) ==== false
      }

      "is commutable" in {
        monoid.combine(true, monoid.combine(true, monoid.combine(true, true))) ==== true
      }
    }
  }
}
