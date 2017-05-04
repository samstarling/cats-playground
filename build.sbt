name := "cats-playground"

organization := "com.samstarling"

scalaVersion := "2.11.8"

val javaVersion = "1.8"
javacOptions := Seq("-encoding", "UTF-8", "-Xlint:unchecked", "-Xlint:deprecation", "-source", javaVersion, "-target", javaVersion)

libraryDependencies := Seq(
  "org.typelevel" %% "cats" % "0.8.1",
  "com.twitter" %% "util-core" % "6.38.0",
  "org.specs2" %% "specs2" % "3.7" % Test
)
