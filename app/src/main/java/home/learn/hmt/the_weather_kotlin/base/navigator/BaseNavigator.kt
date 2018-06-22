package home.learn.hmt.the_weather_kotlin.base.navigator

/**
 * Created by hcm-102-0006 on 19/06/2018.
 */
interface BaseNavigator {
  fun finish()
  fun onBackPressed()
  fun showError(errorMessage : String)
}