package com.omersungur.omer_sungur_odev_10.data.local.database.note.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.omersungur.omer_sungur_odev_10.core.Constants.NOTE_TABLE_NAME

@Entity(tableName = NOTE_TABLE_NAME)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id") val id: Int,
    @ColumnInfo(name = "note_title") val title: String,
    @ColumnInfo(name = "note_description") val description: String,
)