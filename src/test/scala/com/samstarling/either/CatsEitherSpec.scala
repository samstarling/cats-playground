package com.samstarling.either

import org.specs2.mutable.Specification

class CatsEitherSpec extends Specification {

  import cats.syntax.either._

  "cats.syntax.either._" >> {
    "#map" >> {
      "maps over the Right value" in {
        val e: Either[String, Int] = Right(5)
        e.map(_ + 1) ==== Right(6)
      }

      "does nothing if it's a Left value" in {
        val e: Either[String, Int] = Left("hello")
        e.map(_ + 1) ==== Left("hello")
      }
    }
  }
}
