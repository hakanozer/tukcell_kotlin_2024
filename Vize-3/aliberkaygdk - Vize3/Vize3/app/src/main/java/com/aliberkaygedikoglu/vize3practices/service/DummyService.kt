package com.aliberkaygedikoglu.vize3practices.service

import com.aliberkaygedikoglu.vize3practices.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {

    @GET("users")
    fun getUsers() : Call<Users>

    @GET("users/filter")
    fun getFilter(
        @Query("key") key: String ,
        @Query("value") value: String
    ) : Call<Users>

}