package com.omersungur.omer_sungur_odev_10.presentation.add_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omersungur.omer_sungur_odev_10.domain.model.Note
import com.omersungur.omer_sungur_odev_10.domain.repository.note.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    fun insertNote(
        noteTitle: String,
        noteContent: String,
    ) {
        val note = Note(0, noteTitle, noteContent)
        viewModelScope.launch {
            repository.insertNote(note)
        }
    }

    fun isEntryValid(
        noteTitle: String,
        noteContent: String,
    ): Boolean {
        return !(noteTitle.isBlank() || noteContent.isBlank())
    }
}