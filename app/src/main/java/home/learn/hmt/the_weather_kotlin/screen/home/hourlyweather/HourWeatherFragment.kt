package home.learn.hmt.the_weather_kotlin.screen.home.hourlyweather

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.learn.hmt.the_weather_kotlin.R


/**
 * A simple [Fragment] subclass.
 */
class HourWeatherFragment : Fragment() {

  companion object {
    fun newInstance(): HourWeatherFragment {
      return HourWeatherFragment()
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_hour_weather, container, false)
  }
}// Required empty public constructor
