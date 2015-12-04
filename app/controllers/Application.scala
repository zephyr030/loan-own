package controllers

import core.utils.HttpClient
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    request =>
      val map: Map[String, String] = Map[String, String]("page" -> "1", "limit" -> "2", "sort" -> "startTime", "dir" -> "desc", "type" -> "ALL")
      val res = HttpClient.getResponse("https://www.jintouhui.com/site/lend/ajax/LendList", map)
      Ok(res).as("text/html;charset=UTF-8")
  }
}
