package com.samstarling.monoid

import cats.Monoid

class OptionMonoid[T] extends Monoid[Option[T]] {
  override def empty: Option[T] = None
  override def combine(x: Option[T], y: Option[T]): Option[T] = x orElse y
}
