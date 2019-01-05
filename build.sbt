name := """BookStoreApp"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.12.7"

crossScalaVersions := Seq("2.11.12", "2.12.4")

libraryDependencies += jdbc
libraryDependencies += guice

// Test Database
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
libraryDependencies += "org.apache.poi" % "poi-ooxml" % "3.16"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// deadbolt dependency
libraryDependencies ++= Seq(
  "be.objectify" %% "deadbolt-java" % "2.6.1"
)


herokuAppName in Compile := "damp-mesa-57133"


// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
