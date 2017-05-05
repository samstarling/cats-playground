package com.samstarling.monoid

import cats.Monoid

// FPIS exercise 10.2
class OptionMonoid[T] extends Monoid[Option[T]] {
  override def empty: Option[T] = None
  override def combine(x: Option[T], y: Option[T]): Option[T] = x orElse y
}
