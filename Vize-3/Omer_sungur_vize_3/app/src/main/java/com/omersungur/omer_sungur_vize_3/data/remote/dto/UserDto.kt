package com.omersungur.omer_sungur_vize_3.data.remote.dto

data class UserDto(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserXDto>
)
