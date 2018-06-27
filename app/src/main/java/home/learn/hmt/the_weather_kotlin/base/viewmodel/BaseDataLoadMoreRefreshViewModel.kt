package home.learn.hmt.the_weather_kotlin.base.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.support.v4.widget.SwipeRefreshLayout
import home.learn.hmt.the_weather_kotlin.data.Constant
import home.learn.hmt.the_weather_kotlin.widges.EndLessRecyclerOnScrollListenr

/**
 * Created by hcm-102-0006 on 28/06/2018.
 */
abstract class BaseDataLoadMoreRefreshViewModel<T> : BaseDataLoadViewModel() {
  val isRefreshing = MutableLiveData<Boolean>().apply { value = true }
  val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
    if (isDataLoading.value == true || isRefreshing.value == true) {
      return@OnRefreshListener
    }
    isRefreshing.value = true
  }

  val isDataLoadMore = MutableLiveData<Boolean>().apply {
    value = false
  }

  var currentPage: Int = 0
  var isLastPage: Boolean = false
  val onScrollListener = object : EndLessRecyclerOnScrollListenr(getLoadMoreThreshold()) {
    override fun onLoadMore() {
      if (isDataLoading.value == true || isRefreshing.value == true || isDataLoadMore.value == true || isLastPage) {
        return
      }
      isDataLoadMore.value = true
      loadMore()
    }
  }

  val listItem = ObservableArrayList<T>()

  abstract fun loadData(page: Int)

  fun refreshData() {
    loadData(1)
  }

  fun loadMore() {
    loadData(currentPage + 1)
  }

  fun onLoadSuccess() {
    isDataLoadMore.value = false
    isRefreshing.value = false
    isDataLoadMore.value = false
  }

  override fun onLoadFail(e: Throwable) {
    super.onLoadFail(e)
    isDataLoadMore.value = false
    isRefreshing.value = false
  }

  fun getLoadMoreThreshold() = Constant.DEFAULT_NUM_VISIBLE_THRESHOLD

  fun getNumberItemPerPage() = Constant.DEFAULT_ITEM_PER_PAGE
}