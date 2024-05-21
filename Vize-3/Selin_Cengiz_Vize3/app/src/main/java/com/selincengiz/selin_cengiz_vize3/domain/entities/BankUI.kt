package com.selincengiz.selin_cengiz_vize3.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BankUI(
    val cardExpire: String?,
    val cardNumber: String?,
    val cardType: String?,
    val currency: String?,
    val iban: String?
): Parcelable
