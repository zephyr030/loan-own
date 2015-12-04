package core.utils

import java.util.Random

/**
 * Created with IntelliJ IDEA.
 */
object RandomNumber {

  def getRandInt() = {
    val random = new Random()
    random.nextInt(10)
  }
  def getExchangeCode(length:Int) = {
    val randomValidateCode = new StringBuffer()
    for (j <- 0 until length) {
      val one:Int = getRandInt()// 获得一个随机数
      if (j == 0) {
        randomValidateCode.append(one).append("#");// 添加随机数和分隔符
      } else if (j > 0) {
        val all:Array[String] = randomValidateCode.toString().split("#")// 分割成字符串数组
        // 调用是否重复方法teseEquals
        if (RandomNumber.teseEquals(all, one, randomValidateCode) == 1) {
          randomValidateCode.append(one).append("#");// 如果不重复就添加随机数和分隔符
        }
      }
    }
    // 对得到的8位随机数用分隔符进行分割
    val result = randomValidateCode.toString().split("#")
    val res = new StringBuffer()
    for (r <- 0 until result.length) {
      res.append(result(r))
    }
    res
  }
  def teseEquals(all:Array[String], one:Int, randomValidateCode:StringBuffer) = {
    var int:Int = 1  // 不重复返回1
    for (i<- 0 until all.length) {
      if (one == java.lang.Integer.parseInt(all(i))) {
        int = 0// 重复就返回0
      }
    }
    int
  }

}

