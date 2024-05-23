package com.mai.maidebeyzabulbul_odev9

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mai.days9.configs.ApiClient
import com.mai.days9.services.DummyServices
import com.mai.maidebeyzabulbul_odev9.adapter.ProductAdapter
import com.mai.maidebeyzabulbul_odev9.models.Product
import com.mai.maidebeyzabulbul_odev9.models.ProductElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {


    private lateinit var listView: ListView
    private lateinit var adapter: ProductAdapter
    private val products = mutableListOf<ProductElement>()
    private lateinit var productCounter: TextView
    private var isLoading = false
    private var skip = 0L
    private val limit = 10L
    private lateinit var DummyService: DummyServices


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        DummyService = ApiClient.getClient().create(DummyServices::class.java)
        listView = findViewById(R.id.listView)
        productCounter = findViewById(R.id.productCounter)
        adapter = ProductAdapter(this, products)
        listView.adapter = adapter

        fetchMoreProducts()  // Burada fetchMoreProducts fonksiyonunu çağırıyoruz

        listView.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {}

            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (!isLoading && totalItemCount <= (firstVisibleItem + visibleItemCount)) {
                    fetchMoreProducts()
                }
            }
        })
    }

    // fetchMoreProducts fonksiyonunu burada tanımlıyoruz
    private fun fetchMoreProducts() {
        isLoading = true
        DummyService.getProducts(limit, skip).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let { productResponse ->
                        products.addAll(productResponse.products)
                        adapter.notifyDataSetChanged()
                        skip += limit
                        updateProductCounter()
                    }
                } else {
                    Log.e("MainActivity", "Response failed: ${response.errorBody()?.string()}")
                }
                isLoading = false
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                t.printStackTrace()
                Log.e("MainActivity", "Network request failed: ${t.message}")
                isLoading = false
            }
        })
    }

    // Ürün sayacını güncellemek için bir fonksiyon
    private fun updateProductCounter() {
        productCounter.text = "Loaded Products: ${products.size}"
    }
}
