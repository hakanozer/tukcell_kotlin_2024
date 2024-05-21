package com.yeceylan.yunusemreceylan_snav3.presentation.filter

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yeceylan.yunusemreceylan_snav3.R
import com.yeceylan.yunusemreceylan_snav3.databinding.ActivityFilterBinding
import com.yeceylan.yunusemreceylan_snav3.presentation.main.MainActivity

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding
    private val viewModel: FilterViewModel by viewModels()
    private var firstName: String? = null
    private var surname: String? = null
    private var age: String? = null
    private var bloodType: String? = null
    private var gender: String? = null
    private var hairColor: String? = null
    private var hairType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupEditTextWatchers()
        populateBloodTypeSpinner()
        populateGenderSpinner()
        populateHairColorSpinner()
        populateHairTypeSpinner()

        binding.buttonApply.setOnClickListener {
            sendFilteredValue()
        }

        binding.buttonBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })
    }

    private fun setupEditTextWatchers() {
        binding.apply {
            editTextName.addTextChangedListener(createTextWatcher(editTextName, "firstName"))
            editTextSurname.addTextChangedListener(createTextWatcher(editTextSurname, "surname"))
            editTextAge.addTextChangedListener(createTextWatcher(editTextAge, "age"))
        }
    }

    private fun createTextWatcher(currentField: EditText, fieldName: String): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrBlank()) {
                    disableOtherFields(currentField)
                    when (fieldName) {
                        "firstName" -> firstName = s.toString()
                        "surname" -> surname = s.toString()
                        "age" -> age = s.toString()
                    }
                } else {
                    enableAllFields()
                    when (fieldName) {
                        "firstName" -> firstName = null
                        "surname" -> surname = null
                        "age" -> age = null
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        }
    }

    private fun disableOtherFields(enabledField: EditText) {
        binding.apply {
            editTextName.isEnabled = editTextName == enabledField
            editTextSurname.isEnabled = editTextSurname == enabledField
            editTextAge.isEnabled = editTextAge == enabledField
            spinnerBloodType.isEnabled = false
            genderSpinner.isEnabled = false
            hairColorSpinner.isEnabled = false
            hairTypeSpinner.isEnabled = false
        }
    }

    private fun enableAllFields() {
        binding.apply {
            editTextName.isEnabled = true
            editTextSurname.isEnabled = true
            editTextAge.isEnabled = true
            spinnerBloodType.isEnabled = true
            genderSpinner.isEnabled = true
            hairColorSpinner.isEnabled = true
            hairTypeSpinner.isEnabled = true
        }
    }

    private fun populateBloodTypeSpinner() {
        val bloodTypes = arrayOf(getString(R.string.select_blood_type), "A-", "B-", "AB-", "O-", "A+", "B+", "AB+", "O+")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bloodTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBloodType.adapter = adapter

        binding.spinnerBloodType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedBloodType = parent.getItemAtPosition(position).toString()
                if (selectedBloodType == getString(R.string.select_blood_type)) {
                    enableAllFields()
                    bloodType = null
                } else {
                    disableAllFieldsExceptSpinner(binding.spinnerBloodType)
                    bloodType = selectedBloodType
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun populateGenderSpinner() {
        val genders = arrayOf(getString(R.string.chose_gender), "male", "female")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genders)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.genderSpinner.adapter = adapter

        binding.genderSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedGender = parent.getItemAtPosition(position).toString()
                if (selectedGender == getString(R.string.chose_gender)) {
                    enableAllFields()
                    gender = null
                } else {
                    disableAllFieldsExceptSpinner(binding.genderSpinner)
                    gender = selectedGender.lowercase()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun populateHairColorSpinner() {
        val hairColors = arrayOf(getString(R.string.hair_color), "Black", "Blond", "Brown", "Chestnut", "Auburn")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, hairColors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.hairColorSpinner.adapter = adapter

        binding.hairColorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedHairColor = parent.getItemAtPosition(position).toString()
                if (selectedHairColor == getString(R.string.hair_color)) {
                    enableAllFields()
                    hairColor = null
                } else {
                    disableAllFieldsExceptSpinner(binding.hairColorSpinner)
                    hairColor = selectedHairColor
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun populateHairTypeSpinner() {
        val hairTypes = arrayOf(getString(R.string.hair_type), "Straight", "Strands", "Curly", "Very curly", "Wavy")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, hairTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.hairTypeSpinner.adapter = adapter

        binding.hairTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedHairType = parent.getItemAtPosition(position).toString()
                if (selectedHairType == getString(R.string.hair_type)) {
                    enableAllFields()
                    hairType = null
                } else {
                    disableAllFieldsExceptSpinner(binding.hairTypeSpinner)
                    hairType = selectedHairType
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun disableAllFieldsExceptSpinner(enabledSpinner: View) {
        binding.apply {
            editTextName.isEnabled = false
            editTextSurname.isEnabled = false
            editTextAge.isEnabled = false
            spinnerBloodType.isEnabled = enabledSpinner == spinnerBloodType
            genderSpinner.isEnabled = enabledSpinner == genderSpinner
            hairColorSpinner.isEnabled = enabledSpinner == hairColorSpinner
            hairTypeSpinner.isEnabled = enabledSpinner == hairTypeSpinner
        }
    }

    private fun sendFilteredValue() {
        if (firstName.isNullOrEmpty() && surname.isNullOrEmpty() && age.isNullOrEmpty() && bloodType.isNullOrEmpty() && gender.isNullOrEmpty() && hairColor.isNullOrEmpty() && hairType.isNullOrEmpty()) {
            Toast.makeText(this, "Lütfen bir filtre giriniz", Toast.LENGTH_SHORT).show()
            return
        }

        lateinit var filterField: String
        lateinit var filterValue: String
        firstName?.let { filterValue = it; filterField = "firstName" }
        surname?.let { filterValue = it; filterField = "lastName" }
        age?.let { filterValue = it; filterField = "age" }
        bloodType?.let { filterValue = it; filterField = "bloodGroup" }
        gender?.let { filterValue = it; filterField = "gender" }
        hairColor?.let { filterValue = it; filterField = "hair.color" }
        hairType?.let { filterValue = it; filterField = "hair.type" }
        setupObservers(filterValue, filterField)
    }

    private fun setupObservers(filterValue: String, filterField: String) {
        viewModel.fetchUsers(filterField, filterValue)
        viewModel.usersLiveData.observe(this) { users ->
            users?.let {
                val resultIntent = Intent(this, MainActivity::class.java).apply {
                    putExtra("filteredUsers", ArrayList(it))
                }
                startActivity(resultIntent)
                finish()
            }
        }
    }
}
