package com.selincengiz.selin_cengiz_odev10.domain.repo


import com.selincengiz.selin_cengiz_odev10.data.entities.UserRoom

interface IUserRepo {
    suspend fun insertUser(user: UserRoom)

    suspend fun isUserExist(email: String, password: String): Int
}