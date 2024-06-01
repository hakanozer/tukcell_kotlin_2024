package com.beyzaparlak.notesapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// @Entity arka tarafta "user" adında bir tablo oluşması gerektiğini belirtir
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name ="uid") val id: Int?,
    val username: String,
    val password: String,
    var isRegister: Boolean = true
)
