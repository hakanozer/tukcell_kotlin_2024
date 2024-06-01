package com.toren.odev10.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toren.odev10.common.UserSession
import com.toren.odev10.domain.model.Note
import com.toren.odev10.domain.repo.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel
@Inject constructor(
    private val notesRepository: NotesRepository
): ViewModel() {

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    private val _filteredNotes = MutableLiveData<List<Note>>()
    val filteredNotes: LiveData<List<Note>> get() = _filteredNotes

    init {
        getNotes()
    }

    fun filterNotes(query: String) {
        if (query.isEmpty()) {
            _filteredNotes.value = notes.value
        } else {
            _filteredNotes.value = notes.value?.filter {
                it.title.contains(query, ignoreCase = true) ||
                        it.note.contains(query, ignoreCase = true)
            }
        }
    }

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            if (UserSession.USER_ID != null) {
                val data = notesRepository.getAllNotes(UserSession.USER_ID!!).toMutableList()
                _notes.postValue(data)
            }
        }
    }
}