package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
class Forecast53Data(
    var cod: String,
    var message: Double,
    var list: List<Forecast>,
    var cite: City
) : Parcelable {
  constructor(parcel: Parcel) : this(
      parcel.readString(),
      parcel.readDouble(),
      parcel.createTypedArrayList(Forecast),
      parcel.readParcelable(City::class.java.classLoader)) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(cod)
    parcel.writeDouble(message)
    parcel.writeTypedList(list)
    parcel.writeParcelable(cite, flags)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<Forecast53Data> {
    override fun createFromParcel(parcel: Parcel): Forecast53Data {
      return Forecast53Data(parcel)
    }

    override fun newArray(size: Int): Array<Forecast53Data?> {
      return arrayOfNulls(size)
    }
  }
}