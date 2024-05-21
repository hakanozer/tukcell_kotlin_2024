package com.sercancelik.vize_3_sercan_celik

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sercancelik.vize_3_sercan_celik.adapter.UserAdapter
import com.sercancelik.vize_3_sercan_celik.configs.RetrofitClient
import com.sercancelik.vize_3_sercan_celik.models.User
import com.sercancelik.vize_3_sercan_celik.models.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private var dataList: List<User> = listOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonFilter: Button
    private lateinit var findedCount: TextView
    private lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)
        buttonFilter = findViewById(R.id.buttonFilter)
        findedCount = findViewById(R.id.findedCount)
        progressBar = findViewById(R.id.progressBar)

        adapter = UserAdapter(this, dataList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        fetchData()

        buttonFilter.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            filterLauncher.launch(intent)
        }

    }

    private fun fetchData() {
        isLoading()
        RetrofitClient.apiService.getData().enqueue(object : Callback<UserResponse> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                isLoaded()
                if (response.isSuccessful) {
                    dataList = response.body()?.users ?: listOf()
                    findedCount.text = "Findeded friends count: ${dataList.size}"
                    adapter.updateData(dataList)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                isLoaded()
                // Handle error
            }
        })
    }

    private fun fetchDataFilter(filter: Pair<String, String>) {
        isLoading()
        val (key, value) = filter
        RetrofitClient.apiService.filterUsers(key, value).enqueue(object : Callback<UserResponse> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                isLoaded()
                if (response.isSuccessful) {
                    dataList = response.body()?.users ?: listOf()
                    findedCount.text = "Findeded friends count: ${dataList.size}"
                    adapter.updateData(dataList)
                    if (dataList.isEmpty()) {
                        Toast.makeText(applicationContext, "No friends found.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                isLoaded()
            }
        })
    }

    private val filterLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val key = result.data?.getStringExtra(EXTRA_FILTER_KEY) ?: ""
                val value = result.data?.getStringExtra(EXTRA_FILTER_VALUE) ?: ""
                val filter = Pair(key, value)
                fetchDataFilter(filter)
            }
        }

    companion object {
        const val EXTRA_FILTER_KEY = "EXTRA_FILTER_KEY"
        const val EXTRA_FILTER_VALUE = "EXTRA_FILTER_VALUE"
    }

    private fun isLoading() {
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        findedCount.visibility = View.GONE
        buttonFilter.visibility = View.GONE
    }

    private fun isLoaded() {
        recyclerView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        findedCount.visibility = View.VISIBLE
        buttonFilter.visibility = View.VISIBLE
    }
}
