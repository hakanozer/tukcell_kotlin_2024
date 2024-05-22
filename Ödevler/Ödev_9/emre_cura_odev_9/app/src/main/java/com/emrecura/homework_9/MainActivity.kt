package com.emrecura.homework_9

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.emrecura.homework_9.adapters.ProductAdapters
import com.emrecura.homework_9.configs.ApiClient
import com.emrecura.homework_9.models.Product
import com.emrecura.homework_9.models.Products
import com.emrecura.homework_9.services.DummyService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService : DummyService
    lateinit var listViewProduct: ListView
    private lateinit var productAdapter: ProductAdapters
    private var productsList = mutableListOf<Product>()
    private var isLoading = false
    private var isLastPage = false
    private var currentPage = 0
    private val pageSize = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        listViewProduct = findViewById(R.id.listViewProduct)
        productAdapter = ProductAdapters(this, productsList)
        listViewProduct.adapter = productAdapter

        listViewProduct.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (!isLoading && !isLastPage && (firstVisibleItem + visibleItemCount >= totalItemCount)) {
                    getProducts()
                }
            }

            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

            }
        })

        getProducts()
    }

    private fun getProducts() {
        isLoading = true
        dummyService.getProducts(pageSize, currentPage * pageSize).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let { productsResponse ->
                        if (productsResponse.products.isEmpty()) {
                            isLastPage = true
                        } else {
                            productsList.addAll(productsResponse.products)
                            productAdapter.notifyDataSetChanged()
                            currentPage++
                        }
                    }
                }
                isLoading = false
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.d("getProducts", t.message.toString())
                isLoading = false
            }
        })
    }
}