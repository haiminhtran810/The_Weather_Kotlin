package home.learn.hmt.the_weather_kotlin.screen.home.hourlyweather

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import home.learn.hmt.the_weather_kotlin.base.screen.fragment.BaseDataMoreRefreshFragment
import home.learn.hmt.the_weather_kotlin.data.module.WeatherData
import home.learn.hmt.the_weather_kotlin.databinding.FragmentHourWeatherBinding


/**
 * A simple [Fragment] subclass.
 */
class HourWeatherFragment : BaseDataMoreRefreshFragment<FragmentHourWeatherBinding, HourWeatherViewModel, WeatherData>(), HourWeatherNavigator {
  override fun finish() {
  }

  override fun onBackPressed() {
  }

  override fun showError(errorMessage: String) {
    Log.d("Error", errorMessage)
  }

  override fun onClickItem(weatherData: WeatherData) {
  }

  companion object {
    fun newInstance(): HourWeatherFragment {
      val hourWeatherFragment = HourWeatherFragment()
      val bundle = Bundle()
      hourWeatherFragment.apply {
        arguments = bundle
      }
      return hourWeatherFragment
    }
  }

  override fun initAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder> {
    return HourDailyAdapter(this!!.context!!, mViewModel.listItem,
        mViewModel.itemClickListener) as RecyclerView.Adapter<RecyclerView.ViewHolder>
  }

  override fun initViewModel(): HourWeatherViewModel {
    return ViewModelProviders.of(this).get(HourWeatherViewModel::class.java)
  }

  override fun initData() {
    super.initData()
  }

  override fun intLayoutManager(): RecyclerView.LayoutManager {
    return LinearLayoutManager(activity)
  }

}
