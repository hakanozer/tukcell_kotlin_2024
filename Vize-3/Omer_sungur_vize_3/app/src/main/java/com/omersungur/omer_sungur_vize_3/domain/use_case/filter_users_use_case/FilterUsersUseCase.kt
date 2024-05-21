package com.omersungur.omer_sungur_vize_3.domain.use_case.filter_users_use_case

import com.omersungur.omer_sungur_vize_3.core.Resource
import com.omersungur.omer_sungur_vize_3.domain.model.User
import com.omersungur.omer_sungur_vize_3.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilterUsersUseCase @Inject constructor(private val userRepository: UserRepository) {

    operator fun invoke(key: String, value: String): Flow<Resource<User>> {
        return userRepository.filterUsers(key = key, value = value)
    }
}
