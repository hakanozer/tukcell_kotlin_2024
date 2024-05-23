package com.works.days_9


import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.works.days_9.adaptors.ProductAdaptors
import com.works.days_9.configs.ApiClient
import com.works.days_9.models.Product
import com.works.days_9.models.Products
import com.works.days_9.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var productAdapter: ProductAdaptors
    private lateinit var dummyService: DummyService
    private lateinit var listViewProducts: ListView
    private lateinit var array: MutableList<Product>
    private var limit = 10
    private var skip = 0
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        array = mutableListOf()
        listViewProducts = findViewById(R.id.listViewProducts)
        productAdapter = ProductAdaptors(this, array)
        listViewProducts.adapter = productAdapter

        listViewProducts.setOnScrollListener(object : AbsListView.OnScrollListener {

            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

            }

            override fun onScroll(
                view: AbsListView?,
                firstVisibleItem: Int,
                visibleItemCount: Int,
                totalItemCount: Int
            ) {
                if (firstVisibleItem + visibleItemCount >= totalItemCount && !isLoading) {
                    isLoading = true
                    skip += limit
                    fetchProducts()
                }
            }
        })
        fetchProducts()
    }

    private fun fetchProducts() {
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        dummyService.getProducts(limit, skip).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful && response.body() != null) {
                    val newProducts = response.body()!!.products
                    array.addAll(newProducts)
                    productAdapter.notifyDataSetChanged()
                    Log.d("datas", array.toString())
                }
                isLoading = false
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("getProducts", t.message ?: "An error occurred")
                isLoading = false
            }
        })
    }
}
