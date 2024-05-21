package com.emrecura.vize_3

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.emrecura.vize_3.configs.ApiClient
import com.emrecura.vize_3.configs.adapter.UserAdapter
import com.emrecura.vize_3.models.Users
import com.emrecura.vize_3.services.DummyService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var dummyService: DummyService
    lateinit var listViewUsers: ListView
    lateinit var filterButton: Button
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupDummyService()
        setupResultLauncher()
    }

    private fun setupViews() {
        listViewUsers = findViewById(R.id.listViewUsers)
        filterButton = findViewById(R.id.button)
        filterButton.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun setupDummyService() {
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        loadInitialData()
    }

    private fun loadInitialData() {
        dummyService.getUsers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    userAdapter = UserAdapter(this@MainActivity, response.body()!!.users)
                    listViewUsers.adapter = userAdapter
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e("MainActivity", "Error fetching users", t)
            }
        })
    }

    private fun setupResultLauncher() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val filterKey = result.data?.getStringExtra("filterKey")
                val filterValue = result.data?.getStringExtra("filterValue")
                updateAdapterWithFilter(filterKey, filterValue)

            }
        }
    }

    private fun updateAdapterWithFilter(key: String?, value: String?) {
        if (key.isNullOrEmpty() || value.isNullOrEmpty()) {
            loadInitialData() //Eğer tüm filtereler boş ise tüm user'ı yükler
        } else {
            // Filtre değerleri geçerli ise filtreli verileri yükler
            dummyService.getUsersByFilter(key, value).enqueue(object : Callback<Users> {
                override fun onResponse(call: Call<Users>, response: Response<Users>) {
                    if (response.isSuccessful) {
                        userAdapter.clear()
                        userAdapter.addAll(response.body()!!.users)
                        userAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<Users>, t: Throwable) {
                    Log.e("MainActivity", "Error fetching filtered users", t)
                }
            })
        }
    }

}
