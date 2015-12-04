package core.utils

import play.api.mvc.{Request, AnyContent}
import play.api.Logger

/**
 * Created with IntelliJ IDEA.
 * User: DHF
 * Date: 13-11-5
 * Time: 下午6:25
 */
object HttpUtils {
  def ip(request:Request[AnyContent]) = {
    try{
      var ip:String = request.headers.get("Cdn-Src-Ip") match {
        case Some(s) => s.replace(" ", "").split(",")(0)
        case None => ""
      }
      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.headers.get("X-Forwarded-For") match {
          case Some(s) =>s.replace(" ", "").split(",")(0)
          case None => ""
        }
      }
      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.headers.get("X-Real-IP") match {
          case Some(s) => s.replace(" ", "").split(",")(0)
          case None => ""
        }
      }
      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.headers.get("REMOTE-HOST") match {
          case Some(s) => s.replace(" ", "").split(",")(0)
          case None => ""
        }
      }

      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip =  request.remoteAddress
      }
      ip
    }catch {
      case e:Exception => Logger.error("HttpUtils ip header is really exite?"+e.toString)
      ""
    }
  }

  //将127.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处理
  def ipToLong( strIp:String) = {
    val ip:Array[Long] = new Array[Long](4)
    //先找到IP地址字符串中.的位置
    val position1:Int = strIp.indexOf(".")
    val position2:Int = strIp.indexOf(".", position1 + 1)
    val position3:Int = strIp.indexOf(".", position2 + 1)
    //将每个.之间的字符串转换成整型
    ip(0) = java.lang.Long.parseLong(strIp.substring(0, position1))
    ip(1) = java.lang.Long.parseLong(strIp.substring(position1+1, position2))
    ip(2) = java.lang.Long.parseLong(strIp.substring(position2+1, position3))
    ip(3) = java.lang.Long.parseLong(strIp.substring(position3+1))
    (ip(0) << 24) + (ip(1) << 16) + (ip(2) <<  8 ) + ip(3)
  }
}
