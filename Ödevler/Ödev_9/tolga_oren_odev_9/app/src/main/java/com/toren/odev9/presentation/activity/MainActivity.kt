package com.toren.odev9.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.toren.odev9.R
import com.toren.odev9.data.remote.retrofit.RetrofitClient
import com.toren.odev9.common.Constants
import com.toren.odev9.data.remote.api.ProductApi
import com.toren.odev9.data.remote.dto.ProductsDto
import com.toren.odev9.databinding.ActivityMainBinding
import com.toren.odev9.presentation.adapter.ProductAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val productAdapter = ProductAdapter(mutableListOf())
    private var pagination = 0
    private lateinit var service: ProductApi
    private var isLoading = false

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

        binding.productRecyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        binding.productRecyclerView.adapter = productAdapter

        service = RetrofitClient.getClient().create(ProductApi::class.java)

        binding.productRecyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as GridLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (!isLoading && visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                    loadData()
                }
            }
        })

        loadData()

    }

    fun loadData() {
        isLoading = true
        val data = service.getProducts(Constants.limit, pagination)

        data.enqueue(object : Callback<ProductsDto> {
            override fun onResponse(p0: Call<ProductsDto>, p1: Response<ProductsDto>) {
                if (p1.isSuccessful) {
                    isLoading = false
                    pagination += 10
                    val products = p1.body()?.products
                    products?.let { productAdapter.updateProducts(it) }
                }
            }

            override fun onFailure(p0: Call<ProductsDto>, p1: Throwable) {
                isLoading = false
                Log.e("Error", p1.message.toString())
            }

        })

    }

}