package com.omersungur.omer_sungur_odev_10.data.local.database.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.omersungur.omer_sungur_odev_10.data.local.database.user.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user_table")
    fun getUsers(): Flow<List<UserEntity>>
}