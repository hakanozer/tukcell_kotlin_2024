package com.omersungur.omer_sungur_odev_10.data.mapper

import com.omersungur.omer_sungur_odev_10.data.local.database.user.entity.UserEntity
import com.omersungur.omer_sungur_odev_10.domain.model.User

fun UserEntity.toUser(): User {
    return User(
        id = id,
        name = name,
        email = email,
        password = password
    )
}

fun User.toUserEntity(): UserEntity {
    return UserEntity(
        id = id,
        name = name,
        email = email,
        password = password
    )
}