package com.works.days_9

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class FilterActivity : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var bloodGroupSpinner: Spinner
    private lateinit var applyFilterButton: ImageView
    private val bloodGroups = arrayOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        firstNameEditText = findViewById(R.id.firstNameEditText)
        lastNameEditText = findViewById(R.id.lastNameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        bloodGroupSpinner = findViewById(R.id.bloodGroupSpinner)
        applyFilterButton = findViewById(R.id.applyFilterButton)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOf("Kan Grubu Seçiniz") + bloodGroups)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bloodGroupSpinner.adapter = adapter
        bloodGroupSpinner.setSelection(0)


        applyFilterButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val age = ageEditText.text.toString()
            val bloodGroup = bloodGroupSpinner.selectedItem.toString()

            val filters = mutableMapOf<String, String>()
            if (firstName.isNotEmpty()) filters["firstName"] = firstName
            if (lastName.isNotEmpty()) filters["lastName"] = lastName
            if (age.isNotEmpty()) filters["age"] = age
            if (bloodGroup != "Kan Grubu Seçiniz") filters["bloodGroup"] = bloodGroup

            if (filters.size > 1) {
                showSnackbar("Lütfen yalnızca bir filtre kriteri seçiniz")
            } else if (filters.isEmpty()) {
                showSnackbar("Lütfen filtre kriteri seçiniz")
            } else {
                val intent = Intent()
                intent.putExtra("filters", filters as HashMap)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
    private fun showSnackbar(message: String) {
        val rootView: View = findViewById(android.R.id.content)
        val snackbar = Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }
}