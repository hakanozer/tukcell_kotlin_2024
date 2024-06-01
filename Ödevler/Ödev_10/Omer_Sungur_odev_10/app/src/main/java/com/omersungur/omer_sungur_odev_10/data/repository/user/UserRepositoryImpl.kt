package com.omersungur.omer_sungur_odev_10.data.repository.user

import com.omersungur.omer_sungur_odev_10.data.local.database.user.UserDao
import com.omersungur.omer_sungur_odev_10.data.mapper.toUser
import com.omersungur.omer_sungur_odev_10.data.mapper.toUserEntity
import com.omersungur.omer_sungur_odev_10.domain.model.User
import com.omersungur.omer_sungur_odev_10.domain.repository.user.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun insertUser(user: User) {
        userDao.insertUser(user.toUserEntity())
    }

    override fun getUsers(): Flow<List<User>> {
        return userDao.getUsers().map { userEntityList ->
            userEntityList.map { userEntity ->
                userEntity.toUser()
            }
        }
    }
}