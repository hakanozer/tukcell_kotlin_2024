package com.selincengiz.selin_cengiz_odev10.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.selincengiz.selin_cengiz_odev10.data.entities.NotesRoom

@Dao
interface INotesDao {

    @Query("SELECT * FROM notes  WHERE  title LIKE '%' || :search || '%'  or body LIKE '%' || :search || '%'")
    suspend fun getNotesByQuery(search: String): List<NotesRoom>

    @Query("SELECT * FROM notes")
    suspend fun gelAllNotes():List<NotesRoom>

    @Upsert
    suspend fun addNote(note: NotesRoom)

    @Delete
    suspend fun deleteNote(note: NotesRoom)

}