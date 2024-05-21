package com.tlh.vize3

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tlh.vize3.adapters.UserAdapter
import com.tlh.vize3.databinding.ActivityMainBinding
import com.tlh.vize3.ui.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel: UserViewModel by viewModels()
    val adapter = UserAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView setup is moved to MainFragment
        viewModel.users.observe(this) { users ->
            adapter.updateData(users)
        }
    }
}
