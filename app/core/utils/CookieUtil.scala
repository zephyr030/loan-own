package core.utils

import play.api.mvc.{DiscardingCookie, Cookie}

/**
 * Created by Sili Jiang on 14-2-24.
 */
object CookieUtil {
  /**
   * Set cookie
   *
   * @param key the cookie name
   * @param value the cookie value
   * @return
   */
  def toCookie(key: String, value: String): Cookie = {
    Cookie(
      key,
      value,
      None,
      "/",
      domain = None,
      secure = false,
      httpOnly = false
    )
  }

  /**
   * Set cookie remember
   *
   * @param key the cookie name
   * @param value the cookie value
   * @return
   */
  def toRememberCookie(key: String, value: String): Cookie = {
    Cookie(
      key,
      value,
      Some(60 * 60 * 12),
      "/",
      domain = None,
      //Option(".*"),
      secure = false,
      httpOnly = false
    )
  }

  /**
   * Set discarding cookie
   *
   * @param key the cookie name
   * @return
   */
  def toDiscardingCookie(key: String): DiscardingCookie = {
    DiscardingCookie(
      key, "/",
      domain = None
      //Option(".*")
    )
  }
}
