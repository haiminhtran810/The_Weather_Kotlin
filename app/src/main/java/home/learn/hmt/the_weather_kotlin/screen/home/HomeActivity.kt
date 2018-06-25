package home.learn.hmt.the_weather_kotlin.screen.home

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import home.learn.hmt.the_weather_kotlin.R
import home.learn.hmt.the_weather_kotlin.base.screen.activity.BaseDataLoadActivity
import home.learn.hmt.the_weather_kotlin.databinding.ActivityHomeBinding
import home.learn.hmt.the_weather_kotlin.screen.home.currentweather.CurrentWeatherFragment
import home.learn.hmt.the_weather_kotlin.screen.home.hourlyweather.HourWeatherFragment
import home.learn.hmt.the_weather_kotlin.screen.home.mapweather.MapFragment

// reference : http://androidcodehub.com/android-workingwith-bottom-navigation/

class HomeActivity : BaseDataLoadActivity<ActivityHomeBinding, HomeViewModel>(), HomeNavigator {
  override fun showError(errorMessage: String) {

  }

  private lateinit var ahNavigation: AHBottomNavigation
  private lateinit var ahBottomNavigationAdapter: AHBottomNavigationAdapter

  override fun initData() {
    super.initData()
    setUpBottomNavigation()
  }


  override fun getLayoutId(): Int {
    return R.layout.activity_home
  }

  override fun initViewModel(): HomeViewModel {
    return ViewModelProviders.of(this).get(HomeViewModel::class.java).apply {
      navigator = this@HomeActivity
    }
  }

  fun setUpBottomNavigation() {
    ahNavigation = mBinding.ahTabContain
    ahBottomNavigationAdapter = AHBottomNavigationAdapter(this, R.menu.menu_tab_bar)
    ahBottomNavigationAdapter.apply {
      // we can use fields in ahBottomNavigation with the short code
      // DangAnhQuan : https://viblo.asia/p/kotlin-scope-function-let-apply-run-also-with-bWrZnNqwZxw
      setupWithBottomNavigation(ahNavigation)
    }
    ahNavigation.apply {
      titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
      setOnTabSelectedListener({ position, isSelected ->
        onNavigationBotItemClick(position)
      })
    }
  }

  private fun onNavigationBotItemClick(position: Int): Boolean {
    var oldF = supportFragmentManager.findFragmentById(android.R.id.content)
    var fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    if (oldF != null) {
      fragmentTransaction.detach(oldF)
    }
    var fragment: Fragment = when (position) {
      Tab_Position.TAB_CURRENT.res -> CurrentWeatherFragment.newInstance()
      Tab_Position.TAB_HOUR.res -> HourWeatherFragment.newInstance()
      Tab_Position.TAB_MAP.res -> MapFragment.newInstance()
      else -> Fragment()
    }

    fragmentTransaction.replace(R.id.layout_contain, fragment, "SOMETAG")
    fragmentTransaction.commit()
    return true
  }

  enum class Tab_Position(val res: Int) {
    TAB_CURRENT(0),
    TAB_HOUR(1),
    TAB_MAP(2)
  }
}
