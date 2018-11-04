Param(
 [Parameter(Mandatory=$True)]
 [string]
 $ConsumerKey,

 [Parameter(Mandatory=$True)]
 [string]
 $ConsumerSecret,

 [Parameter(Mandatory=$True)]
 [string]
 $AccessToken,

 [Parameter(Mandatory=$True)]
 [string]
 $AccessTokenSecret
)

$ErrorActionPreference = 'Stop'

Write-Host "------- BUILD -------"
Write-Host "Building the uber-JAR containing all JARs necessary for Spark job..."
sbt assembly

Write-Host "------- SPARK SUBMIT -------"
Write-Host "Submitting job to Spark..."
spark-submit --class "main.TwitterStreaming" --master local[1] `
    "target/scala-2.11/TwitterStreamingScala-assembly-1.1.jar" `
    $ConsumerKey $ConsumerSecret $AccessToken $AccessTokenSecret