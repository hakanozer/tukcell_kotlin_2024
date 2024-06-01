package com.aliberkaygedikoglu.odev10.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    val id:Int?,
    val username: String,
    val password: String,

):Serializable