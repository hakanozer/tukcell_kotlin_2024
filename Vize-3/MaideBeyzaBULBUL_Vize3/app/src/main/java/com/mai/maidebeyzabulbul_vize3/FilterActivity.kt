package com.mai.maidebeyzabulbul_vize3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FilterActivity : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var bloodGroupSpinner: Spinner
    private lateinit var filterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        firstNameEditText = findViewById(R.id.firstNameEditText)
        lastNameEditText = findViewById(R.id.lastNameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        bloodGroupSpinner = findViewById(R.id.bloodGroupSpinner)
        filterButton = findViewById(R.id.filterButton)

        // Spinner için veri ekleyelim
        val bloodGroups = arrayOf("Select Blood Group", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bloodGroups)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bloodGroupSpinner.adapter = adapter

        filterButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val age = ageEditText.text.toString()
            val bloodGroup = bloodGroupSpinner.selectedItem.toString()

            if (firstName.isNotEmpty() || lastName.isNotEmpty() || age.isNotEmpty() || bloodGroup != "Select Blood Group") {
                val intent = Intent()
                if (firstName.isNotEmpty()) {
                    intent.putExtra("filterKey", "firstName")
                    intent.putExtra("filterValue", firstName)
                } else if (lastName.isNotEmpty()) {
                    intent.putExtra("filterKey", "lastName")
                    intent.putExtra("filterValue", lastName)
                } else if (age.isNotEmpty()) {
                    intent.putExtra("filterKey", "age")
                    intent.putExtra("filterValue", age)
                } else if (bloodGroup != "Select Blood Group") {
                    intent.putExtra("filterKey", "bloodGroup")
                    intent.putExtra("filterValue", bloodGroup)
                }
                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, "Please enter a filter value", Toast.LENGTH_SHORT).show()
            }
        }
    }
}