package com.bengisusahin.vize03_calisma.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bengisusahin.vize03_calisma.R
import com.bengisusahin.vize03_calisma.adapters.UserAdapter
import com.bengisusahin.vize03_calisma.configs.ApiClient
import com.bengisusahin.vize03_calisma.databinding.ActivityMainBinding
import com.bengisusahin.vize03_calisma.models.User
import com.bengisusahin.vize03_calisma.models.Users
import com.bengisusahin.vize03_calisma.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var iDummyService: IDummyService
    private lateinit var userList: List<User>
    private lateinit var userAdapter: UserAdapter
    private lateinit var filterActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // Create the Retrofit service
        iDummyService = ApiClient.getClient().create(IDummyService::class.java)

        getUsers()

        searchUser()

        setFilterActivityResultLauncher()
        // When the "filter" button clicked, the filter page is shown
        binding.buttonFilter.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            filterActivityResultLauncher.launch(intent)
        }
    }

    // Fetch users from the server
    private fun getUsers() {
        iDummyService.getUsers().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    // val usersResponse = response.body()
                    // Log.d("API Response", usersResponse.toString())
                    userList = response.body()!!.users
                    // If the user list is not empty, set up the adapter and list view
                    // Else the user list is empty, show a message to the user
                    if (!userList.isNullOrEmpty()){
                        Log.d("arr", userList.toString())
                        userAdapter = UserAdapter(userList)
                        binding.recyclerView.adapter = userAdapter
                    }else {
                        Toast.makeText(this@MainActivity, "No user found",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<Users>, throwable: Throwable) {
                // Log the error if fetching recipes fails
                Log.e("getUsers", throwable.message!!)
            }
        })
    }

    // Search users based on the given query
    private fun searchUser(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    val query = newText.trim().lowercase()
                    iDummyService.searchUsers(query).enqueue(object : Callback<Users>{
                        override fun onResponse(p0: Call<Users>, res: Response<Users>) {
                            if (res.isSuccessful) {
                                userList = res.body()!!.users
                                userAdapter.updateUsersView(userList)
                            }
                        }
                        override fun onFailure(p0: Call<Users>, err: Throwable) {
                            Log.e("onFailureSearch",err.message.toString())
                        }
                    })
                }
                return true
            }
        })
    }

    // Filters users based on the given key and value
    private fun filterUsers(key: String, value: String) {
        iDummyService.filterUsers(key, value).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    userList = response.body()!!.users
                    if (!userList.isNullOrEmpty()) {
                        userAdapter.updateUsersView(userList)
                    } else {
                        Toast.makeText(this@MainActivity, "No user found",
                            Toast.LENGTH_SHORT).show()
                        userAdapter.updateUsersView(userList)
                    }
                }
            }

            override fun onFailure(call: Call<Users>, throwable: Throwable) {
                Log.e("filterUsers", throwable.message!!)
            }
        })
    }

    // Sets up ActivityResultLauncher for handling filter results
    private fun setFilterActivityResultLauncher() {
        filterActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                if (data != null) {
                    val key = data.getStringExtra("key")
                    val value = data.getStringExtra("value")

                    if (key != null && value != null) {
                        filterUsers(key, value)
                    }
                }
            } else {
                getUsers()
            }
        }
    }
}