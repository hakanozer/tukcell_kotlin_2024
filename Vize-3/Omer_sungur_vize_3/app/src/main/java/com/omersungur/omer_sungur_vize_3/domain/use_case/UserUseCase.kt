package com.omersungur.omer_sungur_vize_3.domain.use_case

import com.omersungur.omer_sungur_vize_3.domain.use_case.filter_users_use_case.FilterUsersUseCase
import com.omersungur.omer_sungur_vize_3.domain.use_case.get_users_use_case.GetUsersUseCase

data class UserUseCase(
    val getUsersUseCase: GetUsersUseCase,
    val filterUsersUseCase: FilterUsersUseCase
)
