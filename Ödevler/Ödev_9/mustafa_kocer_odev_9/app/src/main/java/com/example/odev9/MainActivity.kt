package com.example.odev9

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev9.adapters.ProductAdapter
import com.example.odev9.configs.ApiClient
import com.example.odev9.databinding.ActivityMainBinding
import com.example.odev9.models.Product
import com.example.odev9.models.ProductsData
import com.example.odev9.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var itemList = mutableListOf<Product>()
    private val limitProducts = 10
    private var skipProducts = 0
    private val iDummyService = ApiClient.getClient().create(IDummyService::class.java)
    private var stopFLag = true
    private var waitFlag = false
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productAdapter = ProductAdapter(this@MainActivity, itemList)
        binding.listViewProducts.adapter = productAdapter
        getProductsByFilter(limitProducts.toString(), skipProducts.toString())
        // veriyi 1 kere cekiyor

        binding.listViewProducts.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

                if (view != null && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    val firstVisibleItem = view.firstVisiblePosition
                    val visibleItemCount = view.childCount
                    val temp = firstVisibleItem + visibleItemCount

                    if ((stopFLag == true) && (temp >= skipProducts) && (waitFlag == false)) {
                        waitFlag = true
                        // veriler cekilene kadar birden cok istek atmasini engelliyor
                        getProductsByFilter(limitProducts.toString(), skipProducts.toString())
                    }
                }
            }

            override fun onScroll(
                view: AbsListView?,
                firstVisibleItem: Int,
                visibleItemCount: Int,
                totalItemCount: Int
            ) {
            }
        })

    } // End of OnCreate


    private fun getProductsByFilter(limit: String, skip: String) {

        iDummyService.getProductsByLimit(limit, skip)
            .enqueue(object : Callback<ProductsData> {
                override fun onResponse(p0: Call<ProductsData>, p1: Response<ProductsData>) {

                    p1.body()?.let {
                        val recivedModel = p1.body()
                        val totalItemsInApi = recivedModel!!.total
                        stopFLag = totalItemsInApi > skipProducts
                        if (stopFLag) {
                            // eger stopFlag = false olursa scrool ne kadar kayarsa kaysın, istek
                            // atmayi birakacagim cunku api'dew daha fazla veri yok
                            itemList.addAll(recivedModel.products.toMutableList())
                            runOnUiThread {
                                val position = binding.listViewProducts.firstVisiblePosition
                                productAdapter.notifyDataSetChanged()
                                binding.listViewProducts.setSelection(position)
                            }
                            skipProducts = skipProducts + limitProducts
                            // sonraki veriyi alması icin skipProducts'ı arttırıyorum
                            waitFlag = false
                        }
                    }
                }// onResponse--

                override fun onFailure(p0: Call<ProductsData>, p1: Throwable) {
                    Log.e("onFailure", "onFailure!!! ex: ${p1.stackTrace}")
                }
            })
    } // getProductsByFilter

} // MainActivity