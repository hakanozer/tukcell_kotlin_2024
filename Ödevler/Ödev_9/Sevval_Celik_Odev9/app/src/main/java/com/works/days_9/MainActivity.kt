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
import com.works.days_9.models.Products
import com.works.days_9.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var isLoading = false
    private var lastVisibleItem = 0

    lateinit var dummyService: DummyService
    lateinit var listViewProducts: ListView
    lateinit var productAdaptors: ProductAdaptors
    lateinit var progressBar: ProgressBar
    var pageNumber = 0
    val pageSize = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listViewProducts = findViewById(R.id.listViewProducts)
        progressBar = findViewById(R.id.progressBar)
        dummyService = ApiClient.getClient().create(DummyService::class.java)

        loadNextPage()

        listViewProducts.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {}

            override fun onScroll(
                view: AbsListView?,
                firstVisibleItem: Int,
                visibleItemCount: Int,
                totalItemCount: Int
            ) {
                lastVisibleItem = firstVisibleItem + visibleItemCount
                if (lastVisibleItem == totalItemCount && !isLoading) {
                    loadNextPage()
                }
            }
        })
    }

    private fun loadNextPage() {
        progressBar.visibility = ProgressBar.VISIBLE
        Log.d("loadNext", "Loading page: $pageNumber")
        dummyService.getProducts(pageNumber * pageSize, pageSize)
            .enqueue(object : Callback<Products> {
                override fun onResponse(call: Call<Products>, response: Response<Products>) {
                    if (response.isSuccessful) {
                        val newProducts = response.body()?.products ?: emptyList()
                        if (newProducts.isNotEmpty()) {
                            if (pageNumber == 0) {
                                productAdaptors =
                                    ProductAdaptors(this@MainActivity, newProducts.toMutableList())
                                listViewProducts.adapter = productAdaptors
                            } else {
                                productAdaptors.addAll(newProducts)
                                productAdaptors.notifyDataSetChanged()
                            }
                            pageNumber++
                        } else {
                            Log.d("loadNext", "No more data available")
                        }
                    } else {
                        Log.e("getProducts", "Response unsuccessful: ${response.code()}")
                    }
                    isLoading = false
                    progressBar.visibility = ProgressBar.GONE
                }

                override fun onFailure(call: Call<Products>, t: Throwable) {
                    Log.e("getProducts", "Request failed ${t.message}")
                    isLoading = false
                    progressBar.visibility = ProgressBar.GONE
                }
            })
        isLoading = true
    }
}
