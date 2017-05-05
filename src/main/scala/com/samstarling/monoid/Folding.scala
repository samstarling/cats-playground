package com.samstarling.monoid

import cats.Monoid

class Folding {

  def fold[A](as: List[A], monoid: Monoid[A]): A = {
    as.foldLeft(monoid.empty)(monoid.combine)
  }

  // FPIS exercise 10.5
  def foldMap[A, B](as: List[A], monoid: Monoid[B])(f: A => B): B = {
    as.map(f).foldLeft(monoid.empty)(monoid.combine)
  }
}
