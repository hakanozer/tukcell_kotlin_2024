package com.mai.days9.services



import com.mai.maidebeyzabulbul_odev9.models.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyServices {

    @GET("products")
    fun getProducts(
        @Query("limit") limit: Long,
        @Query("skip") skip: Long
    ): Call<Product>
}