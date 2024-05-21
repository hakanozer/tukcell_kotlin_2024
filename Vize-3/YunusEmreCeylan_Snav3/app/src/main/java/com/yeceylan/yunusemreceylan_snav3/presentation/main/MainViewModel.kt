package com.yeceylan.yunusemreceylan_snav3.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeceylan.yunusemreceylan_snav3.data.model.User
import com.yeceylan.yunusemreceylan_snav3.data.repository.UserRepository
import com.yeceylan.yunusemreceylan_snav3.domain.usecase.FetchUsersUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    val usersLiveData: MutableLiveData<List<User>?> = MutableLiveData()
    private val repository = UserRepository()
    private val fetchUsersUseCase = FetchUsersUseCase(repository)

    fun fetchUsers() {
        viewModelScope.launch {
            fetchUsersUseCase { users ->
                usersLiveData.postValue(users)
            }
        }
    }

    fun setFilteredUsers(users: List<User>) {
        usersLiveData.value = users
    }
    fun searchUsers(query: String, allUsers: List<User>) {
        val filteredUsers = allUsers.filter { user ->
            user.firstName.contains(query, ignoreCase = true) ||
                    user.email.contains(query, ignoreCase = true)
        }
        usersLiveData.value = filteredUsers
    }
}
