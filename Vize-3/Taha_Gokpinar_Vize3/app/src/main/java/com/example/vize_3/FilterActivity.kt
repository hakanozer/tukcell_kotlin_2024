package com.example.vize_3

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vize_3.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFilterBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferences = getSharedPreferences("FilterPreferences", Context.MODE_PRIVATE)

        val bloodGroupList = listOf("O-", "O+", "A+", "A-", "B+", "B-", "AB+", "AB-")
        val adapter = ArrayAdapter(this, R.layout.user_blood_group, bloodGroupList)
        binding.bloodGroup.setAdapter(adapter)

        binding.btnBack.setOnClickListener {
            val firstName = binding.editTextFirstName.text.toString().trim()
            val lastName = binding.editTextLastName.text.toString().trim()
            val age = binding.editTextAge.text.toString().trim()
            val bloodGroup = binding.bloodGroup.text.toString().trim()

            val filters = listOf(firstName, lastName, age, bloodGroup).filter { it.isNotEmpty() }
            if (filters.size > 1) {
                Toast.makeText(this, "Multiple filter inputs!", Toast.LENGTH_SHORT).show()
            }
            else if (filters.size == 0){
                Toast.makeText(this, "No filter!", Toast.LENGTH_SHORT).show()
            }
            else{
                val editor = sharedPreferences.edit()

                editor.remove("firstName")
                editor.remove("lastName")
                editor.remove("age")
                editor.remove("bloodGroup")

                if (firstName.isNotEmpty()) {
                    editor.putString("firstName", firstName)
                } else if (lastName.isNotEmpty()) {
                    editor.putString("lastName", lastName)
                } else if (age.isNotEmpty()) {
                    editor.putString("age", age)
                } else if (bloodGroup.isNotEmpty()) {
                    editor.putString("bloodGroup", bloodGroup)
                }

                editor.commit()
                finish()
            }
        }

        binding.btnClean.setOnClickListener {
            binding.editTextFirstName.text.clear()
            binding.editTextLastName.text.clear()
            binding.editTextAge.text.clear()
            binding.bloodGroup.text.clear()

            Toast.makeText(this, "Filters cleaned!", Toast.LENGTH_SHORT).show()
        }
    }
}