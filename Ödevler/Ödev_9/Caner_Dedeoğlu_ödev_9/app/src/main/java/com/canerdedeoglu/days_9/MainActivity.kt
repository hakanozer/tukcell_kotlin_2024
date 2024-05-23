package com.canerdedeoglu.days_9

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.ListView
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.canerdedeoglu.days_9.adaptors.ProductAdaptors
import com.canerdedeoglu.days_9.configs.ApiClient
import com.canerdedeoglu.days_9.models.Product
import com.canerdedeoglu.days_9.services.IDummyService
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var dummyService: IDummyService
    private lateinit var listViewProducts: ListView
    private lateinit var progressBar: ProgressBar
    private lateinit var productArray: MutableList<Product>
    private lateinit var productAdaptors: ProductAdaptors
    private var isLoad = false
    private var skip = 0
    private val limit = 10
    private var totalProducts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        listViewProducts = findViewById(R.id.listViewProducts)
        progressBar = findViewById(R.id.progressBar)

        productArray = mutableListOf()
        productAdaptors = ProductAdaptors(this@MainActivity, productArray)
        listViewProducts.adapter = productAdaptors

        dummyService = ApiClient.getClient().create(IDummyService::class.java)

        loadInitialData()

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
                if (view != null && totalItemCount == firstVisibleItem + visibleItemCount && !isLoad && productArray.size < totalProducts) {
                    loadMoreData()
                }
            }
        })
    }

    // Başlangıç verilerini yükle
    private fun loadInitialData() {
        loadProducts(skip, limit)
    }
    // Daha fazla veri yüklemek için
    private fun loadMoreData() {
        isLoad = true
        progressBar.visibility = ProgressBar.VISIBLE
        loadProducts(skip, limit)
    }
    // Belirli bir aralıktaki ürünleri API'den yükleme
    private fun loadProducts(skip: Int, limit: Int) {
        lifecycleScope.launch {
            try {
                val response = dummyService.getProducts(skip, limit)
                productArray.addAll(response.products)
                productAdaptors.notifyDataSetChanged()
                progressBar.visibility = ProgressBar.GONE
                this@MainActivity.skip += limit
                this@MainActivity.totalProducts = response.total.toInt()
                isLoad = false
            } catch (e: IOException) {
                Log.e("Error", "Network hatası: ${e.message}")
            } catch (e: HttpException) {
                Log.e("Error", "HTTP hatası: ${e.message()}")
            }
        }
    }
}
