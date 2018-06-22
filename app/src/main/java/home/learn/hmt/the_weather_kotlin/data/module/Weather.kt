package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by hcm-102-0006 on 21/06/2018.
 */
@Parcelize
data class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
) : Parcelable