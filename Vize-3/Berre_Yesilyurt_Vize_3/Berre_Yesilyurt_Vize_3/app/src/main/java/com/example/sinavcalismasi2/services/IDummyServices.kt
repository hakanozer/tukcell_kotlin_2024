package com.example.sinavcalismasi2.services

import com.example.sinavcalismasi2.models.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyServices {
    @GET("users")
    fun getUsers(): Call<Users>

    @GET("users/filter")
    fun getUsersFilter(@Query("key") key:String?, @Query("value") value:String?): Call<Users>
}