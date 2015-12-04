package module.form

import play.api.data._
import play.api.data.Forms._
import play.api.i18n.Messages
import play.api.mvc._
import play.api.libs.json.Json

case class LoginFrom(username: String, password: String, sex: Int)

/**
  * Created by Administrator on 2015/11/25.
  */
object LoginForm {
  implicit val fmt = Json.format[LoginFrom]
  /**
    * 登录表单验证
    *
    * @param request
    * @return
    */
  def loginForm(implicit request: Request[_]) = Form[LoginFrom](
    mapping(
      "username" -> email,
      "pwd" -> nonEmptyText(minLength = 6, maxLength = 20),
      "sex" -> number
    )(LoginFrom.apply)(LoginFrom.unapply)
  )
}
