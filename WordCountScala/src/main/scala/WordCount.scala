package main

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]) = {
    println("Starting the word counter big data application :)")

    assert(args.length > 0, "Expected two input arguments, input file and output folder!")

    val inputFile = args(0)
    val outputFolder = args(1)

    println(s"Input file $inputFile, output folder $outputFolder")

    val conf = new SparkConf().setAppName("Word Counter")
    val sc = new SparkContext(conf)

    sc.textFile(inputFile)
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey((accValue, newValue) => accValue + newValue)
      .sortBy(kvPair => kvPair._2, false)
      .saveAsTextFile(outputFolder)
  }
}
