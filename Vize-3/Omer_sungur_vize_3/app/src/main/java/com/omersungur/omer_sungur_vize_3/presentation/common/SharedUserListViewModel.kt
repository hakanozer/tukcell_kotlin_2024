package com.omersungur.omer_sungur_vize_3.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omersungur.omer_sungur_vize_3.core.Resource
import com.omersungur.omer_sungur_vize_3.domain.model.User
import com.omersungur.omer_sungur_vize_3.domain.use_case.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedUserListViewModel @Inject constructor(private val userUseCase: UserUseCase): ViewModel() {

    private val _allUsers = MutableStateFlow<Resource<User>>(Resource.Loading())
    val allUsers: StateFlow<Resource<User>>  = _allUsers

    private val _filteredUsers = MutableStateFlow<Resource<User>>(Resource.Loading())
    val filteredUsers: StateFlow<Resource<User>>  = _filteredUsers

    init {
        getAllUsers()
    }

    private fun getAllUsers() {
        viewModelScope.launch {
            userUseCase.getUsersUseCase().collect { result ->
                _allUsers.value = result
                _filteredUsers.value = result // İlk başta tüm kullanıcılar aynı zamanda filtrelenmiş kullanıcılar olarak ayarlanır
            }
        }
    }

    fun filterUsers(key: String, value: String) {
        viewModelScope.launch {
            userUseCase.filterUsersUseCase(key = key, value = value).collect { result ->
                _filteredUsers.value = result
            }
        }
    }

    fun resetFilters() {
        _filteredUsers.value = _allUsers.value
    }
}
