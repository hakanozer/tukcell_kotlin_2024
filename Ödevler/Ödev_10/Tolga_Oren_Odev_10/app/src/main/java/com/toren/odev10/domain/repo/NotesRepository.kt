package com.toren.odev10.domain.repo

import com.toren.odev10.domain.model.Note

interface NotesRepository {

    suspend fun addNote(note: Note) : Long

    suspend fun getAllNotes(userId: Int): List<Note>

    suspend fun updateNote(note: Note) : Int

    suspend fun deleteNote(id: Int) : Int

}