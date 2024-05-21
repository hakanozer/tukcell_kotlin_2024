package com.bengisusahin.vize03_calisma.services

import com.bengisusahin.vize03_calisma.models.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    @GET("users")
    fun getUsers(): Call<Users>

    // "@Query("q") searchText: String:" adds searchText as a "q" parameter to the end of the URL
    // https://dummyjson.com/users/search?q=atuny0 -> atuny0 is a username
    @GET("users/search")
    fun searchUsers(@Query("q") searchText: String): Call<Users>

    // Sends a request to filter users based on the provided key and value
    @GET("users/filter")
    fun filterUsers(@Query("key") key: String, @Query("value") value: String): Call<Users>
}