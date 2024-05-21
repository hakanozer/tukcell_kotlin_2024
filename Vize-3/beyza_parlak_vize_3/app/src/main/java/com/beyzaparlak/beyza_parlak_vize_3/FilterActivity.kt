package com.beyzaparlak.beyza_parlak_vize_3

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.beyzaparlak.beyza_parlak_vize_3.configs.ApiClient
import com.beyzaparlak.beyza_parlak_vize_3.databinding.ActivityFilterBinding
import com.beyzaparlak.beyza_parlak_vize_3.modell.User
import com.beyzaparlak.beyza_parlak_vize_3.service.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding
    private lateinit var dummyService: DummyService
    var filteredUsers: User? = null


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


        // Önceki sayfaya git butonu
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // blood group için spinner işlemleri
        val items = arrayOf(" ","A+", "A-", "B+", "B-", "AB+", "AB-", "0+", "0-")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                // Seçilen öğeye göre işlem yapabilir
                checkButtonState()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Hiçbir öğe seçilmediğinde yapılacak işlemler -> Toast message
                showToast("Enter Value in Field!!")

            }
        }



        binding.btnGet.isEnabled = false

        // editTextlerde değişiklik olduğunda butonun aktifliği dinamik olarak kontrol edilir
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                checkButtonState()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }


        binding.txtFirstName.addTextChangedListener(textWatcher)
        binding.txtLastName.addTextChangedListener(textWatcher)
        binding.txtAge.addTextChangedListener(textWatcher)

        // get butona basıldığında
        binding.btnGet.setOnClickListener {
            dummyService = ApiClient.getClient().create(DummyService::class.java)
            // first name properties göre filtreleme işlemi
            dummyService.getUsersByFirstName(value = binding.txtFirstName.text.toString()).enqueue(object :
                Callback<User> {
                override fun onResponse(p0: Call<User>, p1: Response<User>) {
                    if (p1.isSuccessful) {
                        val user = p1.body()
                        user?.let {
                            filteredUsers = it
                        }
                        val intent = Intent(this@FilterActivity, MainActivity::class.java)
                        intent.putExtra("filteredUsers", filteredUsers)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                    }
                }
                override fun onFailure(p0: Call<User>, p1: Throwable) {

                }
            })
            /*
            // last name properties göre filtreleme işlemi
            dummyService.getUsersByLastName(value = binding.txtLastName.text.toString()).enqueue(object :
                Callback<User> {
                override fun onResponse(p0: Call<User>, p1: Response<User>) {
                    if (p1.isSuccessful) {
                        val user = p1.body()
                        user?.let {
                            filteredUsers = it
                        }
                        val intent = Intent(this@FilterActivity, MainActivity::class.java)
                        intent.putExtra("filteredUsers", filteredUsers)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                    }
                }
                override fun onFailure(p0: Call<User>, p1: Throwable) {

                }
            })
            // age properties göre filtreleme işlemi
            dummyService.getUsersByAge(value = binding.txtAge.text.toString().toInt()).enqueue(object :
                Callback<User> {
                override fun onResponse(p0: Call<User>, p1: Response<User>) {
                    if (p1.isSuccessful) {
                        val user = p1.body()
                        user?.let {
                            filteredUsers = it
                        }
                        val intent = Intent(this@FilterActivity, MainActivity::class.java)
                        intent.putExtra("filteredUsers", filteredUsers)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                    }
                }
                override fun onFailure(p0: Call<User>, p1: Throwable) {

                }
            })
            // spinner properties göre filtreleme işlemi
            dummyService.getUsersByBloodGroup(value = binding.spinner).enqueue(object :
                Callback<User> {
                override fun onResponse(p0: Call<User>, p1: Response<User>) {
                    if (p1.isSuccessful) {
                        val user = p1.body()
                        user?.let {
                            filteredUsers = it
                        }
                        val intent = Intent(this@FilterActivity, MainActivity::class.java)
                        intent.putExtra("filteredUsers", filteredUsers)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                    }
                }
                override fun onFailure(p0: Call<User>, p1: Throwable) {

                }
            })

             */
        }

    }

    // editTextler doldurulmuş mu kontrol ediyorum. Yalnızca birinin doldurulması halinde buton etkinleşiyor
    private fun checkButtonState() {
        val isTxtFirstName = binding.txtFirstName.text.isNotBlank()
        val isTxtLastName = binding.txtLastName.text.isNotBlank()
        val isTxtAge = binding.txtAge.text.isNotBlank()
        val isSpinnerItemSelected = binding.spinner.selectedItemPosition != 0
        val filledEditTextsCount = listOf(isTxtFirstName, isTxtLastName,isSpinnerItemSelected, isTxtAge).count { it }
        binding.btnGet.isEnabled = filledEditTextsCount == 1
    }

    // toast message
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}