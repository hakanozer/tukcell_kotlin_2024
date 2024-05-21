package com.tlh.myapplication8

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.tlh.myapplication8.adapters.UserAdapters
import com.tlh.myapplication8.client.ApiClient
import com.tlh.myapplication8.models.User
import com.tlh.myapplication8.service.DummyService
import com.tlh.myapplication8.ui.DetailsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var dummyService: DummyService
    private lateinit var listViewUsers: ListView
    private lateinit var button: Button

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

        val filteredUser = intent.getSerializableExtra("filteredUsers", User::class.java)

        if (filteredUser != null) {
            val userAdapter = UserAdapters(this, filteredUser.users)
            listViewUsers.adapter = userAdapter
        } else {
            dummyService = ApiClient.getClient().create(DummyService::class.java)
            dummyService.getProducts().enqueue(object : Callback<User> {
                override fun onResponse(p0: Call<User>, p1: Response<User>) {
                    if (p1.isSuccessful) {
                        val userAdapter = UserAdapters(this@MainActivity, p1.body()!!.users)
                        listViewUsers.adapter = userAdapter
                        Log.d("datas", p1.body()!!.users.toString())
                    }
                }

                override fun onFailure(p0: Call<User>, p1: Throwable) {
                    Log.d(TAG, "onFailure: ")
                }
            })

        }

        val adapters = filteredUser?.let { UserAdapters(this, it.users) }
        listViewUsers.adapter = adapters
    }

    override fun onResume() {
        println("onresume")
        super.onResume()

    }
}