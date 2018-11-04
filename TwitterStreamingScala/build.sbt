name := "TwitterStreamingScala"

version := "0.9"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.3.2" % "provided",
  "org.apache.spark" %% "spark-streaming" % "2.3.2",
  "org.apache.bahir" %% "spark-streaming-twitter" % "2.2.0"
)