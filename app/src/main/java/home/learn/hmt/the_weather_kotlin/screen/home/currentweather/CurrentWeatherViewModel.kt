package home.learn.hmt.the_weather_kotlin.screen.home.currentweather

import android.arch.lifecycle.MutableLiveData
import home.learn.hmt.the_weather_kotlin.base.viewmodel.BaseDataLoadViewModel
import home.learn.hmt.the_weather_kotlin.data.module.WeatherData
import home.learn.hmt.the_weather_kotlin.data.remote.WeatherRepository
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
class CurrentWeatherViewModel : BaseDataLoadViewModel() {

  // val means final. This variable cannot be reassigned.
  // var for a variable that can be reassigned.

  private var weatherRepository: WeatherRepository = WeatherRepository.getInstance()
  lateinit var navigator: CurrentWeatherNavigator
  var weather = MutableLiveData<WeatherData>()

  init {

  }

  fun loadData() {
    weatherRepository.getCurrentWeather(10.802283,
        106.714573).subscribe(object : DisposableSingleObserver<WeatherData>() {
      override fun onSuccess(t: WeatherData) {
        weather.apply { value = t }
        navigator.hideShowLoading(false)
      }

      override fun onError(e: Throwable) {
        navigator.showError(e.message ?: "")
      }
    })
  }
}




