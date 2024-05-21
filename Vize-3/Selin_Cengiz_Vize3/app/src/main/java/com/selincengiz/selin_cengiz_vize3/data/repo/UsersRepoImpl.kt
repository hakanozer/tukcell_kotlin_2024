package com.selincengiz.selin_cengiz_vize3.data.repo

import com.selincengiz.selin_cengiz_vize3.common.Resource
import com.selincengiz.selin_cengiz_vize3.data.mapper.mapToUserUI
import com.selincengiz.selin_cengiz_vize3.data.source.remote.IUsersService
import com.selincengiz.selin_cengiz_vize3.domain.entities.UserUI
import com.selincengiz.selin_cengiz_vize3.domain.repo.IUsersRepo
import java.lang.Exception

class UsersRepoImpl(private val usersService: IUsersService) : IUsersRepo {

    override suspend fun getUsers(): Resource<List<UserUI>> {
        return try {
            Resource.Success(usersService.getUsers().users?.map { item ->
                item.mapToUserUI()
            })
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    override suspend fun filterUsers(key: String, value: String): Resource<List<UserUI>> {
        return try {
            Resource.Success(usersService.filterUsers(key, value).users?.map { item ->
                item.mapToUserUI()
            })
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}