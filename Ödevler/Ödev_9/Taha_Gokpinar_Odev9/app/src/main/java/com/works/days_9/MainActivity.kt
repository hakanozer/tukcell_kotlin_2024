package com.works.days_9

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.days_9.adaptors.ProductAdaptors
import com.works.days_9.configs.ApiClient
import com.works.days_9.models.Product
import com.works.days_9.models.Products
import com.works.days_9.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var listViewProducts: ListView
    lateinit var productAdaptor: ProductAdaptors
    lateinit var arr: MutableList<Product>

    var isLoading = false
    val limit = 10
    var skip = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listViewProducts = findViewById(R.id.listViewProducts)
        arr = mutableListOf()
        productAdaptor = ProductAdaptors(this, arr)
        listViewProducts.adapter = productAdaptor

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        loadData()

        listViewProducts.setOnScrollChangeListener { _, _, _, _, _ ->
            if (!listViewProducts.canScrollVertically(1) && !isLoading) {
                loadData()
            }
        }
    }

    fun loadData() {
        isLoading = true
        dummyService.getProducts(limit, skip).enqueue(object : Callback<Products> {
            override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                isLoading = false
                if (p1.isSuccessful) {
                    val products = p1.body()!!.products
                    products?.let {
                        arr.addAll(it)
                        productAdaptor.notifyDataSetChanged()
                        skip += limit
                    }
                }
            }

            override fun onFailure(p0: Call<Products>, p1: Throwable) {
                isLoading = false
                Log.e("getProducts", p1.message!!)
            }
        })
    }
}
