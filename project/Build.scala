import sbt.Keys._
import sbt._
import scoverage.ScoverageSbtPlugin.ScoverageKeys

object Build extends Build {

  lazy val commonSettings = Seq(
    name := "escalar",
    organization := "com.workday",
    version := "1.7.0",
    crossScalaVersions := Seq("2.10.4", "2.11.8")
  )

  lazy val root = Project(id = "escalar", base = file("."))
    .settings(
      commonSettings,
      libraryDependencies ++= Seq(
        "io.searchbox" % "jest" % "0.1.7",
        "org.mockito" % "mockito-core" % "1.9.5" % Test,
        "org.scalatest" %% "scalatest" % "3.0.1" % Test,
        "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.5.3",
        "com.fasterxml.jackson.core" % "jackson-annotations" % "2.5.3",
        "com.fasterxml.jackson.core" % "jackson-databind" % "2.5.3",
        "com.fasterxml.jackson.core" % "jackson-core" % "2.5.3",
        "log4j" % "log4j" % "1.2.17"
      ),
      ScoverageKeys.coverageMinimum := 100,
      ScoverageKeys.coverageFailOnMinimum := true
    )
}