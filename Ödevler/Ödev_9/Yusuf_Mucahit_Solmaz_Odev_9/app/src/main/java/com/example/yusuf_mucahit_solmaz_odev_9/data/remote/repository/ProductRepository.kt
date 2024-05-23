package com.example.yusuf_mucahit_solmaz_odev_9.data.remote.repository

import com.example.yusuf_mucahit_solmaz_odev_9.data.remote.model.RootProduct
import com.example.yusuf_mucahit_solmaz_odev_9.data.remote.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getProducts(limit: Int, skip: Int): RootProduct {
        return withContext(Dispatchers.IO) {
            apiService.getProducts(limit, skip)
        }
    }
}