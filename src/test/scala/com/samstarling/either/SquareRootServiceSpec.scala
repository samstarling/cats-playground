package com.samstarling.either

import org.specs2.mutable.Specification

class SquareRootServiceSpec extends Specification {

  val service = new SquareRootService

  "ReciprocalService" >> {
    "returns a Right with the result, when successful" in {
      service.apply("4.84") match {
        case Right(result) => result ==== "2.2"
        case _ => ko
      }
    }

    "returns a Left with the error, for unparseable strings" in {
      service.apply("foo") must beLeft(NotANumber("foo"))
    }

    "returns a Left with the error, for negative numbers" in {
      service.apply("-20") must beLeft(ImaginaryNumber)
    }
  }
}
