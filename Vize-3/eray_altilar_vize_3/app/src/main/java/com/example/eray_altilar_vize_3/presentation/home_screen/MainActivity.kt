package com.example.eray_altilar_vize_3.presentation.home_screen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eray_altilar_vize_3.R
import com.example.eray_altilar_vize_3.core.Resource
import com.example.eray_altilar_vize_3.databinding.ActivityMainBinding
import com.example.eray_altilar_vize_3.presentation.filter_screen.FilterActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            viewModel.users.collect { users ->
                when (users) {
                    is Resource.Success -> {
                        adapter = users.data?.let { UserAdapter(it) }!!
                        recyclerView.adapter = adapter

                    }
                    is Resource.Error -> {
                        Toast.makeText(this@MainActivity, users.message, Toast.LENGTH_SHORT).show()
                    }

                    is Resource.Loading -> {
                        Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            }

            binding.filterButton.setOnClickListener {
                intent = Intent(this, FilterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
