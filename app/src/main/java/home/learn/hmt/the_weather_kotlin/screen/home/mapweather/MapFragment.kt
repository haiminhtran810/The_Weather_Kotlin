package home.learn.hmt.the_weather_kotlin.screen.home.mapweather

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.learn.hmt.the_weather_kotlin.R


/**
 * A simple [Fragment] subclass.
 */
class MapFragment : Fragment() {

  companion object {
    fun newInstance(): MapFragment {
      return MapFragment()
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_map, container, false)
  }
}// Required empty public constructor
