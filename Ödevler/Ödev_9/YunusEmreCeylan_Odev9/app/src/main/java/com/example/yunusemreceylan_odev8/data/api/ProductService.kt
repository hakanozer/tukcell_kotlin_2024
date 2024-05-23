package com.example.yunusemreceylan_odev8.data.api

import com.example.yunusemreceylan_odev8.data.model.ProductList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("products")
    suspend fun getProducts(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): Response<ProductList>
}
