package com.umutyusufcinar.vize3app

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umutyusufcinar.vize3app.adapter.ProductAdapter
import com.umutyusufcinar.vize3app.configs.ApiClient
import com.umutyusufcinar.vize3app.model.Product
import com.umutyusufcinar.vize3app.model.Products
import com.umutyusufcinar.vize3app.model.User
import com.umutyusufcinar.vize3app.model.UserX
import com.umutyusufcinar.vize3app.service.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var listViewProducts: ListView
    lateinit var arr: List<Product>
    lateinit var filterButton: Button
    var a: String = "a"


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listViewProducts = findViewById(R.id.listViewProducts)
        filterButton = findViewById(R.id.button)

        //Filtre sayfasına giden butonun kodudur
        filterButton.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }


        val filteredUser = intent.getSerializableExtra("filteredUsers", User::class.java)

        //Aktivitenin filtreleme mi yoksa ana sayfa olduğunu gösteren sorgudur
        if (filteredUser != null) {
            val adapter = ProductAdapter(this@MainActivity, filteredUser.users)
            listViewProducts.adapter = adapter
        } else {
            dummyService = ApiClient.getClient().create(DummyService::class.java)
            dummyService.getProducts().enqueue(object : Callback<User> {
                override fun onResponse(p0: Call<User>, p1: Response<User>) {
                    if (p1.isSuccessful) {

                        val adapter = ProductAdapter(this@MainActivity, p1.body()!!.users)
                        listViewProducts.adapter = adapter
                    }
                }

                override fun onFailure(p0: Call<User>, p1: Throwable) {
                    // sonar comment
                }
            })
        }

        val adapter = filteredUser?.let { ProductAdapter(this, it.users) }
        listViewProducts.adapter = adapter
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onResume() {
        println("onResume")
        super.onResume()
    }
}