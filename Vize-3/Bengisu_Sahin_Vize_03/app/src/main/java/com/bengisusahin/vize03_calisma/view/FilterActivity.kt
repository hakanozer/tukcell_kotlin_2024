package com.bengisusahin.vize03_calisma.view

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bengisusahin.vize03_calisma.R
import com.bengisusahin.vize03_calisma.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding
    private var selectedBloodGroup: String? = null
    private var isFilterMessageShown: Boolean = false

    private val filterKey = "key"
    private val filterValue = "value"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFilterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            linearLayout.setOnClickListener {
                showPopup(it)
            }

            buttonBack.setOnClickListener {
                handleButtonClick()
            }

            buttonClear.setOnClickListener {
                setResult(RESULT_CANCELED)
                finish()
            }
            // Listens for text changes in the input fields
            editTextFirstName.addTextChangedListener(filterTextWatcher)
            editTextLastName.addTextChangedListener(filterTextWatcher)
            editTextAge.addTextChangedListener(filterTextWatcher)
        }

    }

    // TextWatcher for handling input field changes
    private val filterTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            handleInputChange()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    // Handles changes in input fields
    private fun handleInputChange() {
        val firstNameFilled = binding.editTextFirstName.text.isNotEmpty()
        val lastNameFilled = binding.editTextLastName.text.isNotEmpty()
        val ageFilled = binding.editTextAge.text.isNotEmpty()
        val bloodGroupSelected = !selectedBloodGroup.isNullOrEmpty()

        binding.apply {
            editTextFirstName.isEnabled = !lastNameFilled && !ageFilled && !bloodGroupSelected
            editTextLastName.isEnabled = !firstNameFilled && !ageFilled && !bloodGroupSelected
            editTextAge.isEnabled = !firstNameFilled && !lastNameFilled && !bloodGroupSelected
            linearLayout.isEnabled = !firstNameFilled && !lastNameFilled && !ageFilled
        }
        if ((firstNameFilled || lastNameFilled || ageFilled || bloodGroupSelected) &&
            !isFilterMessageShown) {
            Toast.makeText(this, "You can enter only one filter. You will not be" +
            " able to fill in other fields.", Toast.LENGTH_LONG).show()
            isFilterMessageShown = true
        }

    }

    // When user click the "Back" button filters apply
    private fun handleButtonClick() {
        val firstName = formatName(binding.editTextFirstName.text.toString())
        val lastName = formatName(binding.editTextLastName.text.toString())
        val age = binding.editTextAge.text.toString()
        val bloodGroup = selectedBloodGroup

        val intent = Intent().apply {
            when {
                firstName.isNotEmpty() -> setFilter(this, "firstName", firstName)
                lastName.isNotEmpty() -> setFilter(this, "lastName", lastName)
                age.isNotEmpty() -> setFilter(this, "age", age)
                !bloodGroup.isNullOrEmpty() -> setFilter(this, "bloodGroup", bloodGroup)
                else -> {
                    showFilterAlertDialog()
                    return
                }
            }
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    // Shows an alert dialog if no filter is selected
    private fun showFilterAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("No Filter")
        builder.setMessage("You didn't make any filter selection. Do you want to clear the " +
                "previous filter?")
        builder.setPositiveButton("Yes") { _, _ ->
            setResult(RESULT_CANCELED)
            finish()
        }
        builder.setNegativeButton("No") { _, _ ->
            setResult(RESULT_OK, intent)
            finish()
        }
        builder.setNeutralButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    // Sets the filter parameters to the intent
    private fun setFilter(intent: Intent, key: String, value: String) {
        intent.putExtra(filterKey, key)
        intent.putExtra(filterValue, value)
    }

    // Opens the bloodGroupFilter menu as popup menu
    private fun showPopup(view: View) {
        val popup = PopupMenu(this, view, Gravity.FILL)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.filter_blood_group, popup.menu)
        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            selectedBloodGroup = menuItem.title.toString()
            handleInputChange()
            Toast.makeText(this, "Selected: $selectedBloodGroup", Toast.LENGTH_SHORT).show()
            true
        }
        popup.show()
    }

    // Formats the name to capitalize the first letter and ensures JSON data compatibility.
    private fun formatName(name: String): String {
        return if (name.isNotEmpty()) {
            name.lowercase().replaceFirstChar { it.uppercase() }
        } else {
            name
        }
    }
}