package com.yeceylan.yunusemreceylan_snav3.data.repository

import com.yeceylan.yunusemreceylan_snav3.data.api.ApiClient
import com.yeceylan.yunusemreceylan_snav3.data.api.Service
import com.yeceylan.yunusemreceylan_snav3.data.model.User
import com.yeceylan.yunusemreceylan_snav3.data.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    private val userService: Service = ApiClient.getClient().create(Service::class.java)

    fun fetchUsers(onResult: (List<User>?) -> Unit) {
        userService.getUsers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    onResult(response.body()?.users)
                } else {
                    onResult(null)
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                onResult(null)
            }
        })
    }
}
