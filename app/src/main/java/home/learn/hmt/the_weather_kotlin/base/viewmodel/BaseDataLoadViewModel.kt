package home.learn.hmt.the_weather_kotlin.base.viewmodel

import android.arch.lifecycle.MutableLiveData

/**
 * Created by hcm-102-0006 on 20/06/2018.
 */
abstract class BaseDataLoadViewModel : BaseViewModel() {
  val isDataLoading = MutableLiveData<Boolean>().apply { value = false }
}