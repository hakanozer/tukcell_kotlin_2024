package com.example.odev10.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.odev10.entitie.Note

@Dao
interface NotesDao {

    @Insert
    suspend fun insert(note: Note)

    @Delete
    fun delete(note: Note) : Int

    @Update
    fun update(note: Note) : Int

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<Note>

    @Query("SELECT * FROM notes WHERE nid =:nid")
    fun findById(nid:Int): Note?

    @Query("SELECT * FROM notes WHERE title like :title")
    fun searchTitle(title: String): List<Note>
}