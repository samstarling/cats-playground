package com.samstarling.eithert

import com.samstarling.eithert.Error.UserNotFound
import com.twitter.util.Await
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class TwitterUserRepositorySpec extends Specification {

  trait Context extends Scope {
    val repository: TwitterUserRepository = new TwitterUserRepository
  }

  "UserRepository" >> {
    "#fetch" >> {
      "returns the user when successful" in new Context {
        val future = repository.fetch(1).value
        val result = Await.result(future)
        result match {
          case Right(user) => user ==== "Peter Piper"
          case _ => ko
        }
      }

      "returns an error when not successful" in new Context {
        val future = repository.fetch(100).value
        val result = Await.result(future)
        result match {
          case Left(UserNotFound(id)) => id ==== 100
          case _ => ko
        }
      }
    }
  }
}
