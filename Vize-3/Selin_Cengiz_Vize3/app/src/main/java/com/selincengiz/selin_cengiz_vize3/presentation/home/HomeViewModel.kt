package com.selincengiz.selin_cengiz_vize3.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selincengiz.selin_cengiz_vize3.common.HomeState
import com.selincengiz.selin_cengiz_vize3.common.Resource
import com.selincengiz.selin_cengiz_vize3.domain.repo.IUsersRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val usersRepoImpl: IUsersRepo,
) : ViewModel() {
    private var _homeState = MutableStateFlow<HomeState>(HomeState.Entry)
    val homeState: StateFlow<HomeState>
        get() = _homeState.asStateFlow()

    fun getUsers() {
        viewModelScope.launch {
            _homeState.value = HomeState.Loading
            val result = usersRepoImpl.getUsers()
            when (result) {
                is Resource.Success -> {
                    _homeState.value = HomeState.Users(result.data)
                }

                is Resource.Error -> {
                    _homeState.value = HomeState.Error(result.throwable)
                }
            }
        }
    }

    fun filterUsers(key: String, value: String) {
        viewModelScope.launch {
            _homeState.value = HomeState.Loading
            val result = usersRepoImpl.filterUsers(key, value)
            when (result) {
                is Resource.Success -> {
                    _homeState.value = HomeState.Users(result.data)
                }

                is Resource.Error -> {
                    _homeState.value = HomeState.Error(result.throwable)
                }
            }
        }
    }
}