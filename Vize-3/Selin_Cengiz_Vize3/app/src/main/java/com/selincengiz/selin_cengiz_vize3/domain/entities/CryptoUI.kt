package com.selincengiz.selin_cengiz_vize3.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CryptoUI(
    val coin: String?,
    val network: String?,
    val wallet: String?
): Parcelable
