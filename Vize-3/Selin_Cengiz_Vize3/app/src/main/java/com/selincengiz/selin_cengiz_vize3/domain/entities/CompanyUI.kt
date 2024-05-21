package com.selincengiz.selin_cengiz_vize3.domain.entities


import android.os.Parcelable
import com.selincengiz.selin_cengiz_vize3.data.entities.Address
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompanyUI(
    val address: AddressUI?,
    val department: String?,
    val name: String?,
    val title: String?
): Parcelable
