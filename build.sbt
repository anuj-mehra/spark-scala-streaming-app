import sbtassembly.MergeStrategy
name := "scala-spark-structured-streaming-app"

scalaVersion := "2.11.8"

version := "0.1"

updateOptions := updateOptions.value.withCachedResolution(true)
updateOptions := updateOptions.value.withGigahorse(false)
updateOptions := updateOptions.value.withInterProjectFirst(false)
updateOptions := updateOptions.value.withLatestSnapshots(true)


lazy val buildSettings = Seq(
  organization := "com.anuj.spark"/*,
  coverageEnabled in (Test,Compile) := true,
  coverageEnabled in (Compile,Compile) := false*/
)


lazy val `logging-utility` = project
  .settings(libraryDependencies ++= Dependencies.logging)
  .settings(excludeDependencies ++= Dependencies.excluded)
  .enablePlugins(NoPublish)


lazy val `scala-spark-streaming-app` = project
  .settings(libraryDependencies ++= Dependencies.SparkModule)
  .settings(libraryDependencies ++= Dependencies.logging)
  .settings(excludeDependencies ++= Dependencies.excluded)
  //.dependsOn(`logging-utility`)
.in(file("."))
//.aggregate(sparkStreaming)
/*.settings(compileScalastyle := scalastyle.in(Compile).toTask("").value,
  (compile in Compile) := ((compile in Compile) dependsOn compileScalastyle).value)
  .settings(Seq(scalafmtOnCompile := true))
  .enablePlugins(MayBeCoverage, DependencyGraphPlugin)*/



/*lazy val sparkStreaming = project
.settings(libraryDependencies ++= Dependencies.SparkModule)
//.settings(libraryDependencies ++= Dependencies.SparkModule)
.settings(baseAssemblySettings)
//.enablePlugins(MayBeCoverage, NoPublish)*/

lazy val assemblySettings = Seq(
 test in assembly := {},
  assemblyJarName in assembly := "scala-spark-streaming" + name.value + "-" + version.value + ".jar",
  assemblyMergeStrategy in assembly := {

    case PathList("META-INF", xs@_*) => xs.map(_.toLowerCase) match {
      case "manifest.mf" :: Nil |
           "index.list" :: Nil |
           "dependencies" :: Nil |
            "license" :: Nil |
            "dummy.dsa" :: Nil |
            "notice" :: Nil => MergeStrategy.discard
      case _ => MergeStrategy.first
    }

    case _ => MergeStrategy.first
  }

)
unmanagedClasspath in Test += baseDirectory.value / "src/main/resources"