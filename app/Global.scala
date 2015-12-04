import play.api.Application
import play.api.{Logger, GlobalSettings}
import play.api.mvc.{Handler, RequestHeader}

/**
  * Created by Sili Jiang on 14-2-17.
  */
object Global extends GlobalSettings {
  override def onStart(app: Application) {
    Logger.info("Application started...")
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }

   override def onRouteRequest(request: RequestHeader): Option[Handler] = {
     super.onRouteRequest(request)
   }
 }