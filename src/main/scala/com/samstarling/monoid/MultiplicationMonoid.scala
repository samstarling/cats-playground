package com.samstarling.monoid

import cats.Monoid

// FPIS exercise 10.1
class MultiplicationMonoid extends Monoid[Int] {
  override def empty: Int = 1
  override def combine(x: Int, y: Int): Int = x * y
}
