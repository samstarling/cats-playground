package com.samstarling.eithert

import com.samstarling.eithert.Error.UserNotFound
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration._

class UserRepositorySpec extends Specification {

  trait Context extends Scope {
    val repository: UserRepository = new UserRepository
    implicit val ec: ExecutionContext = ExecutionContext.global
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

      "returns an error when not successful" in new Context {
        val future = repository.fetch(100).value
        val result = Await.result(future, 2.seconds)
        result match {
          case Left(UserNotFound(id)) => id ==== 100
          case _ => ko
        }
      }
    }
  }
}
