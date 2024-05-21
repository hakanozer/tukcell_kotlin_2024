package com.example.melihcakmak_vize3

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.melihcakmak_vize3.adaptors.ProductAdaptors
import com.example.melihcakmak_vize3.configs.ApiClient
import com.example.melihcakmak_vize3.databinding.ActivityMainBinding
import com.example.melihcakmak_vize3.models.User
import com.example.melihcakmak_vize3.models.Users
import com.example.melihcakmak_vize3.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService
    private lateinit var binding: ActivityMainBinding
    lateinit var arr: List<User>
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("FilterPrefs", Context.MODE_PRIVATE)


        binding.btnGoFilter.setOnClickListener {
            val intent= Intent(this,FilterScreen::class.java)
            startActivity(intent)
        }

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        loadUsers()


    }

    private fun loadUsers() {
        dummyService.getUsers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    arr = response.body()!!.users
                    val productAdaptors = ProductAdaptors(this@MainActivity, arr)
                    binding.listViewProducts.adapter = productAdaptors
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e("MainActivity", "Failed to load users", t)
            }
        })
    }

    private fun loadFilteredUsers(key: String, value: String) {
        dummyService.getUsersByFilter(key, value).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    arr = response.body()!!.users
                    val productAdaptors = ProductAdaptors(this@MainActivity, arr)
                    binding.listViewProducts.adapter = productAdaptors
                    if(arr.isEmpty()){
                        showPopup()
                    }
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e("MainActivity", "Failed to load filtered users", t)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        // Filtreleme yapılacak mı kontrol ediyoruz
        val filterKey = sharedPreferences.getString("filter_key", "")
        val filterValue = sharedPreferences.getString("filter_value", "")

        if (filterKey.isNullOrEmpty() || filterValue.isNullOrEmpty()) {
            loadUsers()
        } else {
            loadFilteredUsers(filterKey, filterValue)
        }

    }

    private fun showPopup() {
        AlertDialog.Builder(this)
            .setTitle("No Results")
            .setMessage("Filter result is empty")
            .setPositiveButton(android.R.string.ok) { dialog, _ -> dialog.dismiss() }
            .show()
    }





}


