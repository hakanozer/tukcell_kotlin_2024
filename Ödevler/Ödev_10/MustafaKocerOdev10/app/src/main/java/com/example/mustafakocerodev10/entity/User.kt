package com.example.mustafakocerodev10.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    val uid: Int?,
    val userName: String,
    val password: String
)
