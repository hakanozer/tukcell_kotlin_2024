package com.ns.enesarisoy_odev9.service

import com.ns.enesarisoy_odev9.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("products")
    fun getProducts(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int,
    ): Call<ProductResponse>

}