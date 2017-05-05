# cats-playground

## Terminology

#### Monoid

A type `A` and an implementation of `Monoid[A]` that satisfies the three laws:

* Closure: the result of combining two things is always another one of the things.
* Associativity: When combining more than two things, order doesn't matter.
* Identity element: There is a special thing called "zero" such that when you combine any thing with "zero" you get the original thing back.

#### Type constructor

A type that you can apply to type arguments to 'construct' a type. They act like functions, but on the type level. `List` is a type constructor. You can't just have a `List`, you have to have a `List[A]`. Here, `A` is a type parameter.

#### Type classes

From "The Neophyte's Guide":

> A type class `C` defines some behaviour in the form of operations that must be supported by a type `T` for it to be a member of type class `C`. They allow ad-hoc and retroactive polymorphism.

#### Higher-kinded types

`???`

## Useful reading

* [Monoids in practice][monoids]
* [What is a higher-kinded type in Scala?][hkt]
* [Higher-kinded types: the difference between giving up, and moving forward][hkt2]
* [Scala Types of Types][tot]
* [Neophyte's Guide: Type Classes][tc]

[monoids]: https://fsharpforfunandprofit.com/posts/monoids-part2/
[hkt]: http://stackoverflow.com/questions/6246719/what-is-a-higher-kinded-type-in-scala
[hkt2]: http://typelevel.org/blog/2016/08/21/hkts-moving-forward.html
[tot]: http://ktoso.github.io/scala-types-of-types/
[tc] http://danielwestheide.com/blog/2013/02/06/the-neophytes-guide-to-scala-part-12-type-classes.html
