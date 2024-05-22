package com.example.eray_altilar_odev_9.presentation.main_screen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eray_altilar_odev_9.R
import com.example.eray_altilar_odev_9.adapters.ProductAdapter
import com.example.eray_altilar_odev_9.configs.ApiClient
import com.example.eray_altilar_odev_9.databinding.ActivityMainBinding
import com.example.eray_altilar_odev_9.model.Products
import com.example.eray_altilar_odev_9.services.IServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var layoutManager: LinearLayoutManager
    lateinit var productAdapter: ProductAdapter
    private var isLoading = false
    private var currentPage = 0
    private val limit = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        productAdapter = ProductAdapter(mutableListOf())
        binding.recyclerView.adapter = productAdapter

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()

                if (!isLoading && pastVisibleItems + visibleItemCount >= totalItemCount) {
                    currentPage++
                    loadMoreItems()
                }
            }
        })
        loadMoreItems()
    }

    private fun loadMoreItems() {
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            val service = ApiClient.getClient().create(IServiceApi::class.java)
            val call = service.getProducts(limit, currentPage * limit)
            call.enqueue(object : Callback<Products> {
                override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                    if (p1.isSuccessful) {
                        val arr = (p1.body()?.products ?: emptyList()).toMutableList()
                        productAdapter.addProducts(arr)
                    }
                    binding.progressBar.visibility = View.GONE
                    isLoading = false
                }

                override fun onFailure(p0: Call<Products>, p1: Throwable) {
                    binding.progressBar.visibility = View.GONE
                    Log.e("getProducts", p1.message!!)
                    isLoading = false
                }
            })
        }, 2000) // 2 seconds delay for demonstration
    }

}
