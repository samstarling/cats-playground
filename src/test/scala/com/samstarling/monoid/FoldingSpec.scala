package com.samstarling.monoid

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class FoldingSpec extends Specification {

  trait Context extends Scope {
    val words = List("Lorem", "ipsum", "dolor")
  }

  "List" >> {
    "#foldLeft" >> {
      "can be used to concatenate a string" in new Context {
        words.foldLeft("")(_ + _) ==== "Loremipsumdolor"
      }

      "produces the same result for both foldLeft and foldRight" in new Context {
        words.foldLeft("")(_ + _) ==== words.foldRight("")(_ + _)
      }
    }
  }

  "Folding" >> {
    "#fold" >> {
      "can be written generically to take a monoid" in new Context {
        val folding = new Folding
        val result = folding.fold(words, new StringMonoid)
        result ==== "Loremipsumdolor"
      }
    }

    "#fold" >> {
      "can be written generically to take a monoid and a mapping function" in new Context {
        val folding = new Folding
        val result = folding.foldMap(words, new StringMonoid)(_.toUpperCase)
        result ==== "LOREMIPSUMDOLOR"
      }
    }
  }
}
