package com.omersungur.omer_sungur_odev_10.data.repository.note

import com.omersungur.omer_sungur_odev_10.data.local.database.note.NoteDao
import com.omersungur.omer_sungur_odev_10.data.mapper.toNote
import com.omersungur.omer_sungur_odev_10.data.mapper.toNoteEntity
import com.omersungur.omer_sungur_odev_10.domain.model.Note
import com.omersungur.omer_sungur_odev_10.domain.repository.note.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note.toNoteEntity())
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes().map { noteEntityList ->
            noteEntityList.map { noteEntity ->
                noteEntity.toNote()
            }
        }
    }

    override fun getNoteById(noteId: Int): Flow<Note> {
        return noteDao.getNoteById(noteId).map { it.toNote() }
    }

    override suspend fun searchNotes(query: String): List<Note> {
        return noteDao.searchNotes(query).map { it.toNote() }
    }
}