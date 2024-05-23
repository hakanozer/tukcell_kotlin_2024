package com.umutyusufcinar.odev9.services

import com.umutyusufcinar.odev9.models.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
//servis için derste kullandığımız klasik kodları kullanıyorum yine
interface IDumyService {

    @GET("products")
    fun getProduct(@Query("limit") limit:Int,@Query("skip") skip:Int):Call<Products>
}