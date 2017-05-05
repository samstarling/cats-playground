package com.samstarling.eithert

import cats.data._
import com.twitter.util.Future

class TwitterUserRepository {
  def fetch(id: Int): EitherT[Future, Error, User] = EitherT(Future {
    id match {
      case 0 => Right("John Smith")
      case 1 => Right("Peter Piper")
      case x => Left(Error.UserNotFound(x))
    }
  })
}
