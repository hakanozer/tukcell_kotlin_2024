package com.toren.odev9.data.remote.api

import com.toren.odev9.data.remote.dto.ProductsDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET("products")
    fun getProducts(@Query ("limit") limit: Int, @Query ("skip") skip: Int): Call<ProductsDto>
}