name := "akka-http"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-core" % "10.0.1",
  "com.typesafe.akka" %% "akka-http" % "10.0.1",
  "org.json4s" %% "json4s-jackson" % "3.5.0",
  "com.lihaoyi" %% "scalatags" % "0.6.2"
)