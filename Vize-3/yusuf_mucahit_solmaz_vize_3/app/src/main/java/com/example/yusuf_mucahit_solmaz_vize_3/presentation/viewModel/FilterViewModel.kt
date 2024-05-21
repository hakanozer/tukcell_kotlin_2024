package com.example.yusuf_mucahit_solmaz_vize_3.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity.RootResponse
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.repository.FilterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(private val filterRepository: FilterRepository) : ViewModel() {

    private val _filteredUsers = MutableLiveData<RootResponse?>()
    val filteredUsers: LiveData<RootResponse?> get() = _filteredUsers

    fun fetchUsersByKeyAndValue(key: String, value: String) {
        filterRepository.getUsersByKeyAndValue(key, value) { response ->
            if (response != null) {
                _filteredUsers.postValue(response)
            } else {
                _filteredUsers.postValue(null)
                Log.e("FilterViewModel", "Error fetching users")
            }
        }
    }
}
