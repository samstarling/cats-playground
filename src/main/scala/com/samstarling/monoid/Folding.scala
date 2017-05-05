package com.samstarling.monoid

import cats.Monoid

class Folding {
  def concatenate[A](as: List[A], monoid: Monoid[A]): A = {
    as.foldLeft(monoid.empty)(monoid.combine)
  }
}
