package com.example.melihcakmak_vize3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.melihcakmak_vize3.databinding.ActivityFilterScreenBinding

class FilterScreen : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding:ActivityFilterScreenBinding
    var selectedBloodGroup:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityFilterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("FilterPrefs", Context.MODE_PRIVATE)
        val items= listOf("Select Blood Group","A-","A+","B-","B+","0-","0+","AB-","AB+")



        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter=adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Spinner'dan bir öğe seçildiğinde EditText alanlarını temizleyin
                binding.txtFirstName.text.clear()
                binding.txtLastName.text.clear()
                binding.txtAge.text.clear()
                selectedBloodGroup= items[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Hiçbir şey seçilmediğinde yapılacak işlem
            }
        }




        binding.txtFirstName.onFocusChangeListener = createFocusChangeListener(binding.txtLastName, binding.txtAge)
        binding.txtLastName.onFocusChangeListener = createFocusChangeListener(binding.txtFirstName, binding.txtAge)
        binding.txtAge.onFocusChangeListener = createFocusChangeListener(binding.txtFirstName, binding.txtLastName)


        binding.backButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            when {
                binding.txtFirstName.text.isNotEmpty() -> {
                    selectedBloodGroup="Select Blood Group"
                    editor.putString("filter_key", "firstName")
                    editor.putString("filter_value", binding.txtFirstName.text.toString())
                }
                binding.txtLastName.text.isNotEmpty() -> {
                    selectedBloodGroup="Select Blood Group"
                    editor.putString("filter_key", "lastName")
                    editor.putString("filter_value", binding.txtLastName.text.toString())
                }
                binding.txtAge.text.isNotEmpty() -> {
                    selectedBloodGroup="Select Blood Group"
                    editor.putString("filter_key", "age")
                    editor.putString("filter_value", binding.txtAge.text.toString())
                }
                selectedBloodGroup != "Select Blood Group" ->{
                    editor.putString("filter_key", "bloodGroup")
                    editor.putString("filter_value",selectedBloodGroup)

                }
                else -> {
                    editor.remove("filter_key")
                    editor.remove("filter_value")
                }
            }
            editor.apply()
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.backButton.performClick()
        println(selectedBloodGroup)
    }

    private fun createFocusChangeListener(vararg others: EditText) =
        View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                others.forEach { it.text.clear() }
            }
        }

    }
