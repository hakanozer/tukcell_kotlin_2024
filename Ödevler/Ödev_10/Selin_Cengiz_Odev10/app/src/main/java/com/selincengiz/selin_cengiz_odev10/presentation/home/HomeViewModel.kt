package com.selincengiz.selin_cengiz_odev10.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selincengiz.selin_cengiz_odev10.common.HomeState
import com.selincengiz.selin_cengiz_odev10.common.Resource
import com.selincengiz.selin_cengiz_odev10.domain.repo.INoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val noteRepo: INoteRepo):ViewModel() {

    private var _homeState = MutableStateFlow<HomeState>(HomeState.Entry)
    val homeState: StateFlow<HomeState>
        get() = _homeState.asStateFlow()

    fun getNotes() {
        viewModelScope.launch {
            val result = noteRepo.getAllNote()

            when (result) {
                is Resource.Success -> {
                    _homeState.value = HomeState.Notes(result.data)
                }

                is Resource.Error -> {
                    _homeState.value = HomeState.Error(result.throwable)
                }
            }
        }
    }

    fun getNotesByQuery(search: String) {
        viewModelScope.launch {
            val result = noteRepo.getNotesByQuery(search)
            when (result) {
                is Resource.Success -> {
                    _homeState.value = HomeState.Notes(result.data)
                }

                is Resource.Error -> {
                    _homeState.value = HomeState.Error(result.throwable)
                }
            }
        }
    }

}