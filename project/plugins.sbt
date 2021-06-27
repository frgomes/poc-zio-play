import sbt.Resolver

resolvers ++= Seq(
  "typesafe-snapshots" at "https://repo.typesafe.com/typesafe/snapshots/",
  "Maven central" at "https://repo.maven.apache.org/maven2",
  Resolver.typesafeRepo("releases")
)

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.6")

