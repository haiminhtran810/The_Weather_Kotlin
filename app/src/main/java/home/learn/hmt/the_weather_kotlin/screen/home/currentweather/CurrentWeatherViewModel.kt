package home.learn.hmt.the_weather_kotlin.screen.home.currentweather

import android.arch.lifecycle.MutableLiveData
import home.learn.hmt.the_weather_kotlin.BuildConfig
import home.learn.hmt.the_weather_kotlin.base.viewmodel.BaseDataLoadViewModel
import home.learn.hmt.the_weather_kotlin.data.module.Forecast53Data
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
  val weatherData = MutableLiveData<WeatherData>()
  val temp = MutableLiveData<String>()
  val des = MutableLiveData<String>()
  val wind = MutableLiveData<String>()
  val cloud = MutableLiveData<String>()
  val urlICon = MutableLiveData<String>()

  init {

  }

  fun loadData() {
    weatherRepository.getCurrentWeather(10.802283,
        106.714573).subscribe(object : DisposableSingleObserver<WeatherData>() {
      override fun onSuccess(t: WeatherData) {
        weatherData.value = t
        temp.value = t.main.temp.toString()
        des.value = t.weather?.get(0)?.description
        urlICon.value = BuildConfig.BASE_URL_ICON + t.weather?.get(0)?.icon + ".png"
        wind.value = t.wind?.toString()
        cloud.value = t.cloud?.toString()
        navigator.hideShowLoading(false)
      }

      override fun onError(e: Throwable) {
        navigator.showError(e.message ?: "")
      }
    })


    weatherRepository.getDailyWeather(10.802283,
        106.714573).subscribe(object : DisposableSingleObserver<Forecast53Data>() {
      override fun onSuccess(t: Forecast53Data) {
        val data = t
      }

      override fun onError(e: Throwable) {
        navigator.showError(e.message!!)
      }

    })
  }
}




