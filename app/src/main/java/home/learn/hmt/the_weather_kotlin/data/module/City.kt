package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by hcm-102-0006 on 21/06/2018.
 */
class City(
    var id: Long,
    var name: String,
    var coord: Coord,
    var country: String,
    var population: Long
) : Parcelable {
  constructor(parcel: Parcel) : this(
      parcel.readLong(),
      parcel.readString(),
      TODO("coord"),
      parcel.readString(),
      parcel.readLong()) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeLong(id)
    parcel.writeString(name)
    parcel.writeString(country)
    parcel.writeLong(population)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<City> {
    override fun createFromParcel(parcel: Parcel): City {
      return City(parcel)
    }

    override fun newArray(size: Int): Array<City?> {
      return arrayOfNulls(size)
    }
  }
}