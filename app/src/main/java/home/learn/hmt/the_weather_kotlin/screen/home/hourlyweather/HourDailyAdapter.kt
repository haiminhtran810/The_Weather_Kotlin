package home.learn.hmt.the_weather_kotlin.screen.home.hourlyweather

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import home.learn.hmt.the_weather_kotlin.R
import home.learn.hmt.the_weather_kotlin.base.screen.adapter.BaseRecycleViewAdaperBinding
import home.learn.hmt.the_weather_kotlin.base.screen.adapter.BaseViewHolderBinding
import home.learn.hmt.the_weather_kotlin.data.module.WeatherData
import home.learn.hmt.the_weather_kotlin.databinding.ItemWeatherBinding

/**
 * Created by hcm-102-0006 on 28/06/2018.
 */
class HourDailyAdapter(context: Context, list: List<WeatherData>,
    val listener: BaseViewHolderBinding.OnItemClickListener<WeatherData>) : BaseRecycleViewAdaperBinding<HourDailyAdapter.HourHolder, ItemWeatherBinding, WeatherData>(
    context, list) {

  override fun getViewHolder(parent: ViewGroup, viewType: Int): HourHolder {
    return HourHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_weather, parent,
            false))
  }

  class HourHolder(
      binding: ItemWeatherBinding) : BaseViewHolderBinding<ItemWeatherBinding, WeatherData>(
      binding) {
    override fun bindData(item: WeatherData) {

    }
  }

}