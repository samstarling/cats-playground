# cats-playground

## Terminology

#### Type constructor

A type that you can apply to type arguments to 'construct' a type. They act like functions, but on the type level. `List` is a type constructor. You can't just have a `List`, you have to have a `List[A]`. Here, `A` is a type parameter.

#### Type classes

From "The Neophyte's Guide":

> A type class `C` defines some behaviour in the form of operations that must be supported by a type `T` for it to be a member of type class `C`. They allow ad-hoc and retroactive polymorphism.

#### Higher-kinded types

`???`

## Useful reading

* [What is a higher-kinded type in Scala?][hkt]
* [Higher-kinded types: the difference between giving up, and moving forward][hkt2]
* [Scala Types of Types][tot]
* [Neophyte's Guide: Type Classes][tc]

[hkt]: http://stackoverflow.com/questions/6246719/what-is-a-higher-kinded-type-in-scala
[hkt2]: http://typelevel.org/blog/2016/08/21/hkts-moving-forward.html
[tot]: http://ktoso.github.io/scala-types-of-types/
[tc] http://danielwestheide.com/blog/2013/02/06/the-neophytes-guide-to-scala-part-12-type-classes.html
