package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by hcm-102-0006 on 21/06/2018.
 */
@Parcelize
class Main(
    var temp: Double,
    var temp_min: Double,
    var temp_max: Double,
    var pressure: Double,
    var humidity: Int
) : Parcelable