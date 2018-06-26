package home.learn.hmt.the_weather_kotlin.data.remote

import home.learn.hmt.the_weather_kotlin.data.module.Forecast53Data
import home.learn.hmt.the_weather_kotlin.data.module.WeatherData
import home.learn.hmt.the_weather_kotlin.data.remote.datasource.IWeatherDataSource
import home.learn.hmt.the_weather_kotlin.data.remote.datasource.WeatherDataSource
import io.reactivex.Single

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
class WeatherRepository(var iWeatherDataSource: IWeatherDataSource) : IWeatherDataSource {

  companion object {
    private var instance: WeatherRepository? = null

    fun getInstance(): WeatherRepository {
      if (instance == null) {
        instance = WeatherRepository(WeatherDataSource.getInstance())
      }
      return instance as WeatherRepository
    }
  }

  override fun getCurrentWeather(lat: Double, lon: Double): Single<WeatherData> {
    return iWeatherDataSource.getCurrentWeather(lat, lon)
  }

  override fun getDailyWeather(lat: Double, lon: Double): Single<Forecast53Data> {
    return iWeatherDataSource.getDailyWeather(lat, lon)
  }
}