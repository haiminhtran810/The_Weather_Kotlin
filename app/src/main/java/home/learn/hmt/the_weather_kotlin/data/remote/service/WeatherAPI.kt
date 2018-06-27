package home.learn.hmt.the_weather_kotlin.data.remote.service

import home.learn.hmt.the_weather_kotlin.data.module.Forecast53Data
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
      @Query("lon") long: Double,
      @Query("appid") appid: String
  ): Single<WeatherData>

  @GET("data/2.5/forecast/daily")
  fun getDailyWeather(
      @Query("lat") lat: Double,
      @Query("lon") long: Double,
      @Query("cnt") cnt: Int,
      @Query("appid") appid: String
  ): Single<Forecast53Data>

}