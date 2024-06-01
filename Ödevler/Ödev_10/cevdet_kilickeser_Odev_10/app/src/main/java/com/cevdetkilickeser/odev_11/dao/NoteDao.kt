package com.cevdetkilickeser.odev_11.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cevdetkilickeser.odev_11.entity.Notte

@Dao
interface NoteDao {

    @Query("SELECT * from notes WHERE userId = :userId")
    fun getAllNotes(userId: Int): List<Notte>

    @Insert
    fun insertNote(note: Notte): Long

    @Delete
    fun deleteNote(note: Notte): Int

    @Update
    fun updateNote(note: Notte)

    @Query("SELECT * FROM notes WHERE title LIKE '%' || :searchQuery || '%' OR detail LIKE '%' || :searchQuery || '%'")
    fun searchNote(searchQuery: String): List<Notte>
}