package home.learn.hmt.the_weather_kotlin.screen.home.currentweather

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import home.learn.hmt.the_weather_kotlin.R
import home.learn.hmt.the_weather_kotlin.base.screen.fragment.BaseDataBindFragment
import home.learn.hmt.the_weather_kotlin.base.screen.fragment.BaseDataLoadFragment
import home.learn.hmt.the_weather_kotlin.databinding.FragmentCurrentWeatherBinding


/**
 * A simple [Fragment] subclass.
 */
class CurrentWeatherFragment : BaseDataLoadFragment<FragmentCurrentWeatherBinding, CurrentWeatherViewModel>(), CurrentWeatherNavigator {
  override fun showError(errorMessage: String) {
    Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
  }


  override fun initViewModel(): CurrentWeatherViewModel {
    return ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java).apply {
      navigator = this@CurrentWeatherFragment
    }
  }

  override fun getLayoutId(): Int {
    return R.layout.fragment_current_weather
  }

  override fun initData() {
    super.initData()
    mViewModel.apply {
      loadData()
    }
  }

  companion object {
    fun newInstance(): CurrentWeatherFragment {
      var currentWeatherFragment = CurrentWeatherFragment()
      var bundle = Bundle()
      currentWeatherFragment.arguments = bundle
      return currentWeatherFragment
    }
  }

  override fun finish() {

  }

  override fun onBackPressed() {
  }
}
