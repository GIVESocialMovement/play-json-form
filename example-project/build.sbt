name := "example-project"
organization := "givers.i18n"

version := "1.0-SNAPSHOT"

lazy val jsonForm = RootProject(file("./..").getCanonicalFile.toURI)

lazy val root = (project in file(".")).enablePlugins(PlayScala).dependsOn(jsonForm)

scalaVersion := "2.12.8"

libraryDependencies += guice
