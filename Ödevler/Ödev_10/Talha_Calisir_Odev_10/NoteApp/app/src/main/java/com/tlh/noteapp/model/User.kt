package com.tlh.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "user_password") val userPassword: String,
)
{
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
