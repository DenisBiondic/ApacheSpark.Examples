package main

import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.twitter.TwitterUtils
import twitter4j.conf.ConfigurationBuilder
import twitter4j.auth.OAuthAuthorization

object TwitterStreaming {
  def main(args: Array[String]) {
    assert(args.length == 4, "Expected four arguments(twitter access keys): <ConsumerKey> <ConsumerSecret> <accessToken> <accessTokenSecret>!")
    val Array(consumerKey, consumerSecret, accessToken, accessTokenSecret) = args.take(4)

    reduceLoggingToWarn

    val appName = "TwitterStreaming"
    val conf = new SparkConf().setAppName(appName)

    val streamingContext = new StreamingContext(conf, Seconds(5))

    val twitterConfigurationBuilder = new ConfigurationBuilder
    twitterConfigurationBuilder
      .setOAuthConsumerKey(consumerKey)
      .setOAuthConsumerSecret(consumerSecret)
      .setOAuthAccessToken(accessToken)
      .setOAuthAccessTokenSecret(accessTokenSecret)

    val auth = new OAuthAuthorization(twitterConfigurationBuilder.build)
    val tweets = TwitterUtils.createStream(streamingContext, Some(auth))
    tweets.saveAsTextFiles("tweets", "json")

    streamingContext.start()
    streamingContext.awaitTermination()
  }

  private def reduceLoggingToWarn = {
    import org.apache.log4j.{Level, Logger}

    Logger.getRootLogger().setLevel(Level.WARN)
  }
}
