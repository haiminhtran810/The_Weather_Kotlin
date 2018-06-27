package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
@Parcelize
data class WeatherData(
    val id: Long,
    val name: String = "",
    val cod: Int,
    val base: String = "",
    val visibility: Int,
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind,
    val cloud: Cloud
) : Parcelable