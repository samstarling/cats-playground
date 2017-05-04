package com.samstarling.either

import org.specs2.mutable.Specification

class ReciprocalServiceErrorClassSpec extends Specification {

  val service = new ReciprocalServiceErrorClass

  "ReciprocalService" >> {
    "returns a Right with the result, when successful" in {
      service.apply("5") match {
        case Right(result) => result ==== "0.2"
        case _ => ko
      }
    }

    "returns a Left with the exception, when one occurs" in {
      service.apply("foo") match {
        case Left(NotANumber(_)) => ok
        case Left(NoZeroReciprocal) => ko
        case Right(s) => ko
      }
    }
  }
}
