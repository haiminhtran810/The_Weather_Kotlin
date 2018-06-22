package home.learn.hmt.the_weather_kotlin.data.remote.service

import home.learn.hmt.the_weather_kotlin.data.module.WeatherData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by hcm-102-0006 on 21/06/2018.
 */
interface WeatherAPI {
  @GET("data/2.5/weather")
  fun getCurrentWeather(
      @Query("lat") lat: Double,
      @Query("lon") lon: Double,
      @Query("appid") appid: String
  ): Single<WeatherData>
}