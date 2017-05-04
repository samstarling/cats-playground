package com.samstarling.monoid

import cats.Monoid

class ListMonoid[T] extends Monoid[List[T]] {
  override def empty: List[T] = List.empty
  override def combine(x: List[T], y: List[T]): List[T] = x ++ y
}
