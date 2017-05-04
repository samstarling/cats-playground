package com.samstarling.monoid

import cats.Monoid

class EndoMonoid[T] extends Monoid[T => T] {
  override def empty: (T) => T = (t: T) => t
  override def combine(x: (T) => T, y: (T) => T): (T) => T = x andThen y
}
