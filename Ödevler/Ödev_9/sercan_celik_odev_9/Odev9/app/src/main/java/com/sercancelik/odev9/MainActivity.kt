package com.sercancelik.odev9

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sercancelik.odev9.adapter.ProductAdapter
import com.sercancelik.odev9.configs.RetrofitClient
import com.sercancelik.odev9.models.Product
import com.sercancelik.odev9.models.ProductsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val dataList: MutableList<Product> = mutableListOf()
    private lateinit var adapter: ProductAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var findedCount: TextView
    private var limit = 10
    private var skip = 0
    private var isLoading = false
    private var isLastPage = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.recyclerView)
        findedCount = findViewById(R.id.findedCount)
        progressBar = findViewById(R.id.progressBar)
        adapter = ProductAdapter(this, dataList)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as GridLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= limit
                    ) {
                        fetchData()
                    }
                }
            }
        })

        fetchData()
    }

    private fun fetchData() {
        isLoading = true
        progressBar.visibility = View.VISIBLE

        RetrofitClient.apiService.getProducts(limit, skip)
            .enqueue(object : Callback<ProductsResponse> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(
                    call: Call<ProductsResponse>,
                    response: Response<ProductsResponse>
                ) {
                    progressBar.visibility = View.GONE
                    isLoading = false

                    if (response.isSuccessful) {
                        val products = response.body()?.products ?: emptyList()
                        dataList.addAll(products)
                        adapter.updateData(dataList)
                        findedCount.text = "Toplam Ürün Sayısı: ${dataList.size}"
                        skip += limit
                        if (products.size < limit) {
                            isLastPage = true
                        }
                    } else {
                        println("Error: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    isLoading = false
                    println("Error: ${t.message}")
                }
            })
    }
}
