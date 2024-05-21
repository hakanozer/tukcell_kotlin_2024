package com.example.vize_3.services

import com.example.vize_3.models.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {

    @GET("users")
    fun getUsers() : Call<Users>

    @GET("users/filter")
    fun getUsersByFilter(
        @Query("key") key: String,
        @Query("value") value: String
    ): Call<Users>
}