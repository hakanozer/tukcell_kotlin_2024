package com.yeceylan.yunusemreceylan_snav3.data.api

import com.yeceylan.yunusemreceylan_snav3.data.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface Service {

    @GET("users")
    fun getUsers(): Call<Users>
}
