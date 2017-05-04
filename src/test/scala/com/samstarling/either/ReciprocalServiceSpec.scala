package com.samstarling.either

import org.specs2.mutable.Specification

class ReciprocalServiceSpec extends Specification {

  val service = new ReciprocalService

  "ReciprocalService" >> {
    "returns a Right with the result, when successful" in {
      service.apply("5") match {
        case Right(result) => result ==== "0.2"
        case _ => ko
      }
    }

    "returns a Left with the exception, when one occurs" in {
      service.apply("foo") match {
        case Left(ex) => ex must haveClass[NumberFormatException]
        case Right(result) => ko
      }
    }
  }
}
