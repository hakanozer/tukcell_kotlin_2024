package com.tlh.vize3.ui


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tlh.vize3.configs.RetrofitInstance
import com.tlh.vize3.models.User
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getUsers()
                _users.value = response.users
                Log.d("UserViewModel", "Fetched users: ${response.users}")
            } catch (e: Exception) {
               
                _users.value = emptyList()
                Log.e("UserViewModel", "Error fetching users", e)
            }
        }
    }

    fun fetchFilteredUsers(key: String, value: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getFilteredUsers(key, value)
                _users.value = response.users
                Log.d("UserViewModel", "Fetched filtered users: ${response.users}")
            } catch (e: Exception) {
           
                _users.value = emptyList()
                Log.e("UserViewModel", "Error fetching filtered users", e)
            }
        }
    }
}
