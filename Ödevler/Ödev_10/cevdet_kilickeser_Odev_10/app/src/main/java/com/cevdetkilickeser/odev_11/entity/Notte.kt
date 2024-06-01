package com.cevdetkilickeser.odev_11.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes")
data class Notte(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val userId: Int,
    val title: String,
    val detail: String
) : Serializable