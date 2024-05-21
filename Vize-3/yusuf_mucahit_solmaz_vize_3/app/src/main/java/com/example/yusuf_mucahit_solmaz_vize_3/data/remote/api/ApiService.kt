package com.example.yusuf_mucahit_solmaz_vize_3.data.remote.api

import com.example.yusuf_mucahit_solmaz_vize_3.core.Utils.GET_USERS
import com.example.yusuf_mucahit_solmaz_vize_3.core.Utils.GET_USERS_BY_FILTER
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity.RootResponse
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity.UserX
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(GET_USERS)
    fun getUsers() : Call<RootResponse>

    @GET(GET_USERS_BY_FILTER)
    fun getUsersByFirstName(
        @Query("key") key: String,
        @Query("value") value: String
    ): Call<RootResponse>
}