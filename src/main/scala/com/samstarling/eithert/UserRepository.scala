package com.samstarling.eithert

import cats.data._
import scala.concurrent.{ExecutionContext, Future}

class UserRepository {
  def fetch(id: Int)(implicit ec: ExecutionContext): EitherT[Future, Error, User] = EitherT(Future {
    id match {
      case 0 => Right("John Smith")
      case 1 => Right("Peter Piper")
      case x => Left(Error.UserNotFound(x))
    }
  })
}
