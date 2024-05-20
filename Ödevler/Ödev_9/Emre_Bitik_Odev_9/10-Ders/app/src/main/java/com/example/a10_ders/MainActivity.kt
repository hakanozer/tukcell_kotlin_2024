package com.example.a10_ders

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.a10_ders.adaptors.ProductAdaptors
import com.example.a10_ders.configs.ApiClient
import com.example.a10_ders.models.Product
import com.example.a10_ders.models.Products
import com.example.a10_ders.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var dummyService: DummyService
    lateinit var listViewProducts: ListView
    lateinit var productAdapter: ProductAdaptors
    lateinit var arr: MutableList<Product>
    var limit = 10
    var skip = 0
    var loading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listViewProducts = findViewById(R.id.listViewProducts)

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        arr = mutableListOf()
        productAdapter = ProductAdaptors(this, arr)
        listViewProducts.adapter = productAdapter

        loadMoreData()

        listViewProducts.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (!loading && firstVisibleItem + visibleItemCount >= totalItemCount && totalItemCount > 0) {
                    loadMoreData()
                }
            }

            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

            }
        })
    }

    private fun loadMoreData() {
        loading = true
        dummyService.getProducts(limit, skip).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    val newProducts = response.body()?.products ?: emptyList()
                    arr.addAll(newProducts)
                    productAdapter.notifyDataSetChanged()
                    skip += limit
                }
                loading = false
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("GetProduct", t.message ?: "Unknown error")
                loading = false
            }
        })
    }
}
