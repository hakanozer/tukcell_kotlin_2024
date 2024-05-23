package com.selincengiz.selin_cengiz_odev9.data.source.remote

import com.selincengiz.selin_cengiz_odev9.common.Constants.GET_PRODUCTS
import com.selincengiz.selin_cengiz_odev9.data.entities.ResponseProducts
import retrofit2.http.GET
import retrofit2.http.Query

interface IProductsService {
    @GET(GET_PRODUCTS)
    suspend fun getProducts(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int = 10
    ): ResponseProducts
}