package com.ns.enesarisoy_odev9

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ns.enesarisoy_odev9.adapters.ProductAdapter
import com.ns.enesarisoy_odev9.configs.ApiClient
import com.ns.enesarisoy_odev9.databinding.ActivityMainBinding
import com.ns.enesarisoy_odev9.model.Product
import com.ns.enesarisoy_odev9.model.ProductResponse
import com.ns.enesarisoy_odev9.service.ProductService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter
    private var products = mutableListOf<Product>()
    private var isLoading = false
    private var limit = 10
    private var skip = 0
    private var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adapter = ProductAdapter(products)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    if (products.size < total) {
                        loadMoreProducts()
                    }
                }
            }
        })

        loadMoreProducts()

    }

    private fun loadMoreProducts() {
        isLoading = true
        adapter.addLoadingFooter()

        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)

            val apiClient = ApiClient.getClient().create(ProductService::class.java)
            val call = apiClient.getProducts(limit, skip)

            call.enqueue(object : Callback<ProductResponse> {
                override fun onResponse(
                    call: Call<ProductResponse>,
                    response: Response<ProductResponse>
                ) {
                    adapter.removeLoadingFooter()
                    if (response.isSuccessful) {
                        response.body()?.let {
                            products.addAll(it.products)
                            adapter.addProducts(it.products)
                            skip += limit
                            total = it.total
                        }
                    }
                    isLoading = false
                }

                override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                    adapter.removeLoadingFooter()
                    // Handle error
                    isLoading = false
                }
            })
        }
    }
}