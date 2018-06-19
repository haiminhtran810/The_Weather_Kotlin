package home.learn.hmt.the_weather_kotlin.screen.splash

import android.content.Context
import home.learn.hmt.the_weather_kotlin.base.navigator.BaseNavigator

/**
 * Created by hcm-102-0006 on 19/06/2018.
 */
interface SplashNavigator : BaseNavigator {
  fun getContext(): Context
}