package com.tlh.myapplication8.service

import com.tlh.myapplication8.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {

    @GET("users")
    fun getProducts(
    @Query("limit") limit: Int,
    @Query("skip") skip: Int
    ): Call<User>

    @GET("users/filter")
     fun getUsersFilteredBy(
        @Query("key") filterKey: String,
        @Query("value") filterValue:  String
    ): Call<User>
}