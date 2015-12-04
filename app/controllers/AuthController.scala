package controllers

import java.util.stream.StreamSpliterators

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import core.mvc.WAction
import core.utils.{EmailUtil, ConfigUtil}
import module.SysUser
import module.form._
import play.api.i18n.Messages
import play.api.libs.json.Json
import play.api.mvc._
import play.api.i18n.Messages.Implicits._
import play.api.Play.current

/**
  * Created by Administrator on 2015/11/19.
  */
class AuthController extends Controller{

  def auth = Action {
    request =>
      val str = ""
      Ok(str).as("text/html")
  }

  def login(uri: String) = WAction {
    implicit viewData =>

      val g = new Gson()
      val map = Map("username" -> "String", "key" -> "value")
      val rMap = g.fromJson[java.util.Map[String, Object]]("{\"key1\":\"username\",\"value1\":\"String\",\"key2\":\"key\",\"value2\":\"value\"}", new TypeToken[java.util.Map[String,Object]](){}.getType())
      println("++++++++++++++++" + rMap)


      val str = Messages("login.title")
      val user:SysUser = SysUser.userList("10000132")
      println("注册:" + str)
      //EmailUtil.sendSimpleEmail("测试邮件", "收到邮件否", "76237574@qq.com")
      val form = LoginForm.loginForm.bind(Map("username" -> "String"))
      Ok(views.html.auth.login(form)).withHeaders(CACHE_CONTROL -> "no-cache").as("text/html")
  }

  def doLogin() = WAction {
    implicit viewData =>
      LoginForm.loginForm.bindFromRequest.fold(
        formWithErrors => {
          BadRequest(views.html.auth.login(formWithErrors))
        },
        userData => {
          Ok(views.html.index())
        }
      )
  }

  def goHome = WAction {
    implicit viewData =>
      val map = viewData.request.body.asFormUrlEncoded
      val value = map.get.get("value1").getOrElse("value1")
      println(value)
      Ok(map.toString).as("text/html")
  }
}
