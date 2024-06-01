package com.toren.odev10.presentation.viewmodel

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
class AddNoteViewModel
@Inject constructor(
    private val notesRepository: NotesRepository
) : ViewModel() {

    private val _noteResult = MutableLiveData<Boolean>()
    val noteResult: MutableLiveData<Boolean> = _noteResult

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = notesRepository.addNote(note)
            _noteResult.postValue(result > 0)
        }
    }
}