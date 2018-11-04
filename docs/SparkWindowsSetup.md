Few notes on the working windows setup (Nov. 2018 at least):

# Setup (Spark 2.3.2)

Windows 10

## Java

JAVA_HOME = C:\Program Files\Java\jdk1.8.0_152

## Scala

Scala / SBT env variable set (SBT_HOME = C:\Program Files (x86)\sbt\)
SBT used 1.2.6 (SBT will install Scala runtimes for each project, based on specified version in build.sbt file!)

## Apache Spark

tarball downloaded and uncompressed (from official site), version spark-2.3.2-bin-hadoop2.7
SPARK_HOME set to root of uncompressed folder. %SPARK_HOME%\bin set to PATH.

**Note: Specified Spark version supports only 2.11.x versions of Scala, therefore Scala examples contain `scalaVersion := "2.11.12"` in the build.sbt files!**

## Hadoop

"fake" hadoop set up with HADOOP_HOME = C:\Hadoop, add with adding winutils.exe (uploaded next to this file) file to %HADOOP_HOME%\bin

# Gotchas

Spark complains quite a lot under windows. Errors that can be ignored are:
- error on the end of the job, that the temporary files cannot be deleted


# Setup (Spark 2.2.2)

Same setup as 2.3.2, unpack and simple %SPARK_HOME% change is all that is needed.