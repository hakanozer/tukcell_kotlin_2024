package com.yeceylan.yunusemreceylan_snav3.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeceylan.yunusemreceylan_snav3.data.model.User
import com.yeceylan.yunusemreceylan_snav3.databinding.ActivityMainBinding
import com.yeceylan.yunusemreceylan_snav3.presentation.filter.FilterActivity
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val searchUsers = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        setupViewModel()
        observeViewModel()

        intent.getSerializableExtra("filteredUsers")?.let {
            val filteredUsers = it as ArrayList<User>
            if (filteredUsers.isNotEmpty()) {
                viewModel.setFilteredUsers(filteredUsers)
                searchUsers.addAll(filteredUsers)
            } else {
                viewModel.fetchUsers()
            }
        } ?: run {
            viewModel.fetchUsers()
        }
    }

    private fun setupViews() {
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(emptyList())
        binding.recyclerViewUsers.adapter = userAdapter

        binding.buttonFilter.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.searchUsers(it,searchUsers)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.searchUsers(it,searchUsers)
                }
                return false
            }
        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun observeViewModel() {
        viewModel.usersLiveData.observe(this, Observer { users ->
            users?.let {
                userAdapter.updateUsers(it)
                searchUsers.addAll(it)
            }
        })
    }
}

