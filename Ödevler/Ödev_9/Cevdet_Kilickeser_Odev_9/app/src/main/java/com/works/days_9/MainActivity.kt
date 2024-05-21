package com.works.days_9

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import android.widget.ProgressBar
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

    private lateinit var dummyService: DummyService
    private lateinit var listViewProducts: ListView
    private lateinit var progressBar: ProgressBar
    lateinit var arr: MutableList<Product>
    lateinit var productAdaptors: ProductAdaptors
    private var isLoading = false
    var skip = 0
    var limit = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listViewProducts = findViewById(R.id.listViewProducts)
        progressBar = findViewById(R.id.progressBar)

        arr = mutableListOf()
        productAdaptors = ProductAdaptors(this@MainActivity, arr)
        listViewProducts.adapter = productAdaptors

        getDataFromService(skip, limit)

        listViewProducts.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
                // Do nothing
            }

            override fun onScroll(
                view: AbsListView?,
                firstVisibleItem: Int,
                visibleItemCount: Int,
                totalItemCount: Int
            ) {
                if (view != null && totalItemCount == firstVisibleItem + visibleItemCount && !isLoading) {
                    isLoading = true
                    progressBar.visibility = ProgressBar.VISIBLE
                    getDataFromService(skip, limit)
                }
            }
        })
    }

    private fun getDataFromService(skip: Int, limit: Int) {
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        dummyService.getProducts(skip, limit).enqueue(object : Callback<Products> {
            override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                if (p1.isSuccessful) {
                    p1.body()?.let {
                        arr.addAll(it.products)
                        productAdaptors.notifyDataSetChanged()
                        progressBar.visibility = ProgressBar.GONE
                        this@MainActivity.skip += limit
                    }
                }
                isLoading = false
            }

            override fun onFailure(p0: Call<Products>, p1: Throwable) {
                Log.e("getProducts", p1.message!!)
            }
        })
    }
}