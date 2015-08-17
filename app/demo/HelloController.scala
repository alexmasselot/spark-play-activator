package demo

import org.apache.spark.sql.DataFrame
import play.api.mvc._

/**
 * @author Alexandre Masselot.
 */
object HelloController extends Controller {
  val dataFile = "resources/tweet-json"
  lazy val rdd = SparkCommons.sqlContext.read.json(dataFile)

  def index = Action {
    Ok("hello world")
  }

  /**
   * dataframe can output, with toJSON, a list of json string. They just need to be wrapped with [] and commas
   * @param rdd
   * @return
   */
  def toJsonString(rdd:DataFrame):String =
    "["+rdd.toJSON.collect.toList.mkString(",\n")+"]"

  /**
   * number of elements
   * @return
   */
  def count = Action {
    Ok(rdd.count.toString)
  }

  /**
   * list them all
   * @return
   */
  def list = Action {
    Ok(toJsonString(rdd))
  }

  /**
   * make a fileter action on the dataframe element "text" field
   * @param text
   * @return
   */
  def filter(text:String) = Action {
    Ok(toJsonString(rdd.filter(rdd("text").contains(text))))
  }
}
