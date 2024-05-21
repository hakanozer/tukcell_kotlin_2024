package com.example.omer_faruk_arslan_vize_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.omer_faruk_arslan_vize_3.adapter.UserAdapter
import com.example.omer_faruk_arslan_vize_3.config.ApiClient
import com.example.omer_faruk_arslan_vize_3.models.User
import com.example.omer_faruk_arslan_vize_3.models.Users
import com.example.omer_faruk_arslan_vize_3.service.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var dummyService: IDummyService
    lateinit var listViewUsers: ListView
    lateinit var imgFilter: ImageView
    lateinit var array: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listViewUsers = findViewById(R.id.listViewUsers)
        imgFilter = findViewById(R.id.imgFilter)

        // ListView için tıklama işlemini burada tanımla
        listViewUsers.setOnItemClickListener { parent, view, position, id ->
            val selectedUser = array[position]
            val intent = Intent(this, UserDetailActivity::class.java).apply {
                putExtra("name", selectedUser.firstName)
                putExtra("age", selectedUser.age.toString())
                putExtra("gender", selectedUser.gender)
                putExtra("hairType", selectedUser.hair.toString())
                putExtra("bloodGroup", selectedUser.bloodGroup)
                putExtra("eyeColor", selectedUser.eyeColor)
                putExtra("height", selectedUser.height)
                putExtra("weight", selectedUser.weight)
            }
            startActivity(intent)
        }

        // Diğer işlemler devam eder...
        dummyService = ApiClient.getClient().create(IDummyService::class.java)
        val filterKey = intent.getStringExtra("filterKey")
        val filterValue = intent.getStringExtra("filterValue")

        // Filtreleme işlemi
        if (filterKey != null && filterValue != null) {
            filterUsers(filterKey, filterValue)
        } else {
            getUsers()
        }

        imgFilter.setOnClickListener {
            val intent = Intent(this@MainActivity, FilterActivity::class.java)
            startActivity(intent)
        }
    }

    // Bütün kullanıcıları getirme fonksiyonu
    private fun getUsers() {
        dummyService.getUsers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    array = response.body()!!.users
                    Log.d("users", array.toString())
                    val userAdapters = UserAdapter(this@MainActivity, array)
                    listViewUsers.adapter = userAdapters
                } else {
                    Log.e("error", response.message().toString())
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
        })
    }

    // Filtrelenmiş kullanıcıları getirme fonksiyonu
    private fun filterUsers(key: String, value: String) {
        dummyService.filterUsers(key, value).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    array = response.body()!!.users
                    Log.d("users", array.toString())
                    val userAdapters = UserAdapter(this@MainActivity, array)
                    listViewUsers.adapter = userAdapters
                } else {
                    Log.e("error", "Response unsuccessful: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
        })
    }
}
