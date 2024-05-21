package com.omersungur.omer_sungur_vize_3.domain.use_case.get_users_use_case

import com.omersungur.omer_sungur_vize_3.core.Resource
import com.omersungur.omer_sungur_vize_3.domain.model.User
import com.omersungur.omer_sungur_vize_3.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): Flow<Resource<User>> {
        return userRepository.getUsers()
    }
}
