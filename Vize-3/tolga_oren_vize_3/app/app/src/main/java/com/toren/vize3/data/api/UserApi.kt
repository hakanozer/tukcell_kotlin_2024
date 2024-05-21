package com.toren.vize3.data.api

import com.toren.vize3.data.dto.UsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("users")
    fun getUsers(): Call<UsersResponse>

    @GET("users/filter")
    fun queryUsers(@Query("key") key: String, @Query("value") value: String) : Call<UsersResponse>


}