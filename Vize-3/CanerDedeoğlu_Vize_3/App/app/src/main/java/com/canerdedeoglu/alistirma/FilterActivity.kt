package com.canerdedeoglu.alistirma

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
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

class FilterActivity : AppCompatActivity() {

    lateinit var txtFirstName: EditText
    lateinit var txtLastName: EditText
    lateinit var txtAge: EditText
    lateinit var backImage: ImageView
    lateinit var spinnerBloodGroup: Spinner
    lateinit var searchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_filter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtFirstName = findViewById(R.id.txt_firstName)
        txtLastName = findViewById(R.id.txt_LastName)
        txtAge = findViewById(R.id.txt_Age)
        spinnerBloodGroup = findViewById(R.id.spinnerBloodGroup)
        backImage = findViewById(R.id.back_image)
        searchButton = findViewById(R.id.btnAra)

        setupSpinner(spinnerBloodGroup, R.array.blood_group_array)

        backImage.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        setupListeners()
    }

    // Spinner bileşenini başlatır ve içine değerler doldurur.
    private fun setupSpinner(spinner: Spinner, arrayId: Int) {
        ArrayAdapter.createFromResource(
            this,
            arrayId,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    // EditText ve Spinner alanlarının text watcherlerini ayarlar.
    private fun setupListeners() {
        val textWatcher = CustomizeTextWatcher {
            checkInputs(txtFirstName, txtLastName, txtAge, spinnerBloodGroup)
        }

        txtFirstName.addTextChangedListener(textWatcher)
        txtLastName.addTextChangedListener(textWatcher)
        txtAge.addTextChangedListener(textWatcher)

        spinnerBloodGroup.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                checkInputs(txtFirstName, txtLastName, txtAge, spinnerBloodGroup)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        searchButton.setOnClickListener {
            val key = when {
                txtFirstName.text.isNotEmpty() -> "firstName"
                txtLastName.text.isNotEmpty() -> "lastName"
                txtAge.text.isNotEmpty() -> "age"
                spinnerBloodGroup.selectedItemPosition > 0 -> "bloodGroup"
                else -> null
            }

            val value = when {
                txtFirstName.text.isNotEmpty() -> capitalizeFirstLetter(txtFirstName.text.toString())
                txtLastName.text.isNotEmpty() -> capitalizeFirstLetter(txtLastName.text.toString())
                txtAge.text.isNotEmpty() -> txtAge.text.toString()
                spinnerBloodGroup.selectedItemPosition > 0 -> spinnerBloodGroup.selectedItem.toString()
                else -> null
            }


            if (key != null && !value.isNullOrEmpty()) {
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("filterKey", key)
                    putExtra("filterValue", value)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Lütfen geçerli bir filtre kriteri girin.", Toast.LENGTH_SHORT).show()
            }
        }


    }

    // EditText ve Spinner alanlarının alanlarının dolu olup olmadığını kontrol eder.
    private fun checkInputs(vararg views: View) {
        var isAnyFieldSet = false
        views.forEach { view ->
            when (view) {
                is EditText -> if (view.text.isNotEmpty()) isAnyFieldSet = true
                is Spinner -> if (view.selectedItemPosition > 0) isAnyFieldSet = true
            }
        }

        views.forEach {
            it.isEnabled = !isAnyFieldSet || (it is EditText && it.text.isNotEmpty()) || (it is Spinner && (it as Spinner).selectedItemPosition > 0)
        }
    }

    // EditText alanlarının text watcherlerini ayarlar.
    inner class CustomizeTextWatcher(private val onTextChanged: (CharSequence?) -> Unit) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            onTextChanged(s)
        }
    }

    // Verilen metnin ilk harfini büyük harfe çevirir ve geri kalan harfleri küçük harfe çevirir.
    private fun capitalizeFirstLetter(text: String): String {
        return text.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}
