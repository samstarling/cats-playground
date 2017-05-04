package com.samstarling.monoid

import cats.Monoid

class BooleanOrMonoid extends Monoid[Boolean] {
  override def empty: Boolean = false
  override def combine(x: Boolean, y: Boolean): Boolean = x || y
}
