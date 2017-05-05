package com.samstarling.either

import cats.syntax.either._

sealed abstract class Error
final case class NotANumber(string: String) extends Error
final case object ImaginaryNumber extends Error

class SquareRootService {

  def apply(s: String): Either[Error, String] = {
    val a = parse(s)
    val b = a.flatMap(squareRoot)
    b.map(x => x.toString)
  }

  private def parse(s: String): Either[Error, Double] = {
    try {
      Either.right(s.toDouble)
    } catch {
      case _: NumberFormatException => Either.left(NotANumber(s))
    }
  }

  private def squareRoot(i: Double): Either[Error, Double] = {
    if (i < 0) Either.left(ImaginaryNumber)
    else Either.right(Math.sqrt(i))
  }
}
