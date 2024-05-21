package com.example.yusuf_mucahit_solmaz_vize_3.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity.UserX
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.repository.UserRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<UserX>?>()
    val users: MutableLiveData<List<UserX>?> get() = _users



    fun fetchUsers() {
        userRepository.getUsers { users ->
            _users.postValue(users)
        }
    }

}