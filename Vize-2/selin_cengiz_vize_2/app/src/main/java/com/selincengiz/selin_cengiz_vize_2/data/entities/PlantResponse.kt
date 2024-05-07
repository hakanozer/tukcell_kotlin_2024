package com.selincengiz.selin_cengiz_vize_2.data.entities

import android.os.Parcel
import android.os.Parcelable


data class PlantResponse(
    val availability: String,
    val botanical: String,
    val common: String,
    val light: String,
    val price: String,
    val zone: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(availability)
        parcel.writeString(botanical)
        parcel.writeString(common)
        parcel.writeString(light)
        parcel.writeString(price)
        parcel.writeString(zone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlantResponse> {
        override fun createFromParcel(parcel: Parcel): PlantResponse {
            return PlantResponse(parcel)
        }

        override fun newArray(size: Int): Array<PlantResponse?> {
            return arrayOfNulls(size)
        }
    }
}