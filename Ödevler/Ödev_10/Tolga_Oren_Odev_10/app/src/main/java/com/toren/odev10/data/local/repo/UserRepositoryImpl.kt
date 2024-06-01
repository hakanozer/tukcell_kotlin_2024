package com.toren.odev10.data.local.repo

import com.toren.odev10.data.local.dao.UserDao
import com.toren.odev10.domain.model.User
import com.toren.odev10.domain.repo.UserRepository

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun addUser(user: User) : Long {
        return userDao.addUser(user)
    }

    override suspend fun authenticateUser(username: String, password: String): Pair<Boolean, Int?> {
        return userDao.authenticateUser(username, password)
    }
}