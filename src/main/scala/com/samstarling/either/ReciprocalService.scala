package com.samstarling.either

import cats.syntax.either._

class ReciprocalService {

  def apply(s: String): Either[Exception, String] = parse(s).flatMap(reciprocal).map(stringify)

  private def parse(s: String): Either[Exception, Int] =
    if (s.matches("-?[0-9]+")) Either.right(s.toInt)
    else Either.left(new NumberFormatException(s"$s is not a valid integer."))

  private def reciprocal(i: Int): Either[Exception, Double] =
    if (i == 0) Either.left(new IllegalArgumentException("Cannot take reciprocal of 0."))
    else Either.right(1.0 / i)

  private def stringify(d: Double): String = d.toString
}
