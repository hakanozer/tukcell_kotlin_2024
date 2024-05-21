package com.example.eray_altilar_vize_3.presentation.filter_screen

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.eray_altilar_vize_3.R
import com.example.eray_altilar_vize_3.core.Resource
import com.example.eray_altilar_vize_3.databinding.ActivityFilterBinding
import com.example.eray_altilar_vize_3.presentation.home_screen.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding
    private val viewModel: FilterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val bloodGroupSpinner: Spinner = binding.bloodGroupSpinner
        binding.btnFilter.isEnabled = false

        if (!binding.btnFilter.isEnabled) {
            binding.btnFilter.setBackgroundColor(resources.getColor(R.color.white))
        }

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                updateFilterButtonState()
                checkButtonColor()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkButtonColor()
            }
        }

        // EditText'lere textWatcher ekleyin
        binding.editTextFirstName.addTextChangedListener(textWatcher)
        binding.editTextLastName.addTextChangedListener(textWatcher)
        binding.editTextAge.addTextChangedListener(textWatcher)

        // Butona tıklanıldığında filtreleme işlemini gerçekleştirme
        binding.btnFilter.setOnClickListener {
            val firstName = binding.editTextFirstName.text.toString()
            val lastName = binding.editTextLastName.text.toString()
            val age = binding.editTextAge.text.toString()

            // Sadece bir EditText alanının dolu olduğunu kontrol etme
            when {
                firstName.isNotEmpty() -> viewModel.getFilteredUsers("firstName", firstName)
                lastName.isNotEmpty() -> viewModel.getFilteredUsers("lastName", lastName)
                age.isNotEmpty() -> viewModel.getFilteredUsers("age", age)
            }

        }

        lifecycleScope.launch {
            viewModel.user.collect { filteredUsers ->
                when (filteredUsers) {
                    is Resource.Success -> {
                        Log.d("Success", filteredUsers.data?.users?.size.toString())
                    }

                    is Resource.Error -> {
                        Toast.makeText(this@FilterActivity, "Error", Toast.LENGTH_SHORT).show()
                    }

                    is Resource.Loading -> {
                        Toast.makeText(this@FilterActivity, "Loading", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    fun checkButtonColor() {
        if (!binding.btnFilter.isEnabled) {
            binding.btnFilter.setBackgroundColor(resources.getColor(R.color.white))
        } else {
            binding.btnFilter.setBackgroundColor(resources.getColor(R.color.enabledButtonColor))
        }
    }

    private fun updateFilterButtonState() {
        val firstName = binding.editTextFirstName.text.toString().trim()
        val lastName = binding.editTextLastName.text.toString().trim()
        val age = binding.editTextAge.text.toString().trim()

        binding.btnFilter.isEnabled = (firstName.isNotEmpty() && lastName.isEmpty() && age.isEmpty()) ||
                (firstName.isEmpty() && lastName.isNotEmpty() && age.isEmpty()) ||
                (firstName.isEmpty() && lastName.isEmpty() && age.isNotEmpty())
    }
}

