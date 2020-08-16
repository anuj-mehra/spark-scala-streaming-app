//import net.virtualvoid.sbt.graph.ModuleId
import sbt._

object HadoopVersion {

  val Hadoop = "2.6.0-cdh5.14.4"
  val Spark = "2.4.6"
  val SparkTwitter = "1.6.3"
  val HBase = ""

}

object Libs {

  val scalaVersion = "2.11.8"
  val `scalatest` = "org.scalatest" %% "scalatest" % "3.0.4"  % "test"
  val `enumeration` = "com.beachane" %% "enumeratum" % "1.5.13"
}

object Hadoop {

  val `hadoop-common` = "org.apache.hadoop" % "hadoop-common" % HadoopVersion.Hadoop
  val `hadoop-hdfs` = "org.apache.hadoop" % "hadoop-hdfs" % HadoopVersion.Hadoop
  val `hadoop-auth` = "org.apache.hadoop" % "hadoop-auth" % HadoopVersion.Hadoop
  val `hadoop-client` = "org.apache.hadoop" % "hadoop-client" % HadoopVersion.Hadoop
  val `hadoop-core` = "org.apache.hadoop" % "hadoop-core" % HadoopVersion.Hadoop
}

object Spark {

  val `spark-core` = "org.apache.spark"  %  "spark-core_2.11"  %  HadoopVersion.Spark excludeAll
    (ExclusionRule(organization = "xerces"), ExclusionRule(organization = "log4j"))

  val `spark-sql` = "org.apache.spark"  %  "spark-sql_2.11"  %  HadoopVersion.Spark

  val `spark-structured-stream` = "org.apache.spark"  %%  "spark-sql-kafka-0-10"  %  HadoopVersion.Spark  excludeAll
    (ExclusionRule(organization = "org.apache.kafka"))

  val `commons-io` = "commons-io" % "commons-io" %  "2.6" exclude("commons-logging", "commons-logging") force()
  val `spark-avro-2.4` = "org.apache.spark" % "spark-avro_2.11" % "2.4.0"

  object TestLibs {

    val `spark-catalyst-test` = "org.apache.spark"  %  "spark-catalyst_2.11"  %  HadoopVersion.Spark % "test" classifier "tests"
    val `spark-core-test` = "org.apache.spark"  % "spark-core_2.11"  %  HadoopVersion.Spark % "test" classifier "tests"
    val `spark-sql-test` = "org.apache.spark"  %  "spark-sql_2.11"  %  HadoopVersion.Spark % "test" classifier "tests"
  }
}

object Kafka {

  val `kafka-clients` = "org.apache.kafka" % "kafka-clients" % "1.1.1"

}

object Twitter{

  val `spark-twitter` = "org.apache.spark"  %  "spark-streaming-twitter_2.11"  %  HadoopVersion.SparkTwitter

  object TestLibs {
    val `spark-twitter` = "org.apache.spark"  %  "spark-streaming-twitter_2.11"  %  HadoopVersion.SparkTwitter
  }
}

object HBase {


}

object Logging{

  val `scala-logging` = "com.typesafe.scala-logging"  %% "scala-logging" % "3.7.2"
  val `logback` = "ch.qos.logback" % "logback-classic" % "1.2.3"
  val `logback-json-encoder` = "net.logstash.logback" % "logstash-logback-encoder" % "4.11" excludeAll ExclusionRule(
    organization = "com.fasterxml.jackson.core"
  )
}

object Excluded {
  val `slf4j-log4j12` = "org.slf4j" % "slf4j-log4j12"
  /*val `log4j` = "log4j"  % "log4j"*/
}