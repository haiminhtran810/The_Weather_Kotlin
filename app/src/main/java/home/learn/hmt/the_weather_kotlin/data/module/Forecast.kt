package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
class Forecast(
    var dt: Long,
    var dt_txt: String,
    var sys: Sys,
    var main: Main,
    var weather: List<Weather>,
    var wind: Wind
) : Parcelable {
  constructor(parcel: Parcel) : this(
      parcel.readLong(),
      parcel.readString(),
      TODO("sys"),
      TODO("main"),
      TODO("weather"),
      TODO("wind")) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeLong(dt)
    parcel.writeString(dt_txt)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<Forecast> {
    override fun createFromParcel(parcel: Parcel): Forecast {
      return Forecast(parcel)
    }

    override fun newArray(size: Int): Array<Forecast?> {
      return arrayOfNulls(size)
    }
  }
}