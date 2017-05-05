package com.samstarling.eithert

import cats.data._
import cats.implicits._
import scala.concurrent.{ExecutionContext, Future}

sealed trait Error
object Error {
  final case class UserNotFound(userId: Long) extends Error
  final case class ConnectionError(message: String) extends Error
}

class UserRepository {

  type User = String

  def fetch(id: Int)(implicit ec: ExecutionContext): EitherT[Future, Error, User] = EitherT(Future {
    id match {
      case 0 => Right("John Smith")
      case 1 => Right("Peter Piper")
      case x => Left(Error.UserNotFound(x))
    }
  })
}
