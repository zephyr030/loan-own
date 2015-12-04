package core.utils

import org.apache.commons.mail.{HtmlEmail, DefaultAuthenticator, SimpleEmail}
import play.api.Play
import javax.mail.Session
import java.net.PasswordAuthentication

/**
 * Created by Sili Jiang on 14-3-19.
 */
object EmailUtil {

  /**
   * 发送内容邮件
   *
   * @param subject 主题
   * @param msg 邮件内容
   * @param toEmail 发送e_mail地址
   * @return
   */
  def sendSimpleEmail(subject: String, msg: String, toEmail: String) = {
    val email = new HtmlEmail()

    email.setSSLOnConnect(true)
    email.setHostName(ConfigUtil.getString("mail.host"))
    email.setSmtpPort(ConfigUtil.getInt("mail.port"))
    email.setAuthentication(ConfigUtil.getString("mail.username"), ConfigUtil.getString("mail.password"))
   // email.setAuthenticator();

    email.setSslSmtpPort("465")
    email.setCharset(ConfigUtil.getString("mail.charset"))
    email.setFrom(ConfigUtil.getString("mail.from"))
    email.setSubject(subject)
    email.setMsg(msg)
    email.addTo(toEmail)
    email.send()
  }
}
