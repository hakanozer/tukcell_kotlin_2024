package com.selincengiz.selin_cengiz_vize3.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordinatesUI(
    val lat: Double?,
    val lng: Double?
): Parcelable
