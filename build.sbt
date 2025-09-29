
lazy val generator = (project in file("generator"))
  .settings(
    resolvers += Resolver.sonatypeRepo("public"),
    libraryDependencies += "com.eed3si9n" %% "treehugger" % "0.4.3",
    mainClass := Some("givers.form.generator.Main")
  )
lazy val `play-json-form` = project in file(".")

scalaVersion := "3.7.2"

libraryDependencies ++= Seq(
  "org.playframework" %% "play" % "3.0.9",
  "org.playframework" %% "play-test" % "3.0.9" % Test,
  "org.mockito" % "mockito-core" % "2.18.3" % Test,
  "com.lihaoyi" %% "utest" % "0.7.11" % Test
)

organization := "givers.form"
name := "play-json-form"
version := "2.0.0"
Test / parallelExecution := false
Test / publishArtifact := false


testFrameworks += new TestFramework("utest.runner.Framework")

coverageExcludedPackages := "givers.form.generated.*"

ThisBuild / organization := "io.github.givesocialmovement"
ThisBuild / organizationName := "give.asia"
ThisBuild / organizationHomepage := Some(url("https://give.asia"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/GIVESocialMovement/play-json-form"),
    "scm:git@github.com:GIVESocialMovement/play-json-form.git"
  )
)
ThisBuild / developers := List(
  Developer(id = "tanin", name = "tanin", email = "developers@giveasia.org", url = url("https://github.com/tanin47"))
)

ThisBuild / description := "Play framework form tools"
ThisBuild / licenses := List(
  "MIT" -> new URL("http://opensource.org/licenses/MIT")
)

ThisBuild / homepage := Some(url("https://github.com/GIVESocialMovement/play-json-form"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishMavenStyle := true

// new setting for the Central Portal
ThisBuild / publishTo := {
  val centralSnapshots = "https://central.sonatype.com/repository/maven-snapshots/"
  if (isSnapshot.value) Some("central-snapshots" at centralSnapshots)
  else localStaging.value
}