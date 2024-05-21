package com.emrecura.vize_3

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.emrecura.vize_3.databinding.ActivityFilterBinding



class FilterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.backImage.setOnClickListener {
            var key : String? = null
            var filterField : String? = null
            if (checkFieldsAndWarn()) {
                showWarningDialog()
            } else if(binding.editTextText.text.isNotEmpty()) {
                key = "firstName"
                filterField = binding.editTextText.text.toString()
                applyFilter(key,filterField)
            }else if(binding.editTextText2.text.isNotEmpty()) {
                key ="lastName"
                filterField = binding.editTextText2.text.toString()
                applyFilter(key,filterField)
            }else if(binding.editTextText3.text.isNotEmpty()) {
                key ="age"
                filterField = binding.editTextText3.text.toString()
                applyFilter(key,filterField)
            }else if (binding.spinnerBloodGroup.selectedItemPosition!=0){
                key = "bloodGroup"
                filterField = binding.spinnerBloodGroup.selectedItem.toString()
                applyFilter(key,filterField)
            }

        }
    }
    private fun applyFilter(key : String?, filterField : String?){
        val resultIntent = Intent()
        resultIntent.putExtra("filterKey", key)
        resultIntent.putExtra("filterValue", filterField)
        setResult(Activity.RESULT_OK, resultIntent)
        onBackPressed()
    }

    private fun checkFieldsAndWarn(): Boolean {
        var fieldsUsed = 0
        if (binding.editTextText.text.isNotEmpty()) fieldsUsed++
        if (binding.editTextText2.text.isNotEmpty()) fieldsUsed++
        if (binding.editTextText3.text.isNotEmpty()) fieldsUsed++
        if (binding.spinnerBloodGroup.selectedItemPosition != 0) fieldsUsed++

        return fieldsUsed > 1
    }
    private fun showWarningDialog() {
        AlertDialog.Builder(this)
            .setTitle("Uyarı")
            .setMessage("Lütfen yalnızca bir filtre seçeneğini kullanın.")
            .setPositiveButton("Tamam") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}

