package com.example.eray_altilar_vize_3.domain.repository

import com.example.eray_altilar_vize_3.core.Resource
import com.example.eray_altilar_vize_3.domain.model.UsersModel
import kotlinx.coroutines.flow.Flow


interface UserRepository {
    fun getUsers(): Flow<Resource<UsersModel>>
    fun getFilteredUsers(key: String, value: String): Flow<Resource<UsersModel>>
}

