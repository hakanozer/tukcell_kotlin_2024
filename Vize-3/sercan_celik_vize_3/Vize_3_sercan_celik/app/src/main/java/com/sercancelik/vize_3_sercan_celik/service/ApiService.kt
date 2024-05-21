package com.sercancelik.vize_3_sercan_celik.service

import com.sercancelik.vize_3_sercan_celik.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/users")
    fun getData(): Call<UserResponse>

    @GET("/users/filter")
    fun filterUsers(
        @Query("key") key: String,
        @Query("value") value: String
    ): Call<UserResponse>
}
