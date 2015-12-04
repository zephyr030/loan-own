package core.mvc

import core.auth.Authenticator
import play.api.mvc._
import scala.concurrent.Future
import controllers.routes

object WAction extends ActionBuilder[ViewData] {

  def invokeBlock[A](request: Request[A], block: (ViewData[A]) => Future[Result]) = {
    val v = new ViewData(request).apply()
    block(v)
  }
}

object Authorize extends  ActionBuilder[ViewData] {
  def invokeBlock[A](request: Request[A], block: (ViewData[A]) => Future[Result])  = {
    request.cookies.get(Authenticator.cookieName).map { token =>
      block(new ViewData(request).apply())
    } getOrElse {
      Future.successful(
        Results.Redirect(routes.AuthController.login(request.uri))
      )
    }
  }
}

object Action extends ActionBuilder[Request] {
  def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = block(request)
}