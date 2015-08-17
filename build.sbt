import play.sbt.PlayImport._
import play.sbt.routes.RoutesKeys._


name         := "spark-play-activator"
organization := "ch.alexmass"
version      := "0.0.1"
scalaVersion := Version.scala



lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaSource in Compile <<= baseDirectory / "src/scala"

libraryDependencies ++= Dependencies.sparkAkkaHadoop

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4"
)

releaseSettings

scalariformSettings

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

//routesGenerator := InjectedRoutesGenerator
