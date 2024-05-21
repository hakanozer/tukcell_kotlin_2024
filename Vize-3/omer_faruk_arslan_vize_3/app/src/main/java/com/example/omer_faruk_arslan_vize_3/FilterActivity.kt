package com.example.omer_faruk_arslan_vize_3

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FilterActivity : AppCompatActivity() {
    lateinit var txtFName: EditText
    lateinit var txtLName: EditText
    lateinit var txtAge: EditText
    lateinit var imgBack: ImageView
    lateinit var spnBlood: Spinner
    lateinit var btnFilter2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_filter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtFName = findViewById(R.id.txtFName)
        txtLName = findViewById(R.id.txtLName)
        txtAge = findViewById(R.id.txtAge)
        spnBlood = findViewById(R.id.spnBlood)
        imgBack = findViewById(R.id.imgBack)
        btnFilter2 = findViewById(R.id.btnFilter2)

        Spinner(spnBlood, R.array.blood_array)
        initializeListeners()

        imgBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun Spinner(spinner: Spinner, arrayId: Int) {
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
    private fun initializeListeners() {
        val customTextWatcher = CustomTextWatcher { updateButtonState(txtFName, txtLName, txtAge, spnBlood) }

        txtFName.addTextChangedListener(customTextWatcher)
        txtLName.addTextChangedListener(customTextWatcher)
        txtAge.addTextChangedListener(customTextWatcher)

        spnBlood.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                updateButtonState(txtFName, txtLName, txtAge, spnBlood)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        btnFilter2.setOnClickListener {
            val filterKey = getFilterKey()
            val filterValue = getFilterValue()

            if (!filterKey.isNullOrEmpty() && !filterValue.isNullOrEmpty()) {
                navigateToMainActivity(filterKey, filterValue)
            } else {
                showToast("Lütfen geçerli bir filtre kriteri girin.")
            }
        }
    }

    // Seçilen filtre anahtarını döner.
    private fun getFilterKey(): String? {
        return when {
            txtFName.text.isNotEmpty() -> "firstName"
            txtLName.text.isNotEmpty() -> "lastName"
            txtAge.text.isNotEmpty() -> "age"
            spnBlood.selectedItemPosition > 0 -> "bloodGroup"
            else -> null
        }
    }

    // Seçilen filtre değerini döner.
    private fun getFilterValue(): String? {
        return when {
            txtFName.text.isNotEmpty() -> txtFName.text.toString().capitalizeEachWord()
            txtLName.text.isNotEmpty() -> txtLName.text.toString().capitalizeEachWord()
            txtAge.text.isNotEmpty() -> txtAge.text.toString()
            spnBlood.selectedItemPosition > 0 -> spnBlood.selectedItem.toString()
            else -> null
        }
    }

    // Ana ekrana yönlendirir.
    private fun navigateToMainActivity(key: String, value: String) {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("filterKey", key)
            putExtra("filterValue", value)
        }
        startActivity(intent)
    }

    // Kullanıcıya mesaj gösterir.
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // EditText ve Spinner alanlarının dolu olup olmadığını kontrol eder.
    private fun updateButtonState(vararg views: View) {
        val isAnyInputFilled = views.any {
            when (it) {
                is EditText -> it.text.isNotEmpty()
                is Spinner -> it.selectedItemPosition > 0
                else -> false
            }
        }

        views.forEach { view ->
            view.isEnabled = !isAnyInputFilled || when (view) {
                is EditText -> view.text.isNotEmpty()
                is Spinner -> view.selectedItemPosition > 0
                else -> false
            }
        }
    }

    // EditText alanlarının text watcherlerini ayarlar.
    inner class CustomTextWatcher(private val onTextChanged: (CharSequence?) -> Unit) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            onTextChanged(s)
        }
    }

    // String ifadenin her kelimesinin ilk harfini büyük yapar.
    private fun String.capitalizeEachWord(): String {
        return this.split(" ").joinToString(" ") { it.capitalize() }
    }
}
