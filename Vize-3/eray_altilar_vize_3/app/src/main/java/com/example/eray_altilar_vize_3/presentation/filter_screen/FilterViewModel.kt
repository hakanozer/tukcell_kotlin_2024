package com.example.eray_altilar_vize_3.presentation.filter_screen

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
class FilterViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _user = MutableStateFlow<Resource<UsersModel>>(Resource.Loading())
    val user: StateFlow<Resource<UsersModel>> = _user

    fun getFilteredUsers(key: String, value: String) = viewModelScope.launch {
         userRepository.getFilteredUsers(key,value).collect {
             _user.value = it
        }
    }
}

