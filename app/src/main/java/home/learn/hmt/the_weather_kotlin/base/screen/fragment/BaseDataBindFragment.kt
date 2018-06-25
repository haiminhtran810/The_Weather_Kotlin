package home.learn.hmt.the_weather_kotlin.base.screen.fragment

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.learn.hmt.the_weather_kotlin.base.navigator.BaseNavigator
import home.learn.hmt.the_weather_kotlin.base.viewmodel.BaseViewModel

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
abstract class BaseDataBindFragment<viewBinding : ViewDataBinding, viewModel : BaseViewModel> : BaseFragment() {
  lateinit var mBinding: viewBinding
  lateinit var mViewModel: viewModel
  lateinit var navigator: BaseNavigator

  abstract fun getLayoutId(): Int
  abstract fun initData()

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    if (context is BaseNavigator) {
      navigator = context
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
    return mBinding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    initData()
  }

  override fun onDestroy() {
    mViewModel.onActivityDestroyed()
    super.onDestroy()
  }
}
