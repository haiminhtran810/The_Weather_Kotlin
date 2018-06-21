package home.learn.hmt.the_weather_kotlin.base.screen.activity

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import home.learn.hmt.the_weather_kotlin.base.viewmodel.BaseViewModel

/**
 * Created by hcm-102-0006 on 19/06/2018.
 */
abstract class BaseDataBindActivity<T : ViewDataBinding, K : BaseViewModel> : BaseActivity() {

  lateinit var mBinding: T
  lateinit var mViewModel: K

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mBinding = DataBindingUtil.setContentView(this, getLayoutId())
    initData()
  }

  override fun onDestroy() {
    mViewModel.onActivityDestroyed()
    super.onDestroy()
  }

  abstract fun getLayoutId(): Int

  abstract fun initData()
}