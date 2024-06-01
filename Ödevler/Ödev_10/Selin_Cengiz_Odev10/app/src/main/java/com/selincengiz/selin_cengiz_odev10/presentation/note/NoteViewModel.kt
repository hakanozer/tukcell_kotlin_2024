package com.selincengiz.selin_cengiz_odev10.presentation.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selincengiz.selin_cengiz_odev10.domain.entities.NotesUI
import com.selincengiz.selin_cengiz_odev10.domain.repo.INoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val notesRepo: INoteRepo) : ViewModel() {

    fun upsert(note: NotesUI) {
        viewModelScope.launch {
            notesRepo.addNote(note)
        }
    }

    fun delete(note: NotesUI) {
        viewModelScope.launch {
            notesRepo.deleteNote(note)
        }
    }
}