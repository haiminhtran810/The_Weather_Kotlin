package home.learn.hmt.the_weather_kotlin.widges

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import home.learn.hmt.the_weather_kotlin.R
import home.learn.hmt.the_weather_kotlin.databinding.LayoutPrRecyclerViewBinding

/**
 * Created by hcm-102-0006 on 28/06/2018.
 */
class PullRefreshRecycleView(context: Context, attributeSet: AttributeSet) : FrameLayout(context,
    attributeSet) {
  val layoutManager = MutableLiveData<RecyclerView.LayoutManager>()
  val adapter = MutableLiveData<RecyclerView.Adapter<RecyclerView.ViewHolder>>()
  val onScrollListener = MutableLiveData<RecyclerView.OnScrollListener>()
  val onRefreshListener = MutableLiveData<SwipeRefreshLayout.OnRefreshListener>()
  val isRefreshing = MutableLiveData<Boolean>()
  val binding: LayoutPrRecyclerViewBinding

  init {
    binding = DataBindingUtil.inflate(LayoutInflater.from(context),
        R.layout.layout_pr_recycler_view, this, true)
    binding.view = this
    //An observer added via observeForever(Observer) is considered as always active and thus will be always notified about modifications
    // Link : https://developer.android.com/reference/android/arch/lifecycle/LiveData
    isRefreshing.observeForever { t -> binding.ptrSwipeLayout.isRefreshing = t == false }
    layoutManager.apply {

      // I save value default = LinearLayoutManager
      value = LinearLayoutManager(context)
    }
  }

  fun setRefreshing(isRefreshing: Boolean) {
    this.isRefreshing.value = isRefreshing
  }

  fun scrollToPostion(position: Int) {
    binding.ptrRecycleView.scrollToPosition(position)
  }

  fun smoothScrollToPosition(position: Int) {
    binding.ptrRecycleView.smoothScrollToPosition(position)
  }

  fun turnOnRefresh() {
    binding.ptrSwipeLayout.isEnabled = true
  }

  fun turnOffRefresh() {
    binding.ptrSwipeLayout.isEnabled = false
  }
}