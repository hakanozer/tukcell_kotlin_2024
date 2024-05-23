package com.example.yusuf_mucahit_solmaz_odev_9.data.remote.service

import com.example.yusuf_mucahit_solmaz_odev_9.data.remote.model.RootProduct
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiService {

    @GET("products")
    suspend fun getProducts(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int,
    ): RootProduct

}