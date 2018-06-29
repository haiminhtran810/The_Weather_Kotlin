package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
@Parcelize
data class Forecast(
    val dt: Long,
    val dt_txt: String,
    val sys: Sys,
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind,
    val temp: Temp
) : Parcelable