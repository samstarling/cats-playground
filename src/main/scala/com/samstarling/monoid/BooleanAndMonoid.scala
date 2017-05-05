package com.samstarling.monoid

import cats.Monoid

// FPIS exercise 10.1
class BooleanAndMonoid extends Monoid[Boolean] {
  override def empty: Boolean = true
  override def combine(x: Boolean, y: Boolean): Boolean = x && y
}
