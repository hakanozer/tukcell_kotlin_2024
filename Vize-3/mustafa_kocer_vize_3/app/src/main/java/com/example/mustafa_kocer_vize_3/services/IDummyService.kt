package com.example.mustafa_kocer_vize_3.services

import com.example.mustafa_kocer_vize_3.models.UsersModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    @GET("users")
    fun getAllUsers(): Call<UsersModel>

    @GET("users/filter")
    fun getUsersByFilter(
        @Query("key") key: String = "firstName",
        @Query("value") value: String
    ): Call<UsersModel>

}