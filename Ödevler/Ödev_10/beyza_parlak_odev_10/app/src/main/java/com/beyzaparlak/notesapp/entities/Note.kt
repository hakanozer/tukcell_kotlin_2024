package com.beyzaparlak.notesapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// @Entity arka tarafta "note" adında bir tablo oluşması gerektiğini belirtir
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="nid")
    val nid: Int?,
    val title: String,
    val detail: String,
    val date: String
)
