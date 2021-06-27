ThisBuild / organization     := "com.sky"
ThisBuild / organizationName := "sky"
ThisBuild / name             := "cache-rest-api"

ThisBuild / scalaVersion       := "2.13.3"
ThisBuild / crossScalaVersions := Seq("2.13.3")

ThisBuild / Test / parallelExecution := false
ThisBuild / Test / fork := true
ThisBuild / run  / fork := true

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    libraryDependencies ++= Seq(
      guice,
      "com.typesafe.play" %% "play-json" % "2.9.2",
      specs2 % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
