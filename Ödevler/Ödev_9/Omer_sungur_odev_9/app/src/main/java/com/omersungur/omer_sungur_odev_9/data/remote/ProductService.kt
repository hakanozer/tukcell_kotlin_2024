package com.omersungur.omer_sungur_odev_9.data.remote

import com.omersungur.omer_sungur_odev_9.data.remote.dto.ProductDtoResult
import retrofit2.http.GET

interface ProductService {

    @GET("/products")
    suspend fun getProducts(): ProductDtoResult
}