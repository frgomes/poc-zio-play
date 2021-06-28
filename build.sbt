ThisBuild / organization     := "com.sky"
ThisBuild / organizationName := "sky"
ThisBuild / name             := "poc-zio-play"

ThisBuild / scalaVersion       := "2.13.3"
ThisBuild / crossScalaVersions := Seq("2.13.3")

ThisBuild / Test / parallelExecution := false
ThisBuild / Test / fork := true
ThisBuild / run  / fork := true

lazy val zioVersion = "1.0.9"

lazy val `lru-cache` = RootProject(uri("http://github.com/frgomes/lru-cache.git"))

lazy val dependencies : Seq[Setting[_]] =
  Seq(
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio"               % zioVersion,
    ),
  )

lazy val zioTestFramework : Seq[Setting[_]] =
  Seq(
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio-test"          % zioVersion % Test,
      "dev.zio" %% "zio-test-sbt"      % zioVersion % Test,
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )

lazy val app = (project in file("."))
  .dependsOn(`lru-cache`)
  .settings(dependencies)
  .settings(zioTestFramework)
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
