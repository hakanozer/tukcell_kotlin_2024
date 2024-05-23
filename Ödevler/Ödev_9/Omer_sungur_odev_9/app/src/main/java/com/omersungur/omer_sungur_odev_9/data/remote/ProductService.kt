package com.omersungur.omer_sungur_odev_9.data.remote

import com.omersungur.omer_sungur_odev_9.data.remote.dto.ProductDtoResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("products")
    suspend fun getProductsWithPaging(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): ProductDtoResult
}