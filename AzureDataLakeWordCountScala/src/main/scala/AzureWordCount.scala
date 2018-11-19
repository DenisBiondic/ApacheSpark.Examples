package main

import org.apache.spark.{SparkConf, SparkContext}

object AzureWordCount {
  def main(args: Array[String]) = {
    println("Starting the word counter big data application :)")

    val conf = new SparkConf().setAppName("Azure Word Counter")
    val sc = new SparkContext(conf)

    val x = 1 to 10 toList

    val result = sc.parallelize(x, 10).map(x => x*2).reduce((a,b) => a+b)
    println("----------------- Result: " + result)
  }
}