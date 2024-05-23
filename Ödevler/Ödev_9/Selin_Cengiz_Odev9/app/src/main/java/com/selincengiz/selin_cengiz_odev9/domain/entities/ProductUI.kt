package com.selincengiz.selin_cengiz_odev9.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductUI(
    val id: Int?,
    val brand: String?,
    val category: String?,
    val description: String?,
    val discountPercentage: Double?,
    val images: List<String>?,
    val price: Int?,
    val rating: Double?,
    val stock: Int?,
    val thumbnail: String?,
    val title: String?
) : Parcelable