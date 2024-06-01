package com.toren.odev10.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val id: Int,
    val title: String,
    val note: String,
    val userId: Int
) : Parcelable
