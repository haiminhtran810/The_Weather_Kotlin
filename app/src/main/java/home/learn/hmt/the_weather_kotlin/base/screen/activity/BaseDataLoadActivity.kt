package home.learn.hmt.the_weather_kotlin.base.screen.activity

import android.databinding.ViewDataBinding
import home.learn.hmt.the_weather_kotlin.base.viewmodel.BaseDataLoadViewModel

/**
 * Created by hcm-102-0006 on 20/06/2018.
 */
abstract class BaseDataLoadActivity<T : ViewDataBinding, K : BaseDataLoadViewModel> : BaseDataBindActivity<T, K>() {
  abstract fun initViewModel(): K
  override fun initData() {
    mViewModel = initViewModel()
    mViewModel.isDataLoading.value = true
  }

  override fun onDestroy() {
    super.onDestroy()
    mViewModel.isDataLoading.removeObservers(this)
  }
}