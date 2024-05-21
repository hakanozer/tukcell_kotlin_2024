package com.mai.maidebeyzabulbul_vize3.services

import com.mai.maidebeyzabulbul_vize3.models.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyServices {
    @GET("/users")
    fun getUsers(): Call<Users>

    @GET("/users/filter")
    fun filterUsers(
        @Query("key") key: String,
        @Query("value") value: String
    ): Call<Users>
}
