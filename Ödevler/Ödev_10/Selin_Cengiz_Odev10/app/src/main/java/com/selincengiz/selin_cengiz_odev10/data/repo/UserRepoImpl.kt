package com.selincengiz.selin_cengiz_odev10.data.repo

import com.selincengiz.selin_cengiz_odev10.data.entities.UserRoom
import com.selincengiz.selin_cengiz_odev10.data.source.local.IUserDao
import com.selincengiz.selin_cengiz_odev10.domain.repo.IUserRepo

class UserRepoImpl(private val userDao: IUserDao) : IUserRepo {
    override suspend fun insertUser(user: UserRoom) {
        userDao.insertUser(user)
    }

    override suspend fun isUserExist(email: String, password: String): Int {
        return userDao.isUserExist(email, password)
    }
}