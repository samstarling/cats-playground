package com.samstarling

package object eithert {

  type User = String

  sealed trait Error
  object Error {
    final case class UserNotFound(userId: Long) extends Error
    final case class ConnectionError(message: String) extends Error
  }
}
