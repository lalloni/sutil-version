organization := "pil.sutil"

name := "sutil-version"

version := "0.1"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-deprecation", "-feature")

crossScalaVersions := Seq("2.10.4", "2.11.5")

libraryDependencies <++= scalaVersion(sv =>
    if (sv.startsWith("2.11"))
        Seq("org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3")
    else
        Seq.empty
)

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "2.2.1" % "test",
    "org.scalacheck" %% "scalacheck" % "1.12.2" % "test",
    "junit" % "junit" % "4.8" % "test")

publishMavenStyle := true

seq(bintrayPublishSettings:_*)

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
