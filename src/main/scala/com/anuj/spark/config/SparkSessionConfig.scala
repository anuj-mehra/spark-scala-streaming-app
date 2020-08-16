package com.anuj.spark.config

//import org.apache.spark.implicits._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

class SparkSessionConfig(appName: String, batchDuration: Int) {

  def get: SparkSession = {
    val sparkSession = SparkSession
      .builder
      .appName("StructuredNetworkWordCount")
      .master("local[*]")
      .getOrCreate()

    sparkSession
  }
}

object SparkSessionConfig {

  def apply(appName: String, batchDuration: Int): SparkSessionConfig = {
    new SparkSessionConfig(appName, batchDuration)
  }
}
