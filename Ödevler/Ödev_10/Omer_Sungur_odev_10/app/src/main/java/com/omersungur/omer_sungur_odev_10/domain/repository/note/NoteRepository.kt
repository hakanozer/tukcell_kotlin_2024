package com.omersungur.omer_sungur_odev_10.domain.repository.note

import com.omersungur.omer_sungur_odev_10.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
    fun getNotes(): Flow<List<Note>>
    fun getNoteById(noteId: Int): Flow<Note>
    suspend fun searchNotes(query: String): List<Note>
}