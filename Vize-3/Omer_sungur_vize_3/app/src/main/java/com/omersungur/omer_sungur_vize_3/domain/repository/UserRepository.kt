package com.omersungur.omer_sungur_vize_3.domain.repository

import com.omersungur.omer_sungur_vize_3.core.Resource
import com.omersungur.omer_sungur_vize_3.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<Resource<User>>
    fun filterUsers(key: String, value: String): Flow<Resource<User>>
}
