package controllers

import java.text.SimpleDateFormat

import org.joda.time.DateTime
import java.util.Date
import org.joda.time.format.DateTimeFormat
import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    //with joda DateTime
    val currentTimeWithJoda = new DateTime("2017-01-30")
    //return : 2017-01-30T00:00:00.000+07:00
    val fromDynamicString = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss")
      .parseDateTime("30/01/2017 20:27:05")
    //return : 2017-01-30T20:27:05.000+07:00
    val jodaToStringFormat = currentTimeWithJoda.toString("EEE MMM dd hh:mm:ss yyyy")
    //return : "2016-01-03"


    //with java Date
    val currentTimeWithJavaDate = new Date()
    //return : Sun Jan 03 12:30:26 GMT 2016
    val javaDateToString = currentTimeWithJavaDate.toString()
    //return : "Sun Jan 03 12:30:26 GMT 2016"
    val formatter = new SimpleDateFormat("yyyy/MM/dd");
    val javaDateToStringFormat = formatter.format(currentTimeWithJavaDate)
    //return : "2016-01-03"
    val stringFormatToJavaDate = formatter.parse("2017/01/30")
    //return : Mon Jan 30 00:00:00 GMT 2017


    Ok(currentTimeWithJoda + " - " + fromDynamicString + " - " +currentTimeWithJavaDate+ " - " + javaDateToStringFormat + " - " + stringFormatToJavaDate)
  }

}
