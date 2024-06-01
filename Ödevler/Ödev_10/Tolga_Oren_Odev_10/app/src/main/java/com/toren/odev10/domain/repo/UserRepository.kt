package com.toren.odev10.domain.repo

import com.toren.odev10.domain.model.User

interface UserRepository {

    suspend fun addUser(user: User) : Long

    suspend fun authenticateUser(username: String, password: String): Pair<Boolean, Int?>
}