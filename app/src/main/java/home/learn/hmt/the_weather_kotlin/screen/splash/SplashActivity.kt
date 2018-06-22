package home.learn.hmt.the_weather_kotlin.screen.splash

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Handler
import home.learn.hmt.the_weather_kotlin.R
import home.learn.hmt.the_weather_kotlin.base.screen.activity.BaseDataLoadActivity
import home.learn.hmt.the_weather_kotlin.data.Constant
import home.learn.hmt.the_weather_kotlin.databinding.ActivitySplashBinding
import home.learn.hmt.the_weather_kotlin.screen.home.HomeActivity
import home.learn.hmt.the_weather_kotlin.utils.ActivityUtils

class SplashActivity : BaseDataLoadActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator {
  override fun showError(errorMessage: String) {

  }

  private var mDelayHandler: Handler? = null

  override fun initData() {
    super.initData()
    mDelayHandler = Handler()
    mDelayHandler!!.postDelayed(mRunnable, Constant.SPLASH_DELAY)
  }

  internal val mRunnable: Runnable = Runnable {
    if (!isFinishing) {
      ActivityUtils.goToActivity(applicationContext, HomeActivity::class.java, null, 0)
      finish()
    }
  }

  override fun getLayoutId(): Int {
    return R.layout.activity_splash
  }

  override fun onDestroy() {
    if (mDelayHandler != null) {
      mDelayHandler!!.removeCallbacks(mRunnable)
    }
    super.onDestroy()
  }

  override fun getContext(): Context {
    return applicationContext
  }

  override fun initViewModel(): SplashViewModel {
    return ViewModelProviders.of(this).get(SplashViewModel::class.java).apply {
      navigator = this@SplashActivity
    }
  }
}

