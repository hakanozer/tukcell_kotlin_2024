package com.tlh.vize3.service


import com.tlh.vize3.models.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface UserApi {
    @GET("users")
    suspend fun getUsers(): UserResponse

    @GET("users/filter")
    suspend fun getFilteredUsers(
        @Query("key") key: String,
        @Query("value") value: String
    ): UserResponse
}
