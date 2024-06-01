package com.toren.odev10.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toren.odev10.common.UserSession
import com.toren.odev10.domain.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
    @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult


    fun authenticationUser(username: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val data = userRepository.authenticateUser(username, password)
            UserSession.USER_ID = data.second
            _loginResult.postValue(data.first)
        }
    }
}