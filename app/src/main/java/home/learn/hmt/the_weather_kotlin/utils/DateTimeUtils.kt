package home.learn.hmt.the_weather_kotlin.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by hcm-102-0006 on 29/06/2018.
 */
class DateTimeUtils {
  companion object {
    const val TIME_WITHOUT_SECOND_FORMAT: String = "HH:mm"
    fun convertDateToString(time: Long, format: String): String {
      var dateFormat = SimpleDateFormat(format, Locale.getDefault())
      return dateFormat.format(Date(time))
    }
  }
}