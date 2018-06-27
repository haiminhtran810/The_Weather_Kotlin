package home.learn.hmt.the_weather_kotlin.screen.home.hourlyweather

import home.learn.hmt.the_weather_kotlin.base.navigator.BaseNavigator
import home.learn.hmt.the_weather_kotlin.data.module.WeatherData

/**
 * Created by hcm-102-0006 on 27/06/2018.
 */
interface HourWeatherNavigator : BaseNavigator{
  fun onClickItem(weatherData: WeatherData)
}