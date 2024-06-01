package com.tlh.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (

    @ColumnInfo(name = "note_title") val noteTitle: String,
    @ColumnInfo(name = "note_main") val noteMain: String,

) {
    @PrimaryKey(autoGenerate = true)
    var nid: Int = 0
}
