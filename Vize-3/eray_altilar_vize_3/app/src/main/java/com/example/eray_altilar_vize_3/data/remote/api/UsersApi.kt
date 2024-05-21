package com.example.eray_altilar_vize_3.data.remote.api

import com.example.eray_altilar_vize_3.data.remote.dto.Users
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {
    @GET("users")
    suspend fun getUsers(): Users

    @GET("users/filter")
    suspend fun getUsersByFirstName(
        @Query("key") key: String,
        @Query("value") value: String
    ) : Users

}