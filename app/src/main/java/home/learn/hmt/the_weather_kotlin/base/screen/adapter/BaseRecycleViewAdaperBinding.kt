package home.learn.hmt.the_weather_kotlin.base.screen.adapter

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by hcm-102-0006 on 28/06/2018.
 */
abstract class BaseRecycleViewAdaperBinding<viewHolder : BaseViewHolderBinding<V, I>, V : ViewDataBinding, I>(
    val context: Context, val list: List<I>) : RecyclerView.Adapter<BaseViewHolderBinding<V, I>>() {

  abstract fun getViewHolder(parent: ViewGroup, viewType: Int): viewHolder

  override fun onCreateViewHolder(parent: ViewGroup,
      viewType: Int): BaseViewHolderBinding<V, I> = getViewHolder(parent, viewType)

  override fun onBindViewHolder(holder: BaseViewHolderBinding<V, I>, position: Int) {
    holder.bindData(list.get(position))
  }

  override fun getItemCount(): Int {
    return list.size
  }

}