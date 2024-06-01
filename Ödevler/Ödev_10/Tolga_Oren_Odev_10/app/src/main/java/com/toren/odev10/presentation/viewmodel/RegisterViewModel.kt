package com.toren.odev10.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toren.odev10.common.UserSession
import com.toren.odev10.domain.model.User
import com.toren.odev10.domain.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel
    @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _registerResult = MutableLiveData<Boolean>()
    val registerResult : MutableLiveData<Boolean> = _registerResult

    fun register(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = userRepository.addUser(user)
            if (result > 0) {
                handleAuthentication(user)
            } else {
                _registerResult.postValue(false)
            }
        }
    }

    private suspend fun handleAuthentication(user: User) {
        val authentication = userRepository.authenticateUser(user.username, user.password)
        if (authentication.first) {
            UserSession.USER_ID = authentication.second
            _registerResult.postValue(true)
        } else {
            _registerResult.postValue(false)
        }
    }



}