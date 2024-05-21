package com.selincengiz.selin_cengiz_vize3.data.source.remote

import com.selincengiz.selin_cengiz_vize3.common.Constants.FILTER_USERS
import com.selincengiz.selin_cengiz_vize3.common.Constants.GET_USERS
import com.selincengiz.selin_cengiz_vize3.data.entities.ResponseUsers
import retrofit2.http.GET
import retrofit2.http.Query

interface IUsersService {
    @GET(GET_USERS)
    suspend fun getUsers(): ResponseUsers

    @GET(FILTER_USERS)
    suspend fun filterUsers(@Query("key") key: String, @Query("value") value: String): ResponseUsers
}