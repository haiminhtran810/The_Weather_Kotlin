package home.learn.hmt.the_weather_kotlin.data.module

// Add parcelable into object :
// ( Dang Anh Quan ) https://viblo.asia/p/parcelable-trong-kotlin-da-co-at-parcelize-Qbq5QW8EZD8
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 * Created by hcm-102-0006 on 21/06/2018.
 */
@Parcelize

data class City(
    val id: Long,
    val name: String,
    //val coord: Coord,
    val country: String,
    val population: Long
) : Parcelable