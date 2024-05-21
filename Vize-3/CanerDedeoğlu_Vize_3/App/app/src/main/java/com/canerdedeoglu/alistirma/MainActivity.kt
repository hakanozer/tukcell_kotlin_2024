package com.canerdedeoglu.alistirma

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.canerdedeoglu.alistirma.adapter.UserAdapter
import com.canerdedeoglu.alistirma.config.ApiClient
import com.canerdedeoglu.alistirma.models.User
import com.canerdedeoglu.alistirma.models.Users
import com.canerdedeoglu.alistirma.service.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var dummyService: IDummyService
    lateinit var userArray: List<User>
    lateinit var listViewUsers: ListView
    private lateinit var filterImage: ImageView
    private lateinit var resetImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        filterImage = findViewById(R.id.filter_image)
        listViewUsers = findViewById(R.id.listViewUsers)
        resetImage = findViewById(R.id.resetImage)
        dummyService = ApiClient.getClient().create(IDummyService::class.java)

        // Filter Activity'den gelen verileri al
        val filterKey = intent.getStringExtra("filterKey")
        val filterValue = intent.getStringExtra("filterValue")

        // Filtreleme işlemi
        if (filterKey != null && filterValue != null) {
            filterUsers(filterKey, filterValue)
        } else {
            getUsers()
        }
        listViewUsers.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedUser = userArray[position]
            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra("user", selectedUser)
            startActivity(intent)
        }

        filterImage.setOnClickListener {
            val i = Intent(this@MainActivity, FilterActivity::class.java)
            startActivity(i)
        }
        resetImage.setOnClickListener {
            getUsers()
        }
    }

    // Bütün kullanıcıları getirme fonksiyonu
    private fun getUsers() {
        dummyService.getUsers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    userArray = response.body()!!.users
                    Log.d("users", userArray.toString())
                    val userAdapters = UserAdapter(this@MainActivity, userArray)
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

    // Filtrelenmiş kullanıcaları getirme fonksiyonu
    private fun filterUsers(key: String, value: String) {
        dummyService.filterUsers(key, value).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    userArray = response.body()!!.users
                    Log.d("users", userArray.toString())
                    val userAdapters = UserAdapter(this@MainActivity, userArray)
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
