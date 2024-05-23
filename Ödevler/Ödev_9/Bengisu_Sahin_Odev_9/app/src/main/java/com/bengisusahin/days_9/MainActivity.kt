package com.bengisusahin.days_9

import Product
import Products
import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bengisusahin.days_9.adapters.ProductAdapters
import com.bengisusahin.days_9.configs.ApiClient
import com.bengisusahin.days_9.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var iDummyService: IDummyService
    private lateinit var listViewProducts: ListView
    lateinit var arr: MutableList<Product>
    private lateinit var productAdapters: ProductAdapters
    // to keep track of the current skip value
    private var currentSkip = 0L
    // It determines how many products will be loaded on each page
    private var limit = 10L
    private var isLoading = false

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
        arr = mutableListOf()
        productAdapters = ProductAdapters(this, arr)
        listViewProducts.adapter = productAdapters
        iDummyService = ApiClient.getClient().create(IDummyService::class.java)
        // Load the first page of products
        loadProducts()

        listViewProducts.setOnScrollListener(object : AbsListView.OnScrollListener {
            // when scrolling state changes, this method triggers
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
                when (scrollState) {
                    AbsListView.OnScrollListener.SCROLL_STATE_IDLE -> {
                        // The user has stopped scrolling
                        Log.d("ListView", "Scroll state: idle")
                    }
                    AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL -> {
                        // The user is scrolling using touch
                        Log.d("ListView", "Scroll state: touch scroll")
                    }
                    AbsListView.OnScrollListener.SCROLL_STATE_FLING -> {
                        // The user has lifted their finger and the list is still scrolling
                        Log.d("ListView", "Scroll state: fling")
                    }
                }
            }
            // when scrolling the page this method triggers
            // visibleItemCount takes item count on the page
            // totalItemCount all item in the service
            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int,
                                  totalItemCount: Int) {
                if (!isLoading && firstVisibleItem + visibleItemCount >= totalItemCount &&
                    totalItemCount > 0) {
                    // End has been reached, load more products
                    loadProducts()
                }
            }
        })
    }


    private fun loadProducts() {
        isLoading = true
        iDummyService.getProducts(limit, currentSkip).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    val newProducts = response.body()?.products ?: emptyList()
                    arr.addAll(newProducts)
                    productAdapters.notifyDataSetChanged()
                    // Increase currentSkip for the next page
                    currentSkip += limit
                    // Log the number of new products and total products
                    Log.d("LoadProducts", "Loaded ${newProducts.size} " +
                            "products. Total loaded: ${arr.size}")
                } else {
                    Log.e("LoadProducts", "Failed to load products: ${response.message()}")
                }
                isLoading = false
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("getProducts", t.message!!)
                isLoading = false
            }
        })
    }
}
