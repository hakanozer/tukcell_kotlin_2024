package com.example.emre_bitil_vize_3

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.emre_bitil_vize_3.adaptors.ProductAdaptors
import com.example.emre_bitil_vize_3.configs.ApiClient
import com.example.emre_bitil_vize_3.models.Products
import com.example.emre_bitil_vize_3.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty

class MainActivity : AppCompatActivity() {
    lateinit var firstName : String
    lateinit var lastName : String
    lateinit var age : String
    lateinit var bloodGroupSpinner : Spinner
     var key :String = ""
    var value :String = ""


    lateinit var dummyService: DummyService
    lateinit var listViewProducts: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listViewProducts = findViewById(R.id.listViewProducts)
        val btnFilter = findViewById<Button>(R.id.btnFilter)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        dummyService.getUsers().enqueue(object : Callback<Products> {
            override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                if (p1.isSuccessful) {
                    val arr = p1.body()!!.users
                    val productAdaptors = ProductAdaptors(this@MainActivity, arr)
                    listViewProducts.adapter = productAdaptors

                }
            }

            override fun onFailure(p0: Call<Products>, p1: Throwable) {
                Log.e("getProducts", p1.message!! )
            }
        } )

        btnFilter.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.filter_page ,null)

            AlertDialog.Builder(this)
                .setTitle("Filter Details")
                .setView(dialogView)
                .setPositiveButton("OK") { dialog, _ ->
                    firstName = dialogView.findViewById<EditText>(R.id.editText_firstName).text.toString()
                     lastName = dialogView.findViewById<EditText>(R.id.editText_lastName).text.toString()
                     age = dialogView.findViewById<EditText>(R.id.editText_age).text.toString()
                     bloodGroupSpinner = dialogView.findViewById(R.id.spinner_bloodGroup)
                    if (firstName.isNotBlank() && lastName.isBlank() && age.isBlank() && bloodGroupSpinner.isEmpty()) {
                        key = "firstName"
                        value = firstName
                    } else if (firstName.isBlank() && lastName.isNotBlank() && age.isBlank() && bloodGroupSpinner.isEmpty()) {
                        key = "lastName"
                        value = lastName
                    } else if (firstName.isBlank() && lastName.isBlank() && age.isNotBlank() && bloodGroupSpinner.isEmpty()) {
                        key = "age"
                        value = age
                    } else if (firstName.isBlank() && lastName.isBlank() && age.isBlank() && bloodGroupSpinner.isNotEmpty()) {
                        key = "bloodGroup"
                        value = bloodGroupSpinner.selectedItem.toString()
                    } else {
                        Toast.makeText(this, "Sadece bir değer filtreleyiniz", Toast.LENGTH_SHORT).show()
                        return@setPositiveButton
                    }
                    dummyService.getFilter(key,value).enqueue(object : Callback<Products> {
                        override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                            if (p1.isSuccessful) {
                                val arr = p1.body()!!.users
                                val productAdaptors = ProductAdaptors(this@MainActivity, arr)
                                listViewProducts.adapter = productAdaptors
                            }
                        }

                        override fun onFailure(p0: Call<Products>, p1: Throwable) {
                            Log.e("getProducts", p1.message!! )
                        }
                    } )

                    dialog.dismiss()
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()
                .show()
        }

        }
    }






