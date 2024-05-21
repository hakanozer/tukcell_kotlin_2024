package com.selincengiz.selin_cengiz_vize3.domain.repo

import com.selincengiz.selin_cengiz_vize3.common.Resource
import com.selincengiz.selin_cengiz_vize3.domain.entities.UserUI

interface IUsersRepo {
    suspend fun getUsers(): Resource<List<UserUI>>

    suspend fun filterUsers(key: String, value: String): Resource<List<UserUI>>
}