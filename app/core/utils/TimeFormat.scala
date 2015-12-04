package core.utils

import java.util.Calendar
import java.text.SimpleDateFormat
import java.util.Date

import org.joda.time._
import play.api.Logger

/**
 * Created with IntelliJ IDEA.
 * User: lzh
 * Date: 13-10-10
 * Time: 下午2:02
 * To change this template use File | Settings | File Templates.
 */
object TimeFormat {


  // 短日期格式
  val DATE_FORMAT = "yyyy-MM-dd"

  val FORMAT_MIN = "yyyy-MM-dd HH:mm"

  // 长日期格式
  val TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"

  /**
   * 格式化时间显示
   * @param time
   * @param format
   */
  def timeFormat(time: String, format: String = "yyyy-MM-dd") = {
    var backTime: String = ""
    if (time != null || !time.equals("")) {
      backTime = new java.text.SimpleDateFormat(format).format(new java.util.Date(time.toLong))
    }
    backTime
  }

  /*国际化时间*/
  def timeil8n(time: String, format: String = "yyyy-MM-dd") = {
    var backTime: String = ""
    if (time != null || !time.equals("")) {
      val date = new SimpleDateFormat("yyyy-MM-dd").parse(time)
      backTime = new SimpleDateFormat(format).format(date)
    }
    backTime
  }

  /**
   * 圣诞节领奖日期特殊格式化
   * @param time
   * @return
   */
  def hourFormat(time: String) = {
    var backTime: String = ""
    if (time != null || !time.equals("")) {
      backTime = time.substring(0, 2) + "-" + time.substring(2, 4) + " " + time.substring(4, 6) + ":" + time.substring(6, 8)
      backTime
    }
  }


  /**
   * String to long
   *
   * @param date
   * @param format
   * @return
   */
  def string2Long(date: String, format: String) = {
    val sf = new SimpleDateFormat(format)
    sf.parse(date).getTime
  }

  /**
   * Long to string
   *
   * @param time
   * @param format
   * @return
   */
  def long2String(time: Long, format: String) = {
    val sf = new SimpleDateFormat(format)
    val date = new Date(time)
    sf.format(date)
  }

  /**
   * Date to string
   *
   * @param date
   * @param format
   * @return
   */
  def date2String(date: Date, format: String) = {
    val sf = new SimpleDateFormat(format)
    sf.format(date)
  }

  /**
   * Date to long
   *
   * @param date
   * @param format
   */
  def date2Long(date:Date,format:String) = {
    string2Long(date2String(date, format), format)
  }

  def minus(startTime: String, endTime: String, format: String) = {
    val sd = new SimpleDateFormat(format)
    val nd: Long = 1000 * 24 * 60 * 60
    // 一天的毫秒数
    val nh: Long = 1000 * 60 * 60
    // 一小时的毫秒数
    val nm: Long = 1000 * 60
    // 一分钟的毫秒数
    val ns: Long = 1000
    // 获得两个时间的毫秒时间差异
    val diff = sd.parse(endTime).getTime - sd.parse(startTime).getTime
    val day = diff / nd
    // 计算差多少天
    val hour = diff % nd / nh + day * 24
    // 计算差多少小时
    val min = diff % nd % nh / nm + day * 24 * 60
    // 计算差多少分钟
    val sec = diff % nd % nh % nm / ns; // 计算差多少秒
    // 输出结果
    //println("时间相差：" + day + "天" + (hour - day * 24) + "小时"
    //  + (min - day * 24 * 60) + "分钟" + sec + "秒。")
    //println("hour=" + hour + ",min=" + min)
    (day, hour - day, min - day)
  }

  /**
   * 获取指定日期是星期几
   */
  def weekOfTime(time:Long) = {
    val weekDay = Array[String]("Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    val cal = Calendar.getInstance()
    cal.setTimeInMillis(time)
    var week = cal.get(Calendar.DAY_OF_WEEK) - 1
    if (week < 0){
      week = 0
    }
    weekDay(week)
  }

  /**
   * 年月日时分秒时间差
   */
  def timeDifference(start:Long,end:Long) = {
    //val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //val date1 = timeFormat(start+"","yyyy-MM-dd HH:mm:ss")
    //val date2 = timeFormat(end+"","yyyy-MM-dd HH:mm:ss")
    var map = Map[String,String]("day"-> "0","hours" -> "0","min" -> "0","seconds" -> "0")
    try{
      val dt1 = new DateTime(new Date(start))
      val dt2 = new DateTime(new Date(end))
      map = map.updated("day",Days.daysBetween(dt1, dt2).getDays()+"")
      map = map.updated("hours", Hours.hoursBetween(dt1, dt2).getHours() % 24+"")
      map = map.updated("min",Minutes.minutesBetween(dt1, dt2).getMinutes() % 60+"")
      map = map.updated("seconds",Seconds.secondsBetween(dt1, dt2).getSeconds() % 60+"")
    }catch {
      case e:Exception => Logger.error(e.toString)
      map = Map[String,String]("day"-> "0","hours" -> "0","min" -> "0","seconds" -> "0")
    }
    map
  }

  def beyandTime(time: Long) = {
    var _type = 1
    var result:Long = 0
    val nowTime = System.currentTimeMillis()
    val beyand = nowTime - time
    if(beyand / (24 * 60 * 60 * 1000) > 0) {
      _type = 1
      result = beyand / (24 * 60 * 60 * 1000)
    } else if(beyand / (60 * 60 * 1000) > 0) {
      _type = 2
      result = beyand / (60 * 60 * 1000)
    } else if(beyand / (60 * 1000) > 0) {
      _type = 3
      result = beyand / (60 * 1000)
    } else if(beyand / 1000 > 0) {
      _type = 4
      result = beyand / 1000
    } else {
      _type = 4
    }
    Map[String, Long]("time" -> result, "type" -> _type)
  }
}
