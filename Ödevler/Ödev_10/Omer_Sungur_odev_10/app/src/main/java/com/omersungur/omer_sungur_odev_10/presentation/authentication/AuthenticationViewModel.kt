package com.omersungur.omer_sungur_odev_10.presentation.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omersungur.omer_sungur_odev_10.domain.model.User
import com.omersungur.omer_sungur_odev_10.domain.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val userList = userRepository.getUsers()

    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }

    fun getUsers(): Flow<List<User>> {
        return userRepository.getUsers()
    }

    fun checkUserInputForRegister(name: String, email: String, password: String): Boolean {
        return !(name.isEmpty() || email.isEmpty() || password.isEmpty())
    }

    fun checkEmailIsAvailable(userEmails: List<String>, currentEmail: String): Boolean {
        var isAvailable = true

        userEmails.forEach {
            if (it == currentEmail) {
                isAvailable = false
                return@forEach
            }
        }
        return isAvailable
    }
}