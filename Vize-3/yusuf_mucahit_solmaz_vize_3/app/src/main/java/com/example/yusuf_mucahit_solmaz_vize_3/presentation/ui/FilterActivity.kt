package com.example.yusuf_mucahit_solmaz_vize_3.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.yusuf_mucahit_solmaz_vize_3.MainActivity
import com.example.yusuf_mucahit_solmaz_vize_3.R
import com.example.yusuf_mucahit_solmaz_vize_3.databinding.ActivityFilterBinding
import com.example.yusuf_mucahit_solmaz_vize_3.presentation.viewModel.FilterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup

    private val filterViewModel: FilterViewModel by viewModels()
    private lateinit var binding: ActivityFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        radioGroup = findViewById(R.id.radioGroup)

        setSupportActionBar(binding.toolbar)


        binding.btnFilter.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
                val filterKey = selectedRadioButton.text.toString()
                val filterValue = binding.editTextFilterValue.text.toString()

                filterViewModel.fetchUsersByKeyAndValue(filterKey, filterValue)
            } else {
                Log.d("FilterActivity", "No filter key selected")
            }
        }

        filterViewModel.filteredUsers.observe(this, Observer { response ->
            if (response!!.users.isNotEmpty()) {
                Log.d("FilterActivity", "Filtered users: $response")

                val intent = Intent(this@FilterActivity, MainActivity::class.java)
                intent.putExtra("filteredUsers", response)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            } else {
                Toast.makeText(this,"No users found",Toast.LENGTH_SHORT).show()
            }
        })

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_button -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}






