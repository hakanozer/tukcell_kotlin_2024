package com.beyzaparlak.beyza_parlak_vize_3

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
import com.beyzaparlak.beyza_parlak_vize_3.adapter.ProductAdapter
import com.beyzaparlak.beyza_parlak_vize_3.configs.ApiClient
import com.beyzaparlak.beyza_parlak_vize_3.modell.User
import com.beyzaparlak.beyza_parlak_vize_3.modell.UserX
import com.beyzaparlak.beyza_parlak_vize_3.service.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var listViewProducts: ListView
    lateinit var arr: List<UserX>
    lateinit var filterButton: Button

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

        // butona tıklandığında intent çağırdım
        filterButton.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }

        val filteredUser = intent.getSerializableExtra("filteredUsers", User::class.java)

        // filteredUser null kontrolü
        if (filteredUser != null) {
            val adapter = ProductAdapter(this@MainActivity, filteredUser.users)
            listViewProducts.adapter = adapter
        } else {
            // filteredUser dolu ise dataları getiriyorum
            dummyService = ApiClient.getClient().create(DummyService::class.java)
            dummyService.getProducts().enqueue(object : Callback<User> {
                override fun onResponse(p0: Call<User>, p1: Response<User>) {
                    if (p1.isSuccessful) {
                        arr = p1.body()!!.users
                        val adapter = ProductAdapter(this@MainActivity, arr)
                        listViewProducts.adapter = adapter
                    }
                }
                override fun onFailure(p0: Call<User>, p1: Throwable) {
                    Log.e("getProduct", p1.message!! )
                }
            })
        }

        val adapter = filteredUser?.let {
            ProductAdapter(this, it.users)
        }
        listViewProducts.adapter = adapter

    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onResume() {
        println("onResume call")
        super.onResume()
    }
}