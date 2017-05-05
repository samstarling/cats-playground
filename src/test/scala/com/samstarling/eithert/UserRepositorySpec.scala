package com.samstarling.eithert

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration._

class UserRepositorySpec extends Specification {

  trait Context extends Scope {
    val repository = new UserRepository
    implicit val ec = ExecutionContext.global
  }

  "UserRepository" >> {
    "#fetch" >> {
      "returns the user when successful" in new Context {
        val future = repository.fetch(1).value
        val result = Await.result(future, 2.seconds)
        result match {
          case Right(user) => user ==== "Peter Piper"
          case _ => ko
        }
      }
    }
  }
}
