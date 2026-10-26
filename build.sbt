// Scope project name directly to the project
name := "devInsideYou"

// Global build-level defaults
ThisBuild / version      := "0.1"
ThisBuild / scalaVersion := "2.13.17"

// --------------------------------------------------
// Compiler & Java Configuration (Java 17)
// --------------------------------------------------
javacOptions ++= Seq(
  "--release", "17"
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-release:17"
)

// --------------------------------------------------
// Runtime Java Options
// --------------------------------------------------
javaOptions ++= Seq(
  "-XX:+IgnoreUnrecognizedVMOptions",
  "--add-opens=java.base/java.lang=ALL-UNNAMED",
  "--add-opens=java.base/java.lang.invoke=ALL-UNNAMED",
  "--add-opens=java.base/java.lang.reflect=ALL-UNNAMED",
  "--add-opens=java.base/java.io=ALL-UNNAMED",
  "--add-opens=java.base/java.net=ALL-UNNAMED",
  "--add-opens=java.base/java.nio=ALL-UNNAMED",
  "--add-opens=java.base/java.util=ALL-UNNAMED",
  "--add-opens=java.base/java.util.concurrent=ALL-UNNAMED",
  "--add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED",
  "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED",
  "--add-opens=java.base/sun.nio.cs=ALL-UNNAMED",
  "--add-opens=java.base/sun.security.action=ALL-UNNAMED",
  "--add-opens=java.base/sun.util.calendar=ALL-UNNAMED",
  "--add-opens=java.security.jgss/sun.security.krb5=ALL-UNNAMED"
)

fork := true

// --------------------------------------------------
// Versions & Dependencies
// --------------------------------------------------
lazy val sparkVersion  = "4.1.1"
lazy val jacocoVersion = "0.8.11"

libraryDependencies ++= Seq(
  "org.apache.spark"           %% "spark-core"    % sparkVersion,
  "org.apache.spark"           %% "spark-sql"     % sparkVersion,
  "com.oracle.database.jdbc"    % "ojdbc8"        % "23.3.0.23.09",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "org.slf4j"                   % "slf4j-api"     % "2.0.5",
  "org.jacoco"                  % "org.jacoco.core"   % jacocoVersion,
  "org.jacoco"                  % "org.jacoco.report" % jacocoVersion,
  "org.scalatest"              %% "scalatest"     % "3.2.17" % Test,
  "org.mockito"                 % "mockito-core"  % "5.2.0"  % Test
)

// --------------------------------------------------
// Main Class Entry Point (Scoped to Compile)
// --------------------------------------------------
Compile / mainClass := Some("com.suanki.stgTransformer.structuredAPI.BasicStructureOperation")