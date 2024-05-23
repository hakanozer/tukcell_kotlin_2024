package com.muratdayan.odev9.presentation.main_screen

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muratdayan.odev9.R
import com.muratdayan.odev9.databinding.ActivityMainBinding
import com.muratdayan.odev9.presentation.adapters.ProductAdapter
import com.muratdayan.odev9.presentation.components.CustomToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.progressBar.visibility = View.VISIBLE
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setUpRecyclerView()
        collectProductState()
        setUpScrollListener()
        mainViewModel.getAllProductsByQuery(10, 0)
    }

    private fun setUpRecyclerView() {
        binding.rvProduct.setHasFixedSize(true)
        binding.rvProduct.layoutManager = LinearLayoutManager(this)
        productAdapter = ProductAdapter(mutableListOf())
        binding.rvProduct.adapter = productAdapter
    }

    private fun collectProductState() {
        lifecycleScope.launch {
            mainViewModel.productState.collectLatest { productState ->
                when {
                    productState.products?.isNotEmpty() == true -> {
                        productAdapter.addProducts(productState.products)
                        binding.progressBar.visibility = View.GONE
                    }

                    productState.isLoading -> {
                        CustomToast(this@MainActivity, "Loading...", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        CustomToast(
                            this@MainActivity,
                            productState.errorMsg.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.d("failure", "failure ${productState.errorMsg}")
                    }
                }
            }
        }
    }

    private fun setUpScrollListener() {
        binding.rvProduct.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager

                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                    mainViewModel.loadMoreProducts()
                }
            }
        })
    }
}