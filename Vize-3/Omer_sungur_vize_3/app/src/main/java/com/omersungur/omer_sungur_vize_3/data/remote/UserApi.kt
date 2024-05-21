package com.omersungur.omer_sungur_vize_3.data.remote

import com.omersungur.omer_sungur_vize_3.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("users")
    suspend fun getUsers(): UserDto

    @GET("users/filter")
    suspend fun filterUsers(
        @Query("key") key: String,
        @Query("value") value: String
    ): UserDto
}
