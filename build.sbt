organization := "plalloni"

name := "sutil-version"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq (
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3",
    "org.scalatest" %% "scalatest" % "2.2.1" % "test",
    "org.scalacheck" %% "scalacheck" % "1.12.2" % "test",
    "junit" % "junit" % "4.8" % "test")

publishMavenStyle := true

publishTo <<= version { ver ⇒ Some(
    Resolver
        .file("Local Repository", file(Path.userHome
            + "/projects/artifacts/maven-"
            + (if (ver endsWith "-SNAPSHOT") "snapshots" else "releases")))
        .mavenStyle)}
