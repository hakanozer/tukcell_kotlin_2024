package com.toren.odev10.data.local.repo

import com.toren.odev10.data.local.dao.NoteDao
import com.toren.odev10.domain.model.Note
import com.toren.odev10.domain.repo.NotesRepository


class NotesRepositoryImpl(
    private val notesDAO: NoteDao
) : NotesRepository {

    override suspend fun addNote(note: Note) : Long{
        return notesDAO.addNote(note.title, note.note, note.userId)
    }

    override suspend fun getAllNotes(userId: Int): List<Note> {
        return notesDAO.getNotes(userId)
    }

    override suspend fun updateNote(note: Note): Int {
        return notesDAO.updateNote(note.title, note.note, note.id)
    }

    override suspend fun deleteNote(id: Int): Int {
        return notesDAO.deleteNote(id)
    }

}