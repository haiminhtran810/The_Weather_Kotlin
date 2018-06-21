package home.learn.hmt.the_weather_kotlin.screen.home

import android.arch.lifecycle.ViewModelProviders
import home.learn.hmt.the_weather_kotlin.R
import home.learn.hmt.the_weather_kotlin.base.screen.activity.BaseDataLoadActivity
import home.learn.hmt.the_weather_kotlin.databinding.ActivityHomeBinding

class HomeActivity : BaseDataLoadActivity<ActivityHomeBinding, HomeViewModel>(), HomeNavigator {

  override fun initData() {
    super.initData()

  }

  override fun getLayoutId(): Int {
    return R.layout.activity_home
  }

  override fun initViewModel(): HomeViewModel {
    return ViewModelProviders.of(this).get(HomeViewModel::class.java).apply {
      navigator = this@HomeActivity
    }
  }
}
