package home.learn.hmt.the_weather_kotlin.screen.home.currentweather

import home.learn.hmt.the_weather_kotlin.base.viewmodel.BaseDataLoadViewModel
import home.learn.hmt.the_weather_kotlin.data.module.WeatherData
import home.learn.hmt.the_weather_kotlin.data.remote.WeatherRepository
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
class CurrentWeatherViewModel : BaseDataLoadViewModel() {
  private var weatherRepository: WeatherRepository = WeatherRepository.getInstance()
  private lateinit var weatherData: WeatherData
  lateinit var navigator: CurrentWeatherNavigator

  init {

  }

  fun loadData() {
    weatherRepository.getCurrentWeather(123.toDouble(),
        321.toDouble()).subscribe(object : DisposableSingleObserver<WeatherData>() {
      override fun onSuccess(t: WeatherData) {
        if (t != null) {
          var te: Int = 0
        }
      }

      override fun onError(e: Throwable) {
        navigator.showError(e.message ?: "")
      }
    })
  }

}




