package com.selincengiz.selin_cengiz_odev10.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NotesUI(
    val id:Int=0,
    val title: String?,
    val body: String?,
) : Parcelable