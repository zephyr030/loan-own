package core.utils

import org.apache.commons.lang3.StringEscapeUtils

/**
 * 字符串格式化工具类
 * Created by lzh on 14-3-1.
 */
object StringUtil {
  /*StringToUnicode*/
  def toUnicode(str:String) = {
    val unicode = StringEscapeUtils.escapeJava(str)
    unicode
  }

  /*UnicodeToString*/
  def fromUnicode(str:String) = {
    val unUnicode = StringEscapeUtils.unescapeJava(str)
    unUnicode
  }

  /*获取字符串长度中文算两个字符*/
  def strLenth(str:String) = {
    var len = 0
    for(i <- str){
      val c = i.asInstanceOf[Byte]
      if((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)){
        len = len+1
      }else{
        len = len+2
      }
    }
    len
  }
}



