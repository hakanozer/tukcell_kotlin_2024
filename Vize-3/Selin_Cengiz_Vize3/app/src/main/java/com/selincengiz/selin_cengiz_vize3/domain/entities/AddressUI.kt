package com.selincengiz.selin_cengiz_vize3.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddressUI(
    val address: String?,
    val city: String?,
    val coordinates: CoordinatesUI?,
    val postalCode: String?,
    val state: String?
): Parcelable
