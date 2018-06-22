package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by hcm-102-0006 on 21/06/2018.
 */
@Parcelize
data class Cloud(
    val all: Int
):Parcelable