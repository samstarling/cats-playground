package com.samstarling

class SquareNumberExceptionService {

  def parse(s: String): Int = {
    if (s.matches("-?[0-9]+")) {
      s.toInt
    } else {
      throw new NumberFormatException(s"${s} is not a valid integer.")
    }
  }

  def square(i: Int)

}
