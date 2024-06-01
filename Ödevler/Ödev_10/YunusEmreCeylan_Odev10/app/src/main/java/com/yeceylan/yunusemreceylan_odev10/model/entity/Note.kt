package com.yeceylan.yunusemreceylan_odev10.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val username: String,
    val timestamp: Long = System.currentTimeMillis()
)
