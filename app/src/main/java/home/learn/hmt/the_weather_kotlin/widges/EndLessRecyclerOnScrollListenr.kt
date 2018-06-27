package home.learn.hmt.the_weather_kotlin.widges

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import home.learn.hmt.the_weather_kotlin.data.Constant

/**
 * Created by hcm-102-0006 on 28/06/2018.
 */
abstract class EndLessRecyclerOnScrollListenr(threshold: Int) : RecyclerView.OnScrollListener() {
  private var mPreviousTotal: Int = 0
  private var mIsLoading: Boolean = true
  private var mFirstVisibleItem: Int = 0
  private var mTotalItemCount: Int = 0
  private var mVisibleItemCount: Int = 0
  private var mNumberThreshold: Int = -1

  // mNumberThreshold is the remaining items that do not load to exe loadmore in RecycleView

  init {
    mNumberThreshold = if (threshold >= 1) {
      threshold
    } else {
      Constant.DEFAULT_NUM_VISIBLE_THRESHOLD
    }
  }

  override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
    super.onScrolled(recyclerView, dx, dy)
    // note :
    // LinearLayoutManager : 1 or 2
    // GridLayoutManager : 3

    mFirstVisibleItem = recyclerView?.childCount!!
    mTotalItemCount = recyclerView.layoutManager.itemCount
    if (recyclerView.layoutManager is LinearLayoutManager) {
      mFirstVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
    } else if (recyclerView.layoutManager is GridLayoutManager) {
      mFirstVisibleItem = (recyclerView.layoutManager as GridLayoutManager).findFirstVisibleItemPosition()
    } else {
      throw RuntimeException("This is Error")
    }

    if (mIsLoading) {
      stateLoading()
    }

    if (!mIsLoading && mTotalItemCount - mVisibleItemCount <= mFirstVisibleItem + mNumberThreshold) {
      onLoadMore()
      mIsLoading
    }
  }

  fun resetOnLoadMore() {
    mFirstVisibleItem = 0
    mVisibleItemCount = 0
    mTotalItemCount = 0
    mPreviousTotal = 0
    mIsLoading = true
  }

  abstract fun onLoadMore()
  private fun stateLoading() {
    if (mTotalItemCount > mPreviousTotal) {
      mIsLoading = false
      mPreviousTotal = mTotalItemCount
    }
  }
}