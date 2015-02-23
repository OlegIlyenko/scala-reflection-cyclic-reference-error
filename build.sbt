name := "scala-reflection-cyclic-reference-error"
version := "0.1-SNAPSHOT"

scalaVersion := "2.11.5"
scalacOptions ++= Seq("-deprecation", "-feature")
fork in run := true

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-cache" % "2.4.0-M2",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value
)