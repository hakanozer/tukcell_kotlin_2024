package com.example.omer_faruk_arslan_vize_3.service

import com.example.omer_faruk_arslan_vize_3.models.Users
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call


interface IDummyService {
    @GET("users")
    fun getUsers(): Call<Users>

    @GET("users/filter")
    fun filterUsers(
        @Query("key") key: String,
        @Query("value") value: String
    ): Call<Users>
}