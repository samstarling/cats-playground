package com.samstarling.either

import org.specs2.mutable.Specification

class ScalaEitherSpec extends Specification {

  "Either from Scala" >> {
    "#right" >> {
      "allows mapping over the Right value" in {
        val e: Either[String, Int] = Right(5)
        e.right.map(_ + 1) ==== Right(6)
      }

      "does nothing when it's a Left, and we map over the Right" in {
        val e: Either[String, Int] = Left("hello")
        e.right.map(_ + 1) ==== Left("hello")
      }
    }

    "#left" >> {
      "allows mapping over the Left value" in {
        val e: Either[String, Int] = Left("hello")
        e.left.map(_ + " world") ==== Left("hello world")
      }

      "does nothing when it's a Left, and we map over the Right" in {
        val e: Either[String, Int] = Right(5)
        e.left.map(_ + " world") ==== Right(5)
      }
    }
  }
}
