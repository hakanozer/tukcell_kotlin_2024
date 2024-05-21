package com.example.eray_altilar_vize_3.presentation.home_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eray_altilar_vize_3.core.Resource
import com.example.eray_altilar_vize_3.domain.model.UsersModel
import com.example.eray_altilar_vize_3.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _users = MutableStateFlow<Resource<UsersModel>>(Resource.Loading())
    val users: StateFlow<Resource<UsersModel>> = _users

    init {
        viewModelScope.launch {
            userRepository.getUsers().collect {
                _users.value = it
            }
        }
    }
}