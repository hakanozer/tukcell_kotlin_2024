package com.yeceylan.yunusemreceylan_odev10.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yeceylan.yunusemreceylan_odev10.model.entity.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes WHERE username = :username")
    suspend fun getNotesForUser(username: String): List<Note>

    @Query("SELECT * FROM notes WHERE username = :username AND (title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%')")
    suspend fun searchNotes(username: String, query: String): List<Note>
}