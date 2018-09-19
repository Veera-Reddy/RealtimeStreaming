package spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.StreamingContext._

import org.apache.spark.streaming.twitter._
import org.apache.log4j.Logger
import org.apache.log4j.Level

object TopHashTags {
	def main(args: Array[String]): Unit = {

			Logger.getLogger("org").setLevel(Level.ERROR)
			Logger.getLogger("akka").setLevel(Level.ERROR)
		
			/*
			 *  Setting up winutil.exe			  
			 *  Spark doesn't have any file system API's to interact with files
			 *  But it uses Hadoop HDFS API to read data from file and to write	
			 * data back into files.
			 *  We have to make sure that the HDFS API's in windows works 
			 *  without any issue to achieve that we need to setup an utility called
			 *  winutils.exe
			 *  
			 *  winutils.exe -> Integrates the HDFS API's with windows  
			 *  winutils.exe folder Structure -> D:\hadoop\bin\winutils.exe
			 * */
			System.setProperty("hadoop.home.dir","D:\\hadoop\\")

			// Set up the Spark configuration with our app name and any other config
			val conf = new SparkConf().setMaster("local[2]").setAppName("Hash Tags")
			
		  	// Use the config to create a streaming context that creates a new RDD
			val ssc = new StreamingContext(conf, Seconds(2))

			val filters : Array[String]  = Array("BigData","spark","BCCI","CricketAus","ICC","sports","java","JavaOne","frameworks")

			/*
			* To get the following keys, go to https://apps.twitter.com/
			* and create a new Application, then you will be getting 
			* these keys and use them Appropriately.
			**/
			System.setProperty("twitter4j.oauth.consumerKey", "06VbUtXmxCIycXgEJy6F2ZqeJ")
			System.setProperty("twitter4j.oauth.consumerSecret", "R1OHvmRcKELyHBDLnGca1QOW1tAR2SgtGkkqhOi2KySeCexFOa")
			System.setProperty("twitter4j.oauth.accessToken", "925004856-ewsJKUawywszTXpHfA76XvYgOJWgIeR8jBBY77Aa")
			System.setProperty("twitter4j.oauth.accessTokenSecret", "pufuk7ZoQHSE8WIzDdIRdwzB3Hdp6KlTZwlHgXVkr34Xd")


			// Use the streaming context and the TwitterUtils to create the Twitter stream.
			val stream = TwitterUtils.createStream(ssc, None, filters)
			val englishTweets = stream.filter(_.getLang() == "en") 

        		/* Each tweet comes as a twitter4j.Status object, which we can use to
			 * extract hash tags. We use flatMap() since each status could have
			 *ZERO OR MORE hashtags.
			 **/
			val hashTags = englishTweets.flatMap(status => status.getHashtagEntities)

			// Convert hashtag to (hashtag, 1) pair 
			val hashTagPairs = hashTags.map(hashtag => ("#" + hashtag.getText, 1))

			// Use reduceByKeyAndWindow to reduce our hashtag pairs by summing their
			// counts over the last 10 seconds of batch intervals (in this case, 2 RDDs).
			val topCounts10 = hashTagPairs.reduceByKeyAndWindow((l, r) => {l + r}, Seconds(10))

			// topCounts10 will provide a new RDD for every window. Calling transform()
			// on each of these RDDs gives us a per-window transformation. We use
			// this transformation to sort each RDD by the hashtag counts. The FALSE
			// flag tells the sortBy() function to sort in descending order.
			val sortedTopCounts10 = topCounts10.transform(rdd => 
			rdd.sortBy(hashtagPair => hashtagPair._2, false))

			// Print popular hashtags.
			sortedTopCounts10.foreachRDD(rdd => {
				val topList = rdd.take(10)
				println("\nPopular topics in last 10 seconds (%s total):".format(rdd.count()))
				topList.foreach{case (tag, count) => println("%s (%d tweets)".format(tag, count))}
			})

			ssc.start()
			ssc.awaitTermination()
	}
}
