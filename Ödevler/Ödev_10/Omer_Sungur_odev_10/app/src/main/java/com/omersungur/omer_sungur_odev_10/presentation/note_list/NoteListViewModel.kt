package com.omersungur.omer_sungur_odev_10.presentation.note_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.omersungur.omer_sungur_odev_10.domain.model.Note
import com.omersungur.omer_sungur_odev_10.domain.repository.note.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    val noteList: LiveData<List<Note>> = repository.getNotes().asLiveData()
    private val newList = MutableLiveData<List<Note>>()
    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

    fun searchNote(query: String) {
        viewModelScope.launch {
            try {
                newList.value = repository.searchNotes(query)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}