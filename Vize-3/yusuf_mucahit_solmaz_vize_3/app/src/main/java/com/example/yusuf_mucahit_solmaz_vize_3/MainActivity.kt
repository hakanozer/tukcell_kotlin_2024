package com.example.yusuf_mucahit_solmaz_vize_3

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity.RootResponse
import com.example.yusuf_mucahit_solmaz_vize_3.databinding.ActivityMainBinding
import com.example.yusuf_mucahit_solmaz_vize_3.presentation.adapter.UserAdapter
import com.example.yusuf_mucahit_solmaz_vize_3.presentation.ui.FilterActivity
import com.example.yusuf_mucahit_solmaz_vize_3.presentation.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private var filteredUser: RootResponse? = null
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.recyclerView2.layoutManager = LinearLayoutManager(this)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.users.observe(this, Observer { users ->
            users?.let {
                val adapter = UserAdapter(it,this@MainActivity)
                binding.recyclerView2.adapter = adapter
            }
        })



        binding.floatingActionButton2.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }

        filteredUser = intent.getSerializableExtra("filteredUsers") as? RootResponse

        if (filteredUser != null) {
            Log.d("MainActivity", "Filtered User: $filteredUser")
            userViewModel.users.value = filteredUser?.users
        } else {
            userViewModel.fetchUsers()
        }
    }
}
