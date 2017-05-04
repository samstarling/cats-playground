package com.samstarling.either

import cats.syntax.either._
import org.specs2.mutable.Specification

class ReciprocalServiceSpec extends Specification {

  val service = new ReciprocalService

  "ReciprocalService" >> {
    "can be used with some nice combinators" in {
      service.apply("5") match {
        case Right(result) => result ==== "0.2"
        case _ => ko
      }
    }
  }

}
