package com.canerdedeoglu.alistirma.service


import com.canerdedeoglu.alistirma.models.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface IDummyService {

    @GET("users")
    fun getUsers(): Call<Users>

    @GET("users/filter")
    fun filterUsers(
        @Query("key") key: String,
        @Query("value") value: String
    ): Call<Users>
}