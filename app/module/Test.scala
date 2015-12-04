package module

import com.google.gson.Gson

import scala.util.matching.Regex

/**
  * Created by Administrator on 2015/11/23.
  */
class Test(i:Int) {

}

object Test {
  def apply(fn:(Int) => String) {
    fn(36)
  }

  def tm(x:Int)(y: Int) : Int= {
    x + y
  }

  def main(arg:Array[String]): Unit = {


//    val regex1 = """([0-9]+) ([a-z]+)""".r
//    val line = "123 iteblog"
//    val regex = new Regex("""([0-9]+) ([a-z]+)""")
//    val regex(num, blog) = line
//    println(num)
//    println(blog)
//
//    val a = Test{
//      i =>
//        println(i)
//        i + ""
//    }
//
//    val b = Test.tm(1)(2)
//    println(b)
  }
}
