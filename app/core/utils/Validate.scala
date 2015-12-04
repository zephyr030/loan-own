package core.utils

/**
 * Created by lzh on 14-2-25.
 */
object Validate {
  /**
   * 验证数字范围
   * @param value 验证的值
   * @param x 参数范围x
   * @param y 参数范围y
   * @return boolean
   */
  def numberRange(value:Int,x:Int,y:Int) = {
    if(value > x && value < y ){
      true
    }else{
      false
    }
  }
}
