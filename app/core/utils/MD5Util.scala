package core.utils

import play.api.libs.Codecs

/**
 * Created by Sili Jiang on 14-2-26.
 */
object MD5Util {


  /**
   * MD5加密
   *
   *
   * @param password
   * @return
   */
  def getMD5(password: String): String = {
    val md5 = Codecs.md5(password.getBytes).substring(8, 24)
    Codecs.md5(md5.getBytes())
  }

  /**
   * 写入CookieMD5加密
   *
   *
   * @param userId
   * @param password
   * @return userIdMD5前8位+密码md5取中间16位+userId后8位
   */
  def getCookieMD5(userId: String, password: String): String = {
    val md5 = Codecs.md5(password.getBytes).substring(8, 24)
    val userIdMd5 = Codecs.md5(userId.getBytes())
    userIdMd5.substring(0, 7) + md5 + userIdMd5.substring(25, 32)
  }

}
