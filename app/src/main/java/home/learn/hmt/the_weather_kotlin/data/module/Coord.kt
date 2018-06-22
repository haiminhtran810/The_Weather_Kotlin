package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by hcm-102-0006 on 21/06/2018.
 */
class Coord(
    var lat : Double,
    var lon : Double
) : Parcelable {
  constructor(parcel: Parcel) : this(
      parcel.readDouble(),
      parcel.readDouble()) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeDouble(lat)
    parcel.writeDouble(lon)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<Coord> {
    override fun createFromParcel(parcel: Parcel): Coord {
      return Coord(parcel)
    }

    override fun newArray(size: Int): Array<Coord?> {
      return arrayOfNulls(size)
    }
  }
}