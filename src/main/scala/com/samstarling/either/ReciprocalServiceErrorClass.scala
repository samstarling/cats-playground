package com.samstarling.either

import cats.syntax.either._

sealed abstract class Error
final case class NotANumber(string: String) extends Error
final case object NoZeroReciprocal extends Error

class ReciprocalServiceErrorClass {

  def apply(s: String): Either[Error, String] = parse(s).flatMap(reciprocal).map(stringify)

  private def parse(s: String): Either[Error, Int] =
    if (s.matches("-?[0-9]+")) Either.right(s.toInt)
    else Either.left(NotANumber(s))

  private def reciprocal(i: Int): Either[Error, Double] =
    if (i == 0) Either.left(NoZeroReciprocal)
    else Either.right(1.0 / i)

  private def stringify(d: Double): String = d.toString
}
