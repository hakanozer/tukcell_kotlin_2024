package com.example.eray_altilar_vize_3.data.repository

import com.example.eray_altilar_vize_3.core.Resource
import com.example.eray_altilar_vize_3.data.mapper.toUserModel
import com.example.eray_altilar_vize_3.data.mapper.toUsersModel
import com.example.eray_altilar_vize_3.data.remote.api.UsersApi
import com.example.eray_altilar_vize_3.domain.model.UsersModel
import com.example.eray_altilar_vize_3.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val usersApi : UsersApi
) : UserRepository {

    override fun getUsers(): Flow<Resource<UsersModel>> {

        return flow {
            emit(Resource.Loading(isLoading = true))
            val users = usersApi.getUsers()
            emit(Resource.Success(users.toUsersModel()))
        }
    }

    override fun getFilteredUsers(key: String, value: String): Flow<Resource<UsersModel>> {

        return flow {
                emit(Resource.Loading(isLoading = true))
                val users = usersApi.getUsersByFirstName(key = key, value = value)
                emit(Resource.Success(data = users.toUsersModel()))
            }

    }
}