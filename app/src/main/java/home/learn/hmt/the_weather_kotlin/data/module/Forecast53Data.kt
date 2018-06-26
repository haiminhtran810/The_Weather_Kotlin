package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
@Parcelize
data class Forecast53Data(
    val cod: String,
    val message: Double,
    val list: List<Forecast>,
    val cite: City
) : Parcelable