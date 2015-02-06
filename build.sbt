organization := "pil.sutil"

name := "sutil-version"

version := "0.1"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq (
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3",
    "org.scalatest" %% "scalatest" % "2.2.1" % "test",
    "org.scalacheck" %% "scalacheck" % "1.12.2" % "test",
    "junit" % "junit" % "4.8" % "test")

publishMavenStyle := true

seq(bintrayPublishSettings:_*)

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
