package com.works.days_9

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.days_9.adaptors.ProductAdaptors
import com.works.days_9.configs.ApiClient
import com.works.days_9.models.Product
import com.works.days_9.models.Products
import com.works.days_9.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var listViewProducts: ListView
    lateinit var arr: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listViewProducts = findViewById(R.id.listViewProducts)

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        dummyService.getProducts().enqueue(object : Callback<Products> {
            override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                if (p1.isSuccessful) {
                    arr = p1.body()!!.products
                    val productAdaptors = ProductAdaptors(this@MainActivity, arr)
                    listViewProducts.adapter = productAdaptors
                    Log.d("datas", arr.toString())
                }
            }

            override fun onFailure(p0: Call<Products>, p1: Throwable) {
                Log.e("getProducts", p1.message!! )
            }
        } )


        /*
        listViewProducts.setOnItemClickListener { parent, view, position, id ->
            Log.d("i", position.toString())
        }
         */


    }


}