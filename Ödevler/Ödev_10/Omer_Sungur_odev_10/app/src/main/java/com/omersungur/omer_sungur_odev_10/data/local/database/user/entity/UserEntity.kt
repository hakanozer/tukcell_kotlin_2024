package com.omersungur.omer_sungur_odev_10.data.local.database.user.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.omersungur.omer_sungur_odev_10.core.Constants.USER_TABLE_NAME

@Entity(tableName = USER_TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
)