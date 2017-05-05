package com.samstarling.monoid

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class FoldingSpec extends Specification {

  trait Context extends Scope {
    val words = List("Lorem", "ipsum", "dolor")
    val monoid = new StringMonoid
    val folding = new Folding
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
        val result = folding.fold(words, monoid)
        result ==== "Loremipsumdolor"
      }
    }

    "#foldMap" >> {
      "can be written generically to take a monoid and a mapping function" in new Context {
        val result = folding.foldMap(words, monoid)(_.toUpperCase)
        result ==== "LOREMIPSUMDOLOR"
      }
    }

    "#foldMapV" >> {
      "returns Monoid#empty when there are no elements" in new Context {
        val result = folding.foldMapV(IndexedSeq.empty, monoid)(identity)
        result ==== monoid.empty
      }

      "returns a single mapped value when there is one element" in new Context {
        val result = folding.foldMapV(IndexedSeq("hello"), monoid)(_.toUpperCase)
        result ==== "HELLO"
      }

      "produces the correct result for a sequence of strings" in new Context {
        val indexedSeqWords = IndexedSeq("hello", "world", "it's", "me", "Sam")
        val result = folding.foldMapV(indexedSeqWords, monoid)(identity)
        result ==== "helloworldit'smeSam"
      }
    }
  }
}
