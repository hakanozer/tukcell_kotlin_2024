package com.works.days_9


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.works.days_9.adaptors.UserAdaptors
import com.works.days_9.configs.ApiClient
import com.works.days_9.models.Users
import com.works.days_9.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var dummyService: DummyService
    private lateinit var listViewProducts: ListView
    private lateinit var filterButton: ImageView
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var adapter: UserAdaptors
    private val filterRequestCode = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("FilterPrefs", Context.MODE_PRIVATE)
        dummyService = ApiClient.getClient().create(DummyService::class.java)

        listViewProducts = findViewById(R.id.listViewProducts)
        filterButton = findViewById(R.id.filterButton)


        adapter = UserAdaptors(this, ArrayList())
        listViewProducts.adapter = adapter

        kullanicigGetir()

        filterButton.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivityForResult(intent, filterRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == filterRequestCode && resultCode == RESULT_OK) {
            val filters = data?.getSerializableExtra("filters") as HashMap<String, String>?
            filters?.let {
                kullaniciFilter(it)
            }
        }
    }

    private fun kullanicigGetir() {
        dummyService.getUsers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    val users = response.body()?.users ?: emptyList()
                    adapter.clear()
                    adapter.addAll(users)
                    adapter.notifyDataSetChanged()
                } else {
                    Log.e("MainActivity", " response hatası")
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e("MainActivity", "Error users", t)
            }
        })
    }

    private fun kullaniciFilter(filters: HashMap<String, String>) {
        val key = filters.keys.firstOrNull() ?: return//ilk filtre kullanma işlemi
        val value = filters[key] ?: return
        Log.d("MainActivity", "Uyglnana filtre: $key = $value")
        dummyService.getUsersByFilter(key, value).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    val users = response.body()?.users ?: emptyList()
                    adapter.clear()
                    adapter.addAll(users)
                    adapter.notifyDataSetChanged()
                } else {
                    Log.e("MainActivity", "Failed")
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e("MainActivity", "Err", t)
            }
        })
    }
}