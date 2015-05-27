name := "CSV"

version := "1.0"

scalaVersion := "2.10.4"




libraryDependencies ++=  Seq(
  "com.typesafe" % "config" % "1.2.0",
  "com.typesafe.slick" %% "slick" % "3.0.0-M1",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "net.sf.opencsv" % "opencsv" % "2.3",
  "com.github.tototoshi" %% "scala-csv" % "1.2.1",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)
