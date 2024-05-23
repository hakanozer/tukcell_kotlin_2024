package com.aliberkaygedikoglu.odev9

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aliberkaygedikoglu.odev9.adapter.RecyclerAdapter
import com.aliberkaygedikoglu.odev9.config.ApiClient
import com.aliberkaygedikoglu.odev9.databinding.ActivityMainBinding
import com.aliberkaygedikoglu.odev9.model.Product
import com.aliberkaygedikoglu.odev9.model.Products
import com.aliberkaygedikoglu.odev9.service.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var dummyService: IDummyService
    lateinit var arr: List<Product>
    private var count=0


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
        dummyService = ApiClient.getClient().create(IDummyService::class.java)



        getProducts()




        binding.main.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                // in this method we are incrementing page number,
                // making progress bar visible and calling get data method.
                count++;
                // on below line we are making our progress bar visible.
                binding.idPBLoading.visibility = View.VISIBLE;
                if (count < 20) {
                    // on below line we are again calling
                    // a method to load data in our array list.
                    getProducts();
                }
            }
        })





    }

     private fun getProducts() {

         dummyService.getProducts(10, 0).enqueue(object : Callback<Products> {
             override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                 if (p1.isSuccessful) {
                     arr = p1.body()!!.products
                     Log.d("getAll",arr.toString())
                     val adapter = RecyclerAdapter(arr,this@MainActivity)
                     binding.idRVUsers.layoutManager=LinearLayoutManager(this@MainActivity)
                     binding.idRVUsers.adapter=adapter


                     Log.d("getAll", arr.toString())
                 }
             }

             override fun onFailure(p0: Call<Products>, p1: Throwable) {
                 Log.d("getAll","hata")
             }

         })



    }
}