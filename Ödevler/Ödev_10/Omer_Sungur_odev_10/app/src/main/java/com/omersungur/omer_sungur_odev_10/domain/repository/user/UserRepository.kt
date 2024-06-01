package com.omersungur.omer_sungur_odev_10.domain.repository.user

import com.omersungur.omer_sungur_odev_10.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun insertUser(user: User)
    fun getUsers(): Flow<List<User>>
}