package home.learn.hmt.the_weather_kotlin.data.module

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by hcm-102-0006 on 21/06/2018.
 */
class Cloud(
    var all: Int
) : Parcelable {
  constructor(parcel: Parcel) : this(parcel.readInt()) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeInt(all)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<Cloud> {
    override fun createFromParcel(parcel: Parcel): Cloud {
      return Cloud(parcel)
    }

    override fun newArray(size: Int): Array<Cloud?> {
      return arrayOfNulls(size)
    }
  }
}