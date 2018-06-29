package home.learn.hmt.the_weather_kotlin.screen.home.hourlyweather

import android.arch.lifecycle.MutableLiveData
import home.learn.hmt.the_weather_kotlin.base.screen.adapter.BaseViewHolderBinding
import home.learn.hmt.the_weather_kotlin.base.viewmodel.BaseDataLoadMoreRefreshViewModel
import home.learn.hmt.the_weather_kotlin.data.module.Forecast53Data
import home.learn.hmt.the_weather_kotlin.data.module.WeatherData
import home.learn.hmt.the_weather_kotlin.data.remote.WeatherRepository
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by hcm-102-0006 on 27/06/2018.
 */
class HourWeatherViewModel : BaseDataLoadMoreRefreshViewModel<WeatherData>() {

  lateinit var navigator: HourWeatherNavigator
  val forecast53Data = MutableLiveData<Forecast53Data>()
  val weatherRepository = WeatherRepository.getInstance()
  val itemClickListener = object : BaseViewHolderBinding.OnItemClickListener<WeatherData> {
    override fun onItemClick(position: Int, data: WeatherData) {
      navigator.onClickItem(data)
    }
  }

  override fun loadData(page: Int) {
    weatherRepository.getDailyWeather(10.803271,
        106.714725).subscribe(object : DisposableSingleObserver<Forecast53Data>() {
      override fun onError(e: Throwable) {
        navigator.showError(e.message ?: "")
      }

      override fun onSuccess(t: Forecast53Data) {
        forecast53Data.value = t
      }

    })
  }
}