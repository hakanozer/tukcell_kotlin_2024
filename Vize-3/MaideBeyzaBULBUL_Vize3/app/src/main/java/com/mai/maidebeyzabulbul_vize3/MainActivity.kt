package com.mai.maidebeyzabulbul_vize3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mai.days9.configs.ApiClient
import com.mai.maidebeyzabulbul_vize3.adapter.UserAdapter
import com.mai.maidebeyzabulbul_vize3.models.User
import com.mai.maidebeyzabulbul_vize3.models.Users
import com.mai.maidebeyzabulbul_vize3.services.DummyServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var userAdapter: UserAdapter
    private lateinit var users: List<User>
    private lateinit var filterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.userListView)
        filterButton = findViewById(R.id.filterButton)
        users = ArrayList()

        getUsers()

        filterButton.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivityForResult(intent, 1)
        }

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedUser = users[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("user", selectedUser)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val filterKey = data?.getStringExtra("filterKey")
            val filterValue = data?.getStringExtra("filterValue")

            if (filterKey != null && filterValue != null) {
                filterUsers(filterKey, filterValue)
            }
        }
    }

    private fun getUsers() {
        val apiService = ApiClient.getClient().create(DummyServices::class.java)
        val call = apiService.getUsers()

        call.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    users = response.body()?.users ?: emptyList()
                    userAdapter = UserAdapter(this@MainActivity, users)
                    listView.adapter = userAdapter
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to load users", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun filterUsers(key: String, value: String) {
        val apiService = ApiClient.getClient().create(DummyServices::class.java)
        val call = apiService.filterUsers(key, value)

        call.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    users = response.body()?.users ?: emptyList()
                    userAdapter = UserAdapter(this@MainActivity, users)
                    listView.adapter = userAdapter
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to filter users", Toast.LENGTH_SHORT).show()
            }
        })
    }
}