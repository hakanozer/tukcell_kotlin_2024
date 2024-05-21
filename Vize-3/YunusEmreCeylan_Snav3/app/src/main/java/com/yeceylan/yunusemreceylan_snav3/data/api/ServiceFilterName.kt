package com.yeceylan.yunusemreceylan_snav3.data.api

import com.yeceylan.yunusemreceylan_snav3.data.model.User
import com.yeceylan.yunusemreceylan_snav3.data.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceFilterName {

    //users/filter?key=firstName&value=Ali
    @GET("users/filter")
    fun getFilterName(
        @Query("key") key: String = "firstName",
        @Query("value") value: String): Call<Users>
}