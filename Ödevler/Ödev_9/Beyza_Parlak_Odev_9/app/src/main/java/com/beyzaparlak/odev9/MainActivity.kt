package com.beyzaparlak.odev9

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.beyzaparlak.odev9.adapters.ProductAdapters
import com.beyzaparlak.odev9.configs.ApiClient
import com.beyzaparlak.odev9.models.Product
import com.beyzaparlak.odev9.models.Products
import com.beyzaparlak.odev9.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var dummyService: IDummyService
    lateinit var listViewProducts: ListView
    lateinit var productAdapter: ProductAdapters
    var arr: MutableList<Product> = mutableListOf()

    private var currentPage = 1
    private var isLoading = false
    private val pageSize = 5
    // bir pagede 5 data listelenecek, scroll ile devamı gelecek

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listViewProducts = findViewById(R.id.listViewProducts)
        productAdapter = ProductAdapters(this, arr)
        listViewProducts.adapter = productAdapter

        dummyService = ApiClient.getClient().create(IDummyService::class.java)
        loadProducts(currentPage)

        // scrollviewin her sona ulaştığının algılanmalı ve yeni veri için loadProducts fonk çağırılmalı
        listViewProducts.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

            }
            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (view != null && view.lastVisiblePosition == totalItemCount - 1 && !isLoading) {
                    // Son öğeye ulaşıldı, yeni verileri yüklüyorum
                    currentPage++
                    loadProducts(currentPage)
                }
                // kaçıncı sayfada olunduğunu texView içine yazdıralım
                val pageNumberTextView = findViewById<TextView>(R.id.pageNumber)
                pageNumberTextView.text = "Page: $currentPage"
            }
        })



    }

    // verilerin getirilmesi
    private fun loadProducts(page: Int) {
        isLoading = true
        dummyService.getProducts(page, pageSize).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    val newProducts = response.body()?.products ?: emptyList()
                    arr.addAll(newProducts)
                    productAdapter.notifyDataSetChanged()
                    isLoading = false
                }
            }
            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("getProducts", t.message ?: "Unknown error")
                isLoading = false
            }
        })
    }
}