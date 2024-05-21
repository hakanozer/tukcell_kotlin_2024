package com.cevdetkilickeser.cevdetkilickeservize3

import android.R
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cevdetkilickeser.cevdetkilickeservize3.databinding.ActivityFilterBinding
import com.cevdetkilickeser.cevdetkilickeservize3.utils.FilterValue
import com.google.android.material.snackbar.Snackbar


class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding
    private val bloods = arrayOf("Seçiniz", "O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, bloods)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBlood.adapter = adapter
        binding.spinnerBlood.popupBackground.setTint(Color.WHITE)

        rememberFilter()

        touchSettings()

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnClearFilter.setOnClickListener {
            clearFilter()
            hideKeyboard(it)
        }

    }

    private fun rememberFilter() { //Filtre yapıldıktan sonra uygulama kapatılmadan, tekrar FilterActivity'e dönüldüğünde son filtreyi hatırlar.
        when (FilterValue.key) {
            "firstName" -> binding.txtFirstname.setText(FilterValue.value)
            "lastName" -> binding.txtLastname.setText(FilterValue.value)
            "age" -> binding.txtAge.setText(FilterValue.value)
            "bloodGroup" -> binding.spinnerBlood.setSelection(bloods.indexOf(FilterValue.value))
        }
    }

    private fun clearFilter() { //Filtreyi temizler
        binding.txtFirstname.setText("")
        binding.txtLastname.setText("")
        binding.txtAge.setText("")
        binding.spinnerBlood.setSelection(bloods.indexOf(bloods[0]))
    }

    private fun touchSettings() { //Kullanıcının iki filtre seçmesini engeller
        binding.txtFirstname.setOnTouchListener { _, _ ->
            if (binding.txtLastname.text.isNotBlank() || binding.txtAge.text.isNotBlank() || binding.spinnerBlood.selectedItemPosition != 0) {
                hideKeyboard(binding.root)
                showSnackbar()
                true
            } else {
                false
            }
        }

        binding.txtLastname.setOnTouchListener { _, _ ->
            if (binding.txtFirstname.text.isNotBlank() || binding.txtAge.text.isNotBlank() || binding.spinnerBlood.selectedItemPosition != 0) {
                hideKeyboard(binding.root)
                showSnackbar()
                true
            } else {
                false
            }
        }

        binding.txtAge.setOnTouchListener { _, _ ->
            if (binding.txtFirstname.text.isNotBlank() || binding.txtLastname.text.isNotBlank() || binding.spinnerBlood.selectedItemPosition != 0) {
                hideKeyboard(binding.root)
                showSnackbar()
                true
            } else {
                false
            }
        }

        binding.spinnerBlood.setOnTouchListener { _, _ ->
            if (binding.txtFirstname.text.isNotBlank() || binding.txtLastname.text.isNotBlank() || binding.txtAge.text.isNotBlank()) {
                hideKeyboard(binding.root)
                showSnackbar()
                true
            } else {
                false
            }
        }


    }

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        view.clearFocus()
    }

    private fun showSnackbar() {
        Snackbar.make(
            binding.root,
            "Filtreleme işlemi için, sadece bir alan seçilmelidir",
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun defineFilterValue() {
        if (binding.txtFirstname.text.isNotBlank()) {
            FilterValue.key = "firstName"
            FilterValue.value = binding.txtFirstname.text.toString()
        } else if (binding.txtLastname.text.isNotBlank()) {
            FilterValue.key = "lastName"
            FilterValue.value = binding.txtLastname.text.toString()
        } else if (binding.txtAge.text.isNotBlank()) {
            FilterValue.key = "age"
            FilterValue.value = binding.txtAge.text.toString()
        } else if (binding.spinnerBlood.selectedItemPosition != 0) {
            FilterValue.key = "bloodGroup"
            FilterValue.value = binding.spinnerBlood.selectedItem.toString()
        } else {
            FilterValue.key = ""
            FilterValue.value = ""
        }
    }


    @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    override fun onBackPressed() {
        super.onBackPressed()
        Log.e("şş", "onBackPressed çalıştı")
        defineFilterValue()
    }
}