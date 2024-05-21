package com.sercancelik.vize_3_sercan_celik

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class FilterActivity : AppCompatActivity() {


    private lateinit var editTextName: EditText
    private lateinit var editTextSurname: EditText
    private lateinit var editTextAge: EditText
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var buttonApplyFilter: Button
    private lateinit var view_age_filter: View
    private lateinit var view_blood_group_filter: View
    private lateinit var view_name_filter: View
    private lateinit var view_surname_filter: View



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        enableEdgeToEdge()



        val items = arrayOf("0+", "0-", "A+", "A-", "B+", "B-", "AB+", "AB-")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        autoCompleteTextView.setAdapter(adapter)

        editTextName = findViewById(R.id.et_name_filter)
        editTextSurname = findViewById(R.id.et_surname_filter)
        editTextAge = findViewById(R.id.et_age_filter)
        view_age_filter = findViewById(R.id.view_age_filter)
        buttonApplyFilter = findViewById(R.id.buttonApplyFilter)
        view_blood_group_filter = findViewById(R.id.view_blood_filter)
        view_name_filter = findViewById(R.id.view_name_filter)
        view_surname_filter = findViewById(R.id.view_surname_filter)

        addTextWatchers()

        buttonApplyFilter.setOnClickListener {
            if (editTextName.text.toString().isEmpty() &&
                editTextSurname.text.toString().isEmpty() &&
                editTextAge.text.toString().isEmpty() &&
                autoCompleteTextView.text.toString() == "Enter blood type"
            ) {
                Toast.makeText(this, "Make at least one choice!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {

                var key: String? = null
                var value: String? = null

                when {
                    editTextName.text.toString().isNotEmpty() -> {
                        key = "firstName"
                        value = editTextName.text.toString().capitalize()
                    }

                    editTextSurname.text.toString().isNotEmpty() -> {
                        key = "lastName"
                        value = editTextSurname.text.toString().capitalize()
                    }

                    editTextAge.text.toString().isNotEmpty() -> {
                        key = "age"
                        value = editTextAge.text.toString()
                    }

                    autoCompleteTextView.text.toString().isNotEmpty() -> {
                        key = "bloodGroup"
                        value = autoCompleteTextView.text.toString()
                    }
                }

                val resultIntent = Intent().apply {
                    putExtra(MainActivity.EXTRA_FILTER_KEY, key)
                    putExtra(MainActivity.EXTRA_FILTER_VALUE, value)
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }


    private fun addTextWatchers() {
        editTextName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isNotEmpty()) {
                    disableOtherFields(editTextName)
                } else {
                    enableAllFields()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        view_name_filter.setOnClickListener {
            if (editTextName.isEnabled) {
                editTextName.requestFocus()
            } else {
                alertToast()
            }
        }

        editTextSurname.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isNotEmpty()) {
                    disableOtherFields(editTextSurname)
                } else {
                    enableAllFields()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        view_surname_filter.setOnClickListener {
            if (editTextSurname.isEnabled) {
                editTextSurname.requestFocus()
            } else {
                alertToast()
            }
        }

        editTextAge.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isNotEmpty()) {
                    disableOtherFields(editTextAge)
                } else {
                    enableAllFields()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        view_age_filter.setOnClickListener {
            if (editTextAge.isEnabled) {
                editTextAge.requestFocus()
            } else {
                alertToast()
            }
        }


        autoCompleteTextView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isNotEmpty()) {
                    disableOtherFields(autoCompleteTextView)
                } else {
                    enableAllFields()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        view_blood_group_filter.setOnClickListener {
            if (autoCompleteTextView.isEnabled) {
                autoCompleteTextView.requestFocus()
                autoCompleteTextView.showDropDown()
            } else {
                alertToast()
            }
        }
    }

    private fun disableOtherFields(activeField: Any) {
        editTextName.isEnabled = activeField == editTextName
        editTextSurname.isEnabled = activeField == editTextSurname
        editTextAge.isEnabled = activeField == editTextAge
        autoCompleteTextView.isEnabled = activeField == autoCompleteTextView
        autoCompleteTextView.threshold = Int.MAX_VALUE
    }

    private fun enableAllFields() {
        editTextName.isEnabled = true
        editTextSurname.isEnabled = true
        editTextAge.isEnabled = true
        autoCompleteTextView.isEnabled = true
    }

    private fun alertToast() {
        Toast.makeText(this, "Only one filter can be used.", Toast.LENGTH_SHORT).show()
    }

}
