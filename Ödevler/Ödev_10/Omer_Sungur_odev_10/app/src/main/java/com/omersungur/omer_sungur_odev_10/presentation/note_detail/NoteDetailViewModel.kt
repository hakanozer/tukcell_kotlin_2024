package com.omersungur.omer_sungur_odev_10.presentation.note_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omersungur.omer_sungur_odev_10.domain.model.Note
import com.omersungur.omer_sungur_odev_10.domain.repository.note.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    fun updateNote(
        noteId: Int,
        noteTitle: String,
        noteContent: String,

        ) {
        viewModelScope.launch {
            val note = Note(noteId, noteTitle, noteContent)
            noteRepository.updateNote(note)
        }
    }

    fun getNoteById(noteId: Int): Flow<Note> {
        return noteRepository.getNoteById(noteId)
    }

    fun isEntryValid(
        noteTitle: String,
        noteContent: String,
    ): Boolean {
        return !(noteTitle.isBlank() || noteContent.isBlank())
    }
}