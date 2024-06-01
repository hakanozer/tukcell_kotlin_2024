package com.selincengiz.selin_cengiz_odev10.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NotesRoom(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int = 0,
    @ColumnInfo("title")
    val title: String?,
    @ColumnInfo("body")
    val body: String?,
)
