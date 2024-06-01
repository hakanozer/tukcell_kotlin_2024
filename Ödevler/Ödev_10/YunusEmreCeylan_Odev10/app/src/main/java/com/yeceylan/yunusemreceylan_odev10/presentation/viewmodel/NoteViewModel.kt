package com.yeceylan.yunusemreceylan_odev10.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeceylan.yunusemreceylan_odev10.model.entity.Note
import com.yeceylan.yunusemreceylan_odev10.model.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
        loadNotes(note.username)
    }

    fun update(note: Note) = viewModelScope.launch {
        repository.update(note)
        loadNotes(note.username)
    }

    fun delete(note: Note) = viewModelScope.launch {
        repository.delete(note)
        loadNotes(note.username)
    }

    fun loadNotes(username: String) = viewModelScope.launch {
        _notes.value = repository.getNotesForUser(username)
    }

    fun searchNotes(username: String, query: String) = viewModelScope.launch {
        _notes.value = repository.searchNotes(username, query)
    }
}