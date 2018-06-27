package home.learn.hmt.the_weather_kotlin.base.screen.fragment

import android.databinding.ViewDataBinding
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import home.learn.hmt.the_weather_kotlin.R
import home.learn.hmt.the_weather_kotlin.base.viewmodel.BaseDataLoadMoreRefreshViewModel
import home.learn.hmt.the_weather_kotlin.widges.OnListChangeListener

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
abstract class BaseDataMoreRefreshFragment<view : ViewDataBinding, viewModel : BaseDataLoadMoreRefreshViewModel<T>, T> : BaseDataLoadFragment<view, viewModel>() {
  lateinit var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
  lateinit var layoutManager: RecyclerView.LayoutManager

  override fun getLayoutId(): Int = R.layout.fragment_base_loadmore_refresh

  override fun initData() {
    super.initData()
    adapter = initAdapter()
    layoutManager = intLayoutManager()
    mViewModel.listItem.addOnListChangedCallback(OnListChangeListener<T>(adapter))
  }

  abstract fun initAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>

  open fun intLayoutManager(): RecyclerView.LayoutManager = LinearLayoutManager(activity)
}