package com.samstarling

import org.specs2.mutable.Specification

import cats.syntax.either._

class ReciprocalServiceSpec extends Specification {

  val service = new ReciprocalService

  "ReciprocalService" >> {
    "can be used with some nice combinators" in {
      service.parse("5").flatMap(service.reciprocal).map(service.stringify) match {
        case Right(result) => result ==== "0.2"
        case _ => ko
      }
    }
  }

}
