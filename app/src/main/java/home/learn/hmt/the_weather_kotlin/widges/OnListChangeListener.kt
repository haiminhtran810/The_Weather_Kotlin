package home.learn.hmt.the_weather_kotlin.widges

import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView

/**
 * Created by hcm-102-0006 on 28/06/2018.
 */
class OnListChangeListener<T>(
    val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) : ObservableList.OnListChangedCallback<ObservableList<T>>() {
  override fun onChanged(sender: ObservableList<T>?) {
    adapter.notifyDataSetChanged()
  }

  override fun onItemRangeRemoved(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
    adapter.notifyItemRangeRemoved(positionStart, itemCount)
  }

  override fun onItemRangeMoved(sender: ObservableList<T>?, fromPosition: Int, toPosition: Int,
      itemCount: Int) {
    adapter.notifyDataSetChanged()
  }

  override fun onItemRangeInserted(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
    adapter.notifyItemRangeInserted(positionStart, itemCount)
  }

  override fun onItemRangeChanged(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
    adapter.notifyItemRangeChanged(positionStart, itemCount)
  }

}
