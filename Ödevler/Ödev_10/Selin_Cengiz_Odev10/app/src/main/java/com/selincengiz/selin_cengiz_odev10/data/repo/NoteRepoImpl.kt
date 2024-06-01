package com.selincengiz.selin_cengiz_odev10.data.repo


import com.selincengiz.selin_cengiz_odev10.common.Resource
import com.selincengiz.selin_cengiz_odev10.data.mapper.mapToNoteRoom
import com.selincengiz.selin_cengiz_odev10.data.mapper.mapToNotesUI
import com.selincengiz.selin_cengiz_odev10.data.source.local.INotesDao
import com.selincengiz.selin_cengiz_odev10.domain.entities.NotesUI
import com.selincengiz.selin_cengiz_odev10.domain.repo.INoteRepo
import java.lang.Exception

class NoteRepoImpl(private val notesDao: INotesDao) : INoteRepo {
    override suspend fun getNotesByQuery(search: String): Resource<List<NotesUI>> {
        return try {
            Resource.Success(
                notesDao.getNotesByQuery(search).map { item -> item.mapToNotesUI() }
            )
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    override suspend fun getAllNote(): Resource<List<NotesUI>> {
        return try {
            Resource.Success(
                notesDao.gelAllNotes().map { item -> item.mapToNotesUI() }
            )
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    override suspend fun addNote(note: NotesUI) {
        notesDao.addNote(note.mapToNoteRoom())
    }

    override suspend fun deleteNote(note: NotesUI) {
        notesDao.deleteNote(note.mapToNoteRoom())
    }

}