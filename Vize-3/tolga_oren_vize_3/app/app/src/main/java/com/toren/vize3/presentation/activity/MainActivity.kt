package com.toren.vize3.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.toren.vize3.R
import com.toren.vize3.data.api.UserApi
import com.toren.vize3.data.dto.User
import com.toren.vize3.data.dto.UsersResponse
import com.toren.vize3.data.retrofit.RetrofitClient
import com.toren.vize3.databinding.ActivityMainBinding
import com.toren.vize3.presentation.adapter.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),
    UserAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var apiClient: UserApi
    private val userAdapter = UserAdapter(mutableListOf(), this)
    private var userList: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = userAdapter

        binding.filterButton.setOnClickListener {
            val i = Intent(this, FilterActivity::class.java)
            startActivity(i)
        }

        apiClient = RetrofitClient.getClient().create(UserApi::class.java)

        val popupMenu = PopupMenu(this, binding.sortButton)
        popupMenu.menuInflater.inflate(R.menu.sort_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.nameAsc -> {
                    userList = userList.sortedBy { it.firstName }.toMutableList()
                    updateAdapter(userList)
                    true
                }

                R.id.nameDesc -> {
                    userList = userList.sortedByDescending { it.firstName }.toMutableList()
                    updateAdapter(userList)
                    true
                }
                R.id.ageAsc -> {
                    userList = userList.sortedBy { it.age }.toMutableList()
                    updateAdapter(userList)
                    true
                }
                R.id.ageDesc -> {
                    userList = userList.sortedByDescending { it.age }.toMutableList()
                    updateAdapter(userList)
                    true
                }
                else -> {
                    false
                }
            }
        }
        binding.sortButton.setOnClickListener {
            popupMenu.show()
        }
    }

    override fun onResume() {
        val filter = FilterActivity.filter
        if (filter != null) {
            println("filter: $filter")
            getQueryUsers(filter)
            FilterActivity.filter = null
        } else {
            getUsers()
        }
        super.onResume()
    }

    private fun getUsers() {
        val data = apiClient.getUsers()
        getResponse(data)
    }

    private fun getQueryUsers(query: Pair<String, String>) {
        println(query.first + " " + query.second)
        val data = apiClient.queryUsers(query.first, query.second)
        getResponse(data)
    }

    private fun getResponse(response: Call<UsersResponse>) {
        response.enqueue(object : Callback<UsersResponse> {
            override fun onResponse(p0: Call<UsersResponse>, p1: Response<UsersResponse>) {
                p1.body()?.let {
                    println("Data: $it")
                    userList.clear()
                    userList.addAll(it.users)
                    updateAdapter(it.users.toList())
                    //userAdapter.updateUserList(it.users)
                }
            }

            override fun onFailure(p0: Call<UsersResponse>, p1: Throwable) {
                Log.e("Data", "Error")
            }
        })
    }

    fun updateAdapter(list: List<User>) {
        userAdapter.updateUserList(list)
    }

    override fun onItemClick(position: Int) {
        val user = userList[position]
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra("user", user)
        startActivity(i)
    }


}