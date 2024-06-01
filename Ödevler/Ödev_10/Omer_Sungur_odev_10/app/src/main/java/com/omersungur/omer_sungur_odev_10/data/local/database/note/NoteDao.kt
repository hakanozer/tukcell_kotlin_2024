package com.omersungur.omer_sungur_odev_10.data.local.database.note

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.omersungur.omer_sungur_odev_10.data.local.database.note.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM note_table")
    fun getNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM note_table WHERE note_id = :noteId ")
    fun getNoteById(noteId: Int): Flow<NoteEntity>

    @Query("SELECT * FROM note_table WHERE note_title like '%' || :query||'%'")
    suspend fun searchNotes(query: String): List<NoteEntity>
}