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

  // FPIS exercise 10.7
  def foldMapV[A, B](as: IndexedSeq[A], monoid: Monoid[B])(f: A => B): B = {
    val (firstHalf, lastHalf) = as.splitAt(as.length / 2)
    as.length match {
      case 0 => monoid.empty
      case 1 => f(as(0))
      case _ => monoid.combine(foldMapV(firstHalf, monoid)(f), foldMapV(lastHalf, monoid)(f))
    }
  }
}
