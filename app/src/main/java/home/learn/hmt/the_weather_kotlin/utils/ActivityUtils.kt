package home.learn.hmt.the_weather_kotlin.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * Created by hcm-102-0006 on 19/06/2018.
 */
class ActivityUtils {
  companion object {
    fun goToActivity(context: Context, activity2: Class<*>, bundle: Bundle? = null,
        flag: Int = 0) {
      context.startActivity(Intent(context, activity2).apply {
        if (flag != 0) {
          flags = flag
        }
        if (bundle != null) {
          putExtras(bundle)
        }
      })
    }
  }
}