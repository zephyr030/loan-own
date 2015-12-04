package core.utils

import play.api.{Environment, Configuration, Play}

import scala.reflect.io.{Path, File}

/**
  * Created by Administrator on 2015/11/19.
  */
object ConfigUtil {

  val configuration = Play.current.configuration

  def getString(path:String*):String = {
    var conf:String = ""
    path.map {
      key =>
        conf += key + "."
    }
    conf = conf.substring(0, conf.length - 1)
    configuration.getString(conf).getOrElse(null)
  }

  def getInt(path:String*):Int = {
    var conf:String = ""
    path.map {
      key =>
        conf += key + "."
    }
    conf = conf.substring(0, conf.length - 1)
    configuration.getInt(conf).getOrElse(0)
  }
}
