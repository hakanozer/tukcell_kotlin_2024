package com.tlh.noteapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tlh.noteapp.model.Note

@Dao
interface NoteDao{

    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

    @Query("SELECT * FROM note WHERE nid = :nid")
    fun getById(nid: Int): Note



    @Insert
    fun insert(note: Note)

    @Insert
    fun delete(note: Note)

}