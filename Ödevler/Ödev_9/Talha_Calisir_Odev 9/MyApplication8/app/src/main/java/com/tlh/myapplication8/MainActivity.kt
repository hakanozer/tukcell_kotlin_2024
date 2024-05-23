package com.tlh.myapplication8

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.AbsListView
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.tlh.myapplication8.adapters.UserAdapters
import com.tlh.myapplication8.client.ApiClient
import com.tlh.myapplication8.models.User
import com.tlh.myapplication8.models.Users
import com.tlh.myapplication8.service.DummyService
import com.tlh.myapplication8.ui.DetailsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var dummyService: DummyService
    private lateinit var listViewUsers: ListView
    private lateinit var button: Button
    private lateinit var userAdapter: UserAdapters
    private var userList = mutableListOf<Users>()
    private var limit = 10
    private var skip = 0
    private var isLoading = false

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listViewUsers = findViewById(R.id.listView)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        userAdapter = UserAdapters(this, userList)
        listViewUsers.adapter = userAdapter

        val filteredUser = intent.getSerializableExtra("filteredUsers", User::class.java)
        if (filteredUser != null) {
            userList.addAll(filteredUser.users)
            userAdapter.notifyDataSetChanged()
        } else {
            loadUsers()
        }

        listViewUsers.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
           
            }

            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (!isLoading && firstVisibleItem + visibleItemCount >= totalItemCount) {
                    loadUsers()
                }
            }
        })
    }

    private fun loadUsers() {
        isLoading = true
        dummyService.getProducts(limit, skip).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val users = response.body()?.users ?: emptyList()
                    userAdapter.addUsers(users)
                    skip += limit
                }
                isLoading = false
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
                isLoading = false
            }
        })
    }
}