package com.anuj.spark.loader

import com.anuj.spark.config.SparkSessionConfig
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.sql.types.{DataType, StringType, StructField, StructType}
import java.sql.Timestamp

import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.StreamingQuery

object KafkaDataLoader {

  def main(args: Array[String]): Unit = {

    val sparkSessionConfig: SparkSessionConfig = SparkSessionConfig("twitter-data-loader", 1)
    implicit val spark  = sparkSessionConfig.get


    import spark.implicits._

    // Subscribe to 1 topic
    val df = spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "host1:port1,host2:port2")
      .option("subscribe", "topic1")
      .load()


    val ds = df
      .selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
      .writeStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "host1:port1,host2:port2")
      .option("topic", "topic1")
      .start()


    /*val schema = StructType(
      Seq(
        StructField("firstName", StringType, true),
        StructField("lastName", StringType, true),
        StructField("sex", StringType, true),
        StructField("age", StringType, true)
      )
    )*/

    ds.awaitTermination()
  }
}
