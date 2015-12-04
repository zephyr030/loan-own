package core.utils

import com.ning.http.client.AsyncHttpClient
import play.api.Logger

/**
 * HTTP访问方法
 * User: lzh
 * Date: 13-10-26
 * Time: 下午11:39
 * To change this template use File | Settings | File Templates.
 */
object HttpClient {
  /**
   * 请求服务器返回数据方法
   * @param url 路劲
   * @param map 参数
   * @return response
   */
  def getResponse(url:String,map:Map[String,String] = Map[String,String]())={
    val time = System.currentTimeMillis()
    val urlWS = new AsyncHttpClient
    var get = urlWS.prepareGet(url).addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    map.map {
      k =>
        get = get.addQueryParam(k._1, k._2)
    }
    val response = get.execute()
    var res = ""
    try {
      res = response.get().getResponseBody
    }catch {
      case e:Exception => Logger.error(e.toString + "________the exception url is:"+url+"...time over is "+(System.currentTimeMillis()-time)+"ms")
    }
    res
  }

  def postResponse(url:String,map:Map[String,String] = Map[String,String]())={
    val time = System.currentTimeMillis()
    val urlWS = new AsyncHttpClient
    var post = urlWS.preparePost(url).addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    map.map {
      k =>
        post = post.addQueryParam(k._1, k._2)
    }
    val response = post.execute()
    var res = ""
    try {
      res = response.get().getResponseBody
    }catch {
      case e:Exception => Logger.error(e.toString + "________the exception url is:"+url+"...time over is "+(System.currentTimeMillis()-time)+"ms")
    }
    res
  }
}
