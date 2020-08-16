import sbt.librarymanagement.ModuleID

object Dependencies {

  var SparkModule: scala.collection.mutable.Seq[ModuleID] = scala.collection.mutable.Seq(
    Spark.`spark-core`,
    Spark.`spark-sql`,
    Spark.`spark-avro-2.4`,
    Spark.`spark-structured-stream`,
    Spark.`commons-io`,
    Twitter.`spark-twitter`,
    Twitter.TestLibs.`spark-twitter`,
    Kafka.`kafka-clients`,
    Spark.TestLibs.`spark-catalyst-test`,
    Spark.TestLibs.`spark-core-test`,
    Spark.TestLibs.`spark-sql-test`
  )

  val logging = Seq(Logging.`scala-logging`, Logging.`logback`, Logging.`logback-json-encoder`)

  val excluded = Seq(Excluded.`slf4j-log4j12`/*, Excluded.`log4j`*/)
}
