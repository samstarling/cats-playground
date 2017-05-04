package com.samstarling.monoid

import cats.Monoid

class BooleanAndMonoid extends Monoid[Boolean] {
  override def empty: Boolean = true
  override def combine(x: Boolean, y: Boolean): Boolean = x && y
}
