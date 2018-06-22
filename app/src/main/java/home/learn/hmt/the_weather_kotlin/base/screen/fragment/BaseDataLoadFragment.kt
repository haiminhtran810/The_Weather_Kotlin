package home.learn.hmt.the_weather_kotlin.base.screen.fragment

import android.databinding.ViewDataBinding
import home.learn.hmt.the_weather_kotlin.base.viewmodel.BaseViewModel

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
abstract class BaseDataLoadFragment<T : ViewDataBinding, K : BaseViewModel> : BaseDataBindFragment<T, K>() {
  abstract fun initViewModel(): K
  override fun initData() {
    mViewModel = initViewModel()
  }
}