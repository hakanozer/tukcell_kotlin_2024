package com.muratdayan.odev10.presentation.notes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muratdayan.odev10.models.Note
import com.muratdayan.odev10.services.NoteService

class NotesViewModel : ViewModel() {

    // mutable live data ile observable stateler
    private val _sortedNotes = MutableLiveData<List<Note>>()
    val sortedNotes: LiveData<List<Note>> = _sortedNotes

    private val _isLongPressedState = MutableLiveData<Boolean>()
    val isLongPressed: LiveData<Boolean> = _isLongPressedState

    private val _isSearched = MutableLiveData<Boolean>()
    val isSearched: LiveData<Boolean> = _isSearched

    fun sortNotesByPriority(noteService: NoteService) {
        val sortedNotesList = noteService.getNotesSortedByPriority()
        _sortedNotes.value = sortedNotesList
    }

    fun getAllNotes(noteService: NoteService) {
        val allNotesList = noteService.getAllNotes()
        _sortedNotes.value = allNotesList
    }

    fun deleteNote(noteService: NoteService, vararg nids: Int) {
        noteService.deleteNote(*nids)
        getAllNotes(noteService)
    }

    fun searchNote(noteService: NoteService, q: String) {
        val searchedList = noteService.searchNotes(q)
        Log.d("searchnotevm", "searchNote: $searchedList")
        _isSearched.value = true
        _sortedNotes.value = searchedList
    }

    fun updateNote(noteService: NoteService, note: Note,isDone: Int) {
        noteService.updateNote(note.nid, note.title, note.detail, note.priority,note.date!!, isDone)
        getAllNotes(noteService)
    }

    fun longPressed() {
        _isLongPressedState.value = true
    }

    fun longPressedFinished() {
        _isLongPressedState.value = false
    }

    fun searchOpenControl(isSearchOpen: Boolean) {
        if (isSearchOpen) {
            _isSearched.value = true
        } else {
            _isSearched.value = false
        }
    }


}