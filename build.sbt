import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "private_encrypt_demo",
    libraryDependencies += scalaTest % Test
  )

libraryDependencies += "org.bouncycastle" % "bcprov-jdk16" % "1.45"
//libraryDependencies += "commons-codec" % "commons-codec" % "1.9"

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
