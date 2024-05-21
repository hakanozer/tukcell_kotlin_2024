package com.example.emre_bitil_vize_3.services

import com.example.emre_bitil_vize_3.models.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {

    @GET("users")
    fun getUsers() : Call<Products>

    @GET("users/filter")
    fun getFilter(
        @Query("key") key: String,
        @Query("value") value: String
    ) : Call<Products>
}