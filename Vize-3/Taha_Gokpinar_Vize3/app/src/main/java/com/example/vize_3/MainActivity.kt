package com.example.vize_3

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vize_3.adaptors.UserAdapter
import com.example.vize_3.configs.ApiClient
import com.example.vize_3.databinding.ActivityMainBinding
import com.example.vize_3.models.User
import com.example.vize_3.models.Users
import com.example.vize_3.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var dummyService: DummyService
    lateinit var arr: List<User>
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferences = getSharedPreferences("FilterPreferences", Context.MODE_PRIVATE)
        dummyService = ApiClient.getClient().create(DummyService::class.java)

        binding.btnFilter.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onResume(){
        super.onResume()
        filteredData()
    }

    override fun onStop() {
        super.onStop()
        sharedPreferences.edit().clear().commit()
    }

    fun getAllUsers(){
        dummyService.getUsers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if(response.isSuccessful){
                    val adapter = UserAdapter(this@MainActivity, response.body()!!.users)
                    binding.listViewUsers.adapter = adapter
                    binding.textViewTitle.text = "USERS"
                }
            }

            override fun onFailure(call: Call<Users>, err: Throwable) {
                Log.e("getUsers", err.message!! )
            }
        })
    }

    fun getFilteredUsers(key: String, value: String){
        dummyService.getUsersByFilter(key, value).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    val adapter = UserAdapter(this@MainActivity, response.body()!!.users)
                    binding.listViewUsers.adapter = adapter
                    binding.textViewTitle.text = "FILTERED USERS"
                }
            }

            override fun onFailure(call: Call<Users>, err: Throwable) {
                Log.e("getUsersByFilter", err.message!!)
            }
        })
    }

    fun filteredData(){
        val firstName = sharedPreferences.getString("firstName", "")
        val lastName = sharedPreferences.getString("lastName", "")
        val age = sharedPreferences.getString("age", "")
        val bloodGroup = sharedPreferences.getString("bloodGroup", "")

        when {
            !firstName.isNullOrEmpty() -> {
                getFilteredUsers("firstName", firstName)
            }
            !lastName.isNullOrEmpty() -> {
                getFilteredUsers("lastName", lastName)
            }
            !age.isNullOrEmpty() -> {
                getFilteredUsers("age", age)
            }
            !bloodGroup.isNullOrEmpty() -> {
                getFilteredUsers("bloodGroup", bloodGroup)
            }
            else -> {
                getAllUsers()
            }
        }
    }
}