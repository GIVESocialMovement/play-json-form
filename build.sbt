name := "play-json-form"
version := "1.0.0"

lazy val generator = (project in file("generator"))
  .settings(
    resolvers += Resolver.sonatypeRepo("public"),
    libraryDependencies += "com.eed3si9n" %% "treehugger" % "0.4.3",
    mainClass := Some("givers.form.generator.Main"),
    publish / skip := true
  )
scalaVersion := "2.13.16"

Test / parallelExecution := false

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.8.7",
  "com.typesafe.play" %% "play-test" % "2.8.7" % Test,
  "org.mockito" % "mockito-core" % "2.18.3" % Test,
  "com.lihaoyi" %% "utest" % "0.7.2" % Test
)
testFrameworks += new TestFramework("utest.runner.Framework")

coverageExcludedPackages := "givers.form.generated.*"

organization := "io.github.tanin47"
organizationName := "tanin47"
homepage := Some(url("https://github.com/tanin47/play-json-form"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/tanin47/play-json-form"),
    "scm:git@github.com:tanin47/play-json-form.git"
  )
)

publishMavenStyle := true

Test / publishArtifact := false

pomIncludeRepository := { _ => false }
publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

licenses := Seq(("MIT", url("http://opensource.org/licenses/MIT")))

developers := List(
  Developer(
    id = "tanin",
    name = "Tanin Na Nakorn",
    email = "@tanin",
    url = url("https://github.com/tanin47")
  )
)

versionScheme := Some("semver-spec")
