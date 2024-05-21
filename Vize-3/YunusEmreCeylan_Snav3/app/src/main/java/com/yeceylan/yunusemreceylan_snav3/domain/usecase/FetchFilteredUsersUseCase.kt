package com.yeceylan.yunusemreceylan_snav3.domain.usecase

import com.yeceylan.yunusemreceylan_snav3.data.model.User
import com.yeceylan.yunusemreceylan_snav3.data.repository.FilteredUserRepository

class FetchFilteredUsersUseCase(private val repository: FilteredUserRepository) {

    operator fun invoke(filterField: String, filterValue: String, onResult: (List<User>?) -> Unit) {
        repository.fetchFilteredUsers(filterField, filterValue, onResult)
    }
}