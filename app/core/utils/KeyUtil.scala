package core.utils

/**
 * cookie and cache
 * key
 */
object KeyUtil {

  /*cookie_key*/
  //用户信息
  val COOKIE_USER_INFO = "user_info"
  //_user
  val _USER = "_user"
  //login_token
  val Login_Token = "login_token"

  /*cache_key*/
  //国家
  val COUNTRY_CACHE = "country_cache"
  val JSCOUNTRY_CACHE = "js_country_cache"
  //城市
  val PROVINCE_CACHE = "province_cache"
  val JSPROVINCE_CACHE = "js_province_cache"
  //语言列表
  val LANLIST = "lanList"
  //用户加入圈子缓存
  val USERGROUP = "userGroup_"
  //圈子集合
  val GROUPMAP = "groupMap"
  //兴趣
  val HOBBY = "hobby"
  //学历
  val EDUCATION = "education"
  //行业
  val TRADE = "trade"
}
