package com.example.yusuf_mucahit_solmaz_odev_9

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yusuf_mucahit_solmaz_odev_9.core.utils.Resource
import com.example.yusuf_mucahit_solmaz_odev_9.databinding.ActivityMainBinding
import com.example.yusuf_mucahit_solmaz_odev_9.ui.adapter.ProductAdapter
import com.example.yusuf_mucahit_solmaz_odev_9.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ProductViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productAdapter = ProductAdapter(mutableListOf(),this@MainActivity)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }

        viewModel.products.observe(this, Observer { resource ->
            when (resource) {
                is Resource.Loading -> {
                    productAdapter.addLoadingFooter()
                }
                is Resource.Success -> {
                    productAdapter.removeLoadingFooter()
                    productAdapter.addProducts(resource.data ?: emptyList())
                }
                is Resource.Error -> {
                    productAdapter.removeLoadingFooter()
                    // Hata mesajını göster
                }
            }
        })

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

                if (viewModel.products.value !is Resource.Loading && lastVisibleItemPosition + 1 >= totalItemCount) {
                    viewModel.loadProducts()
                }
            }
        })
    }
}