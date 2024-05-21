package com.yeceylan.yunusemreceylan_snav3.data.repository

import com.yeceylan.yunusemreceylan_snav3.data.api.ApiClient
import com.yeceylan.yunusemreceylan_snav3.data.api.ServiceFilterName
import com.yeceylan.yunusemreceylan_snav3.data.model.User
import com.yeceylan.yunusemreceylan_snav3.data.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilteredUserRepository {
    private val userFilteredService: ServiceFilterName = ApiClient.getClient().create(ServiceFilterName::class.java)

    fun fetchFilteredUsers(filterField: String, filterValue: String, onResult: (List<User>?) -> Unit) {
        userFilteredService.getFilterName(filterField, filterValue).enqueue(object: Callback<Users> {

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