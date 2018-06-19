package home.learn.hmt.the_weather_kotlin.base.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by hcm-102-0006 on 19/06/2018.
 */
abstract class BaseViewModel : ViewModel() {

  private var compositeDisposable: CompositeDisposable? = null

  fun addDisposable(disposable: Disposable) {
    if (compositeDisposable == null) {
      compositeDisposable = CompositeDisposable()
    }
    compositeDisposable?.add(disposable)
  }

  fun onActivityDestroyed() {
    compositeDisposable?.dispose()
    compositeDisposable = null
  }
}