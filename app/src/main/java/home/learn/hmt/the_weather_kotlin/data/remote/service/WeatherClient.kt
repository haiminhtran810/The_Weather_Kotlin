package home.learn.hmt.the_weather_kotlin.data.remote.service

import home.learn.hmt.the_weather_kotlin.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
class WeatherClient {
  companion object {
    fun getApiInstance(): WeatherAPI {
      val retrofit = Retrofit.Builder()
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl(BuildConfig.BASE_URL).build()
      return retrofit.create(WeatherAPI::class.java)
    }
  }
}