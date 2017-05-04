package com.samstarling.monoid

import cats.Monoid

class StringMonoid extends Monoid[String] {
  override def empty: String = ""
  override def combine(x: String, y: String): String = x + y
}
