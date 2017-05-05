package com.samstarling.monoid

import cats.Monoid

class Folding {

  def fold[A](as: List[A], monoid: Monoid[A]): A = {
    as.foldLeft(monoid.empty)(monoid.combine)
  }

  // FPIS exercise 10.5
  def foldMap[A, B](as: List[A], monoid: Monoid[B])(f: A => B): B = {
    as.foldLeft(monoid.empty)((b, a) => monoid.combine(b, f(a)))
  }

  // FPIS exercise 10.6
  def foldLeft[A, B](as: List[A])(z: B)(f: (B, A) => B): B = ???

  // FPIS exercise 10.6 part 2
  def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B = ???
}
