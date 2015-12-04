package core.utils

import play.api.mvc.{Request, AnyContent}
import play.api.Logger


/**
 * 工具包
 * Created by lzh on 14-3-24.
 */
object CommonUtil {

  /*获取浏览器默认语言*/
  def userLang(request: Request[AnyContent]) = {
    var lan = "en"
    try{
      //获取浏览器默认语言
      if(request.headers != None && request.headers.get("Accept-Language") != None
        && request.headers.get("Accept-Language").isDefined
        && request.headers.get("Accept-Language").nonEmpty){
        val header = request.headers.get("Accept-Language").getOrElse("").split(";")
        if (header.length > 0) {
          if (header.apply(0).indexOf(",") >= 0) {
            lan = header.apply(0).split(",").apply(0)
          }
          else {
            lan = header.apply(0)
          }
        }else{
          lan = "en"
        }
      }
    } catch{
      case e:Exception => Logger.error(e.toString)
    }
    //处理IE浏览器
    if(lan.equals("zh-Hans-CN")){
      lan = "zh-cn"
    }
    lan
  }
}
