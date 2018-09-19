package spark

import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.SparkConf
import org.apache.log4j.Logger
import org.apache.log4j.Level

/**
 * @author Veera
 *
 */
object Tweets {

	def main(args : Array[String]):Unit = {

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

			System.setProperty("hadoop.home.dir", "D:\\hadoop\\")

			/*
			 * Initialize and setup the Spark  configuration i.e StreamingContext
			 * */

			val conf = new SparkConf().setMaster("local[2]").setAppName("Streaming Tweets")

			/*
			 * Use the configuration to create the Streaming Context 
			 **/

			val ssc = new StreamingContext(conf, Seconds(2))

			/*
			 * Getting OAuth To Twitter API
			 * using the following keys provided by Twitter
			 * when you create an app from 
			 * apps.twitter.com.  
			 **/

			System.setProperty("twitter4j.oauth.consumerKey", "06VbUtXmxCIycXgEJy6F2ZqeJ")
			System.setProperty("twitter4j.oauth.consumerSecret", "R1OHvmRcKELyHBDLnGca1QOW1tAR2SgtGkkqhOi2KySeCexFOa")
			System.setProperty("twitter4j.oauth.accessToken", "925004856-ewsJKUawywszTXpHfA76XvYgOJWgIeR8jBBY77Aa")
			System.setProperty("twitter4j.oauth.accessTokenSecret","pufuk7ZoQHSE8WIzDdIRdwzB3Hdp6KlTZwlHgXVkr34Xd")


			/*val filters : Array[String]  = Array("Apache","BCCI","ICC","IPL","BigData","AI","Robotics","spark")
			println("filters used are : "+filters.mkString(","))*/

			/*
			 * Usage of Filters or keywords so that only those tweets 
			 * will be Streamed 
			 **/

			val streams = TwitterUtils.createStream(ssc, None)

			// extracting only english tweets
			val englishTweets = streams.filter(_.getLang() == "en")   

			/*
			 * Each Tweet comes as a twitter4j.Status object, 
			 * which we can use to extract Text
			 **/

			val statuses = englishTweets.map(status => status.getText())

			statuses.print()
			ssc.start()
			ssc.awaitTermination()


	}
}