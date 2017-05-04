package com.samstarling.monoid

import org.specs2.mutable.Specification

class BooleanOrMonoidSpec extends Specification {

  val monoid = new BooleanOrMonoid()

  "BooleanAndMonoid" >> {
    "#combine" >> {
      "has the correct 'and' logic" in {
        monoid.combine(true, true) ==== true
        monoid.combine(false, false) ==== false
        monoid.combine(true, false) ==== true
        monoid.combine(false, true) ==== true
      }

      "is commutable" in {
        monoid.combine(true, monoid.combine(false, monoid.combine(false, true))) ==== true
      }
    }
  }
}
