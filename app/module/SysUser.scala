package module

import anorm._
import anorm.SqlParser._
import play.api.db.DB
import play.api.Play.current

case class SysUser(id:Int,username:String, password:String)
/**
  * Created by Administrator on 2015/11/25.
  */
object SysUser {
  val allUser = {
    get[Int]("id") ~
      get[String]("username") ~
      get[String]("password") map {
      case id~  username ~ password =>
        SysUser(id,username, password)
    }
  }

  def userList(id: String) = DB.withConnection {
    implicit conn =>
      SQL(
        """
          |select id, username, password from sys_user where id = {id}
        """.stripMargin).on('id -> id).as(allUser.single)
  }
}
