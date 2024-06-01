package com.toren.odev10.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toren.odev10.domain.model.Note
import com.toren.odev10.domain.repo.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel
    @Inject constructor(
        private val repository: NotesRepository
    ): ViewModel() {

    private val _editResult = MutableLiveData<Boolean>()
    val editResult: LiveData<Boolean> = _editResult

    fun editNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.updateNote(note)
                _editResult.postValue(response > 0)
            } catch (e: Exception) {
                _editResult.postValue(false)
            }
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.deleteNote(note.id)
                _editResult.postValue(response > 0)
            } catch (e: Exception) {
                _editResult.postValue(false)
            }
        }
    }
}