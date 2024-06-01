package com.yeceylan.yunusemreceylan_odev10.model.repository

import com.yeceylan.yunusemreceylan_odev10.model.dao.UserDao
import com.yeceylan.yunusemreceylan_odev10.model.entity.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {
    suspend fun insert(user: User) = userDao.insert(user)
    suspend fun getUser(username: String, password: String) = userDao.getUser(username, password)
    suspend fun getUserByUsername(username: String) = userDao.getUserByUsername(username)
}
