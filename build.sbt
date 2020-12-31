
lazy val generator = (project in file("generator"))
  .settings(
    resolvers += Resolver.sonatypeRepo("public"),
    libraryDependencies += "com.eed3si9n" %% "treehugger" % "0.4.3",
    mainClass := Some("givers.form.generator.Main")
  )
lazy val `play-json-form` = project in file(".")

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.8.7",
  "com.typesafe.play" %% "play-test" % "2.8.7" % Test,
  "org.mockito" % "mockito-core" % "2.18.3" % Test,
  "com.lihaoyi" %% "utest" % "0.7.2" % Test
)

organization := "givers.form"
name := "play-json-form"
version := "1.0.0"
parallelExecution in Test := false

publishMavenStyle := true

bintrayOrganization := Some("givers")

bintrayRepository := "maven"

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq(("MIT", url("http://opensource.org/licenses/MIT")))

testFrameworks += new TestFramework("utest.runner.Framework")

coverageExcludedPackages := "givers.form.generated.*"
