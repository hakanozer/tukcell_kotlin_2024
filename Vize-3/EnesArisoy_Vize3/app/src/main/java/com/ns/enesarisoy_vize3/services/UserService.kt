package com.ns.enesarisoy_vize3.services

import com.ns.enesarisoy_vize3.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("users")
    fun getUsers(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): Call<UserResponse>

    @GET("users/filter")
    fun getFilteredUsers(
        @Query("key") key: String,
        @Query("value") value: String
    ): Call<UserResponse>

}