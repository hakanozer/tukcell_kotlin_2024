package com.yeceylan.yunusemreceylan_snav3.presentation.filter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeceylan.yunusemreceylan_snav3.data.model.User
import com.yeceylan.yunusemreceylan_snav3.data.repository.FilteredUserRepository
import com.yeceylan.yunusemreceylan_snav3.domain.usecase.FetchFilteredUsersUseCase
import kotlinx.coroutines.launch

class FilterViewModel : ViewModel() {
    val usersLiveData: MutableLiveData<List<User>?> = MutableLiveData()
    private val repository = FilteredUserRepository()
    private val fetchFilteredUsersUseCase = FetchFilteredUsersUseCase(repository)

    fun fetchUsers(filterField: String, filterValue: String) {
        viewModelScope.launch {
            fetchFilteredUsersUseCase(filterField, filterValue) { users ->
                usersLiveData.postValue(users)
            }
        }
    }

}
