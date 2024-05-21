package com.example.yusuf_mucahit_solmaz_vize_3.data.remote.repository
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.api.ApiService
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity.RootResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FilterRepository @Inject constructor(private val apiService: ApiService) {

    fun getUsersByKeyAndValue(key: String, value: String, callback: (RootResponse?) -> Unit) {
        apiService.getUsersByFirstName(key = key, value = value).enqueue(object : Callback<RootResponse> {
            override fun onResponse(call: Call<RootResponse>, response: Response<RootResponse>) {
                if (response.isSuccessful) {
                    callback(response.body())
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