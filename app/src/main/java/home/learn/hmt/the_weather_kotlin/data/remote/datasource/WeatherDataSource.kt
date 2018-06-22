package home.learn.hmt.the_weather_kotlin.data.remote.datasource

import home.learn.hmt.the_weather_kotlin.BuildConfig
import home.learn.hmt.the_weather_kotlin.data.module.WeatherData
import home.learn.hmt.the_weather_kotlin.data.remote.service.WeatherClient
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by hcm-102-0006 on 21/06/2018.
 */
class WeatherDataSource : IWeatherDataSource {

  companion object {
    private var instance: WeatherDataSource? = null

    fun getInstance(): WeatherDataSource {
      if (instance == null) {
        instance = WeatherDataSource()
      }
      return instance as WeatherDataSource
    }
  }

  override fun getCurrentWeather(lat: Double, lon: Double): Single<WeatherData> {
    return WeatherClient.getApiInstance().getCurrentWeather(lat, lon,
        BuildConfig.WEATHER_API_KEY).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread())
  }
}