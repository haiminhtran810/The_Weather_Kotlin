package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by hcm-102-0006 on 29/06/2018.
 */
@Parcelize
data class Temp(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
) : Parcelable