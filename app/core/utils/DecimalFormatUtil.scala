package core.utils

import java.text.DecimalFormat

/**
 * Created by Sili Jiang on 14-4-27.
 */
object DecimalFormatUtil {

  /**
   *
   * @param size
   */
  def readableFileSize(size: Long) = {
    if (size <= 0) "0"
    val units = Array("B", "KB", "MB", "GB", "TB")
    val digitGroups = (Math.log10(size) / Math.log10(1024)).toInt
    new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units(digitGroups)
  }
}
