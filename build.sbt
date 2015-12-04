name := """loan-own"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "com.typesafe.play"          %%    "anorm"                          %     "2.4.0",
  "org.apache.commons"          %    "commons-email"                  %     "1.3.2",
  "mysql"                       %    "mysql-connector-java"           %     "5.1.37",
  "com.google.code.gson"        %    "gson"                           %     "2.5"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
