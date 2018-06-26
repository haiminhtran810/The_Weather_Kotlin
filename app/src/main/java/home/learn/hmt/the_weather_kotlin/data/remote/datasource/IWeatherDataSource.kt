package home.learn.hmt.the_weather_kotlin.data.remote.datasource

import home.learn.hmt.the_weather_kotlin.data.module.Forecast53Data
import home.learn.hmt.the_weather_kotlin.data.module.WeatherData
import io.reactivex.Single

/**
 * Created by hcm-102-0006 on 21/06/2018.
 */
interface IWeatherDataSource {
  fun getCurrentWeather(lat: Double, lon: Double): Single<WeatherData>
  fun getDailyWeather(lat: Double, lon: Double): Single<Forecast53Data>
}