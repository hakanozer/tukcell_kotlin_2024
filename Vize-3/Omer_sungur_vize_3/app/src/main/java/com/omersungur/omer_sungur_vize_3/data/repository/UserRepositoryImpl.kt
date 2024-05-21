package com.omersungur.omer_sungur_vize_3.data.repository

import com.omersungur.omer_sungur_vize_3.core.Resource
import com.omersungur.omer_sungur_vize_3.data.mapper.toUser
import com.omersungur.omer_sungur_vize_3.data.remote.UserApi
import com.omersungur.omer_sungur_vize_3.domain.model.User
import com.omersungur.omer_sungur_vize_3.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi
) : UserRepository {

    override fun getUsers(): Flow<Resource<User>> = flow {
        emit(Resource.Loading(isLoading = true))
        val response = userApi.getUsers()
        emit(Resource.Success(data = response.toUser()))
    }

    override fun filterUsers(key: String, value: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading(isLoading = true))
        val response = userApi.filterUsers(key = key, value = value)
        emit(Resource.Success(data = response.toUser()))
    }
}