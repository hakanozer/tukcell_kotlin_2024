package com.selincengiz.selin_cengiz_odev10.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserRoom(
    @PrimaryKey
    @ColumnInfo("email")
    val email: String,
    @ColumnInfo("password")
    val password: String?,
)
