package home.learn.hmt.the_weather_kotlin.base.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.util.Log

/**
 * Created by hcm-102-0006 on 20/06/2018.
 */
abstract class BaseDataLoadViewModel : BaseViewModel() {
  val isDataLoading = MutableLiveData<Boolean>().apply { value = false }

  init {

  }

  open fun onLoadFail(e: Throwable) {
    isDataLoading.value = false
    Log.d("Error", e.message)
  }
}