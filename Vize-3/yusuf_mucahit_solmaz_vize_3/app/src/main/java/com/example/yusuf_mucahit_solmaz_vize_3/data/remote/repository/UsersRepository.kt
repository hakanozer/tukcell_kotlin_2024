package com.example.yusuf_mucahit_solmaz_vize_3.data.remote.repository

import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.api.ApiService
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity.RootResponse
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity.UserX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService)  {


    fun getUsers(callback: (List<UserX>?) -> Unit) {
        apiService.getUsers().enqueue(object : Callback<RootResponse> {
            override fun onResponse(call: Call<RootResponse>, response: Response<RootResponse>) {
                if (response.isSuccessful) {
                    callback(response.body()?.users)
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<RootResponse>, t: Throwable) {
                callback(null)
            }
        })
    }

}
