name := "multi-module-ass3"

version := "0.1"

scalaVersion in ThisBuild := "2.13.0"
organization in ThisBuild :="com"


libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.12"

lazy val root = (project in file(".")).dependsOn(useroperation).aggregate(useroperation,entity,dboperation)
lazy val entity = project in file("entity")
lazy val useroperation = (project in file("useroperation")).dependsOn(entity,dboperation)
lazy val dboperation = (project in file("dboperation")).dependsOn(entity)