package com.example.mustafakocerodev10.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mustafakocerodev10.entity.Notes

@Dao
interface NotesDao {

    @Insert
    fun insertNote(notes: Notes): Long // sqlite bize id'sini döndürür

    @Delete
    fun deleteNote(notes: Notes): Int

    @Update
    fun updateNote(notes: Notes): Int

    @Query("SELECT * FROM notes where foreignUID = :uid")
    fun getAllPersonelNotes(uid: Int): List<Notes>

}