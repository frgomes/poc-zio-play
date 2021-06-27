lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """cache-rest-api""",
    organization := "com.sky",
    version := "1.0",
    scalaVersion := "2.13.4",
    libraryDependencies ++= Seq(
      guice,
      "com.typesafe.play" %% "play-json" % "2.9.1",
      specs2 % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
