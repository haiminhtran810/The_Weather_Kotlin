package home.learn.hmt.the_weather_kotlin.base.screen.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by hcm-102-0006 on 28/06/2018.
 */
abstract class BaseViewHolderBinding<view : ViewDataBinding, T>(
    val binding: view) : RecyclerView.ViewHolder(binding.root) {
  abstract fun bindData(item: T)

  interface OnItemClickListener<T> {
    fun onItemClick(position: Int, data: T)
  }
}