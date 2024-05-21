package com.muratdayan.vize3.services

import com.muratdayan.vize3.models.UsersRespond
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDummyService {

    // tüm kullanıcıları alma servisi
    @GET("users")
    fun getAllUsers() : Call<UsersRespond>

    // filtreleme servisi
    @GET("users/filter")
    fun getUsersByFilter(
        @Query("key") key : String,
        @Query("value") value : String
    ) : Call<UsersRespond>

    // arama servisi
    @GET("users/search")
    fun getUsersBySearch(
        @Query("q") searchText:String
    ) : Call<UsersRespond>
}