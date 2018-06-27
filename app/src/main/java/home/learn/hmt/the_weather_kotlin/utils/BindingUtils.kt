package home.learn.hmt.the_weather_kotlin.utils

import android.app.Activity
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import home.learn.hmt.the_weather_kotlin.widges.PullRefreshRecycleView

/**
 * Created by hcm-102-0006 on 28/06/2018.
 */

@BindingAdapter("recycleAdapter")
fun setRecycleAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
  view.setHasFixedSize(true)
  view.adapter = adapter
}

@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
  view.layoutManager = layoutManager
}

@BindingAdapter("refreshing")
fun setPTRRefreshing(view: PullRefreshRecycleView, isRefreshing: Boolean) {
  view.isRefreshing.value = isRefreshing
}

@BindingAdapter("onScrollListener")
fun setPTRScrollListener(view: PullRefreshRecycleView,
    listener: RecyclerView.OnScrollListener) {
  view.onScrollListener.value = listener
}

@BindingAdapter("refreshListener")
fun setPTRRefreshListener(view: PullRefreshRecycleView,
    listener: SwipeRefreshLayout.OnRefreshListener) {
  view.onRefreshListener.value = listener
}

@BindingAdapter("loadImageView")
fun loadImageView(img: ImageView, url: String? = "") {
  Glide.with(img.context)
      .load(url).into(img)

}

/*@BindingAdapter(
    value = ["loadCircleImage", "placeHolder", "cacheSource", "defaultImage", "errorImage"],
    requireAll = false)
fun loadImage(img: ImageView, url: String? = "", placeHolder: Drawable,
    isCacheSource: Boolean = false,
    imageError: Drawable, imageDefault: Drawable) {
  if (TextUtils.isEmpty(url) && imageDefault != null) {
    img.apply {
      setImageDrawable(imageDefault)
    }
    return
  }
  Glide.with(img.context).asGif()
      .load(url).apply(RequestOptions.circleCropTransform()).into(img)
}*/





