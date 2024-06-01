package com.yeceylan.yunusemreceylan_odev10.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeceylan.yunusemreceylan_odev10.model.entity.User
import com.yeceylan.yunusemreceylan_odev10.model.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    fun insert(user: User, onSuccess: () -> Unit) = viewModelScope.launch {
        repository.insert(user)
        onSuccess()
    }

    fun getUser(username: String, password: String, callback: (User?) -> Unit) = viewModelScope.launch {
        val user = repository.getUser(username, password)
        callback(user)
    }

    fun getUserByUsername(username: String, callback: (User?) -> Unit) = viewModelScope.launch {
        val user = repository.getUserByUsername(username)
        callback(user)
    }
}
