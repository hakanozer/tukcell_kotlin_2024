package com.yeceylan.yunusemreceylan_snav3.domain.usecase

import com.yeceylan.yunusemreceylan_snav3.data.model.User
import com.yeceylan.yunusemreceylan_snav3.data.repository.UserRepository

class FetchUsersUseCase(private val repository: UserRepository) {

    operator fun invoke(onResult: (List<User>?) -> Unit) {
        repository.fetchUsers { users ->
            onResult(users)
        }
    }
}
