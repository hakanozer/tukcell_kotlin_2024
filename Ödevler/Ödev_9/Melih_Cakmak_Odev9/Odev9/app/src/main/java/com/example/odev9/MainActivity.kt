package com.example.odev9

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.odev9.adaptors.ProductAdaptors
import com.example.odev9.configs.ApiClient
import com.example.odev9.models.Products
import com.example.odev9.services.DummyService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var listViewProducts: ListView
    lateinit var productAdaptors: ProductAdaptors

    private var isLoading = false
    private var currentPage = 0 // İlk sayfa numarası 0
    private val pageSize = 10 // Sayfa başına çekilecek ürün sayısı

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewProducts = findViewById(R.id.listViewProducts)
        dummyService = ApiClient.getClient().create(DummyService::class.java)

        productAdaptors = ProductAdaptors(this, mutableListOf())
        listViewProducts.adapter = productAdaptors

        listViewProducts.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (view != null && totalItemCount > 0) {
                    val lastItem = firstVisibleItem + visibleItemCount
                    if (lastItem == totalItemCount && !isLoading) {
                        isLoading = true
                        currentPage++
                        fetchProducts()
                        Log.d("Yeni Öğe", "Yeni Öğeler Çekiliyor")
                    }
                }
            }

            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

            }
        })

        // İlk veri setini yükleyin
        fetchProducts()
    }

    private fun fetchProducts() {
        val skip = currentPage * pageSize // Skip değerini hesaplayın
        dummyService.getProducts(pageSize, skip).enqueue(object : Callback<Products> {
            override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                if (p1.isSuccessful) {
                    val newProducts = p1.body()?.products ?: emptyList()

                    productAdaptors.updateData(newProducts)
                    isLoading = false
                    Log.d("datas", newProducts.toString())
                }
            }

            override fun onFailure(p0: Call<Products>, p1: Throwable) {
                Log.e("getProducts", p1.message!!)
                isLoading = false
            }
        })
    }
}
