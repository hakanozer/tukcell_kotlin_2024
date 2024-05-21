package com.cevdetkilickeser.cevdetkilickeservize3.service

import com.cevdetkilickeser.cevdetkilickeservize3.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    @GET("/users")
    fun getUsers(
        @Query("limit") limit: Int = 100
    ): Call<Users>

    @GET("/users/filter")
    fun getUsersWithFilter(
        @Query("key") key: String, @Query("value") value: String, @Query("limit") limit: Int = 100
    ): Call<Users>

}