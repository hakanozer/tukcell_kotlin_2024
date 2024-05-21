package com.example.mustafa_kocer_vize_3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mustafa_kocer_vize_3.datas.FilterControl
import com.example.mustafa_kocer_vize_3.services.SharedPreferencesClass

class FilterActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var  txtFirstName : EditText
    private lateinit var  txtLastName : EditText
    private lateinit var  txtAge : EditText
    private lateinit var btnBack : ImageButton
    private lateinit var shared : SharedPreferencesClass
    private lateinit var toolbar: Toolbar
    //private lateinit var  spnBlood : Spinner
    private var flag1 = false
    private var flag2 = false
    private var flag3 = false
    private var flag4 = false
    private var spinnerSecim :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_filter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        spinner = findViewById(R.id.spn_blood_group)
        btnBack = findViewById(R.id.btn_back)
        txtFirstName = findViewById(R.id.edt_filter_first_name)
        txtLastName = findViewById(R.id.edt_filter_last_name)
        txtAge = findViewById(R.id.edt_filter_age)
        toolbar = findViewById(R.id.toolbarFilter)
        setSupportActionBar(toolbar)


        //spnBlood = findViewById(R.id.spn_filter_blood)
        shared = SharedPreferencesClass(this@FilterActivity,"users_file", MODE_PRIVATE)
        FilterControl.setIsFiltered(false)
        FilterControl.setKeyName("")
        // Baslangicta filtered değişkenini false yapıyorum ki filtrelemeden geri dönerse
        // bir değişiklik olmasın

    btnBack.setOnClickListener {
        // Geri butonuna basıldığında gerekli kontrolleri veya verileri shared preferences ile veya
        // static ile main acitivity'ye yolluyor. Sadece shared preferences veya sadece static kullanılabilirdi.
        // karma şekilde kullanmayı tercih ettim.

        if (flag1){
            FilterControl.setIsFiltered(true)
            FilterControl.setKeyName("firstName")
            shared.setStr("filter",txtFirstName.text.toString() )

        }
        else if (flag2){
            FilterControl.setIsFiltered(true)
            FilterControl.setKeyName("lastName")
            shared.setStr("filter",txtLastName.text.toString())

        }
        else if (flag3){
            FilterControl.setIsFiltered(true)
            FilterControl.setKeyName("age")
            shared.setStr("filter",txtAge.text.toString())
        }
        else if (flag4){
            FilterControl.setIsFiltered(true)
            FilterControl.setKeyName("bloodGroup")
            shared.setStr("filter",spinnerSecim)

        }


        finish()
    }




        val textWatcher1 = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            // metin değiştikten sonra yapılacak kontroller
            // metin girildiyse diğerlerini pasif yap renkler de ayarlanabilir
            if (s!= null){
                flag1 = true
                flagKontrol() // digerlerini pasif yaptim
                if(s.toString() == ""){
                    flag1 = false
                    flagKontrol() // diğerlerini aktif yaptım
                }
            }
            else{
                flag1 = false
                flagKontrol()
            }

    }
    }

        val textWatcher2 = object : TextWatcher{

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {

            // metin değiştikten sonra yapılacak kontroller
            if (s!= null){
                flag2 = true
                flagKontrol() // digerlerini pasif yaptim
                if(s.toString() == ""){
                    flag2 = false
                    flagKontrol()
                }
            }
            else{
                flag2 = false
                flagKontrol()
            }
        }
    }

        val textWatcher3 = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            // metin değiştikten sonra yapılacak kontroller
            if (s!= null){
                flag3 = true
                flagKontrol() // digerlerini pasif yaptim
                if(s.toString() == ""){
                    flag3 = false
                    flagKontrol()
                }
            }
            else{
                flag3 = false
                flagKontrol()
            }
        }
    }

        txtFirstName.addTextChangedListener(textWatcher1)
        txtLastName.addTextChangedListener(textWatcher2)
        txtAge.addTextChangedListener(textWatcher3)

        txtFirstName.setOnClickListener{
            if (txtFirstName.isFocusableInTouchMode == false){
                Toast.makeText(this@FilterActivity, "Sadece 1 tane filtreleme kullanabilirsiniz!", Toast.LENGTH_SHORT).show()
            }
        }
        txtLastName.setOnClickListener{
            if (txtLastName.isFocusableInTouchMode == false){
                Toast.makeText(this@FilterActivity, "Sadece 1 tane filtreleme kullanabilirsiniz!", Toast.LENGTH_SHORT).show()
            }
        }
        txtAge.setOnClickListener{
            if (txtAge.isFocusableInTouchMode == false){
                Toast.makeText(this@FilterActivity, "Sadece 1 tane filtreleme kullanabilirsiniz!", Toast.LENGTH_SHORT).show()
            }
        }



        val arrayList = arrayOf<String>("Kan Grubuna Göre Filtrele","A-","A+","B-","B+","AB-","AB+","O+","O-")
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList)
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice)

        spinner.adapter = arrayAdapter
        spinner.setSelection(0)  // Set no selection

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                parent?.let {
                    if (position != 0){
                        flag4 = true
                        flagKontrol() // diğerlerini pasifleştirdim
                        spinnerSecim = parent.getItemAtPosition(position).toString()
                    }
                    else{
                        // pozisyon 0'da yani seçim yapmamış
                        flag4 = false
                        flagKontrol()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }// end of the on create



    fun flagKontrol(){
        println("FlagKOntrolegirdi")
        if(flag1 == true){
            txtLastName.isFocusable = false
            txtLastName.isFocusableInTouchMode = false
            txtAge.isFocusable = false
            txtAge.isFocusableInTouchMode = false
            // KAN EKLENECEK
            spinner.isEnabled = false

        }
        else if(flag2 == true){
            txtFirstName.isFocusable = false
            txtFirstName.isFocusableInTouchMode = false
            txtAge.isFocusable = false
            txtAge.isFocusableInTouchMode = false
            // KAN EKLENECEK
            spinner.isEnabled = false

        }
        else if(flag3 == true){
            txtFirstName.isFocusable = false
            txtFirstName.isFocusableInTouchMode = false
            txtLastName.isFocusable = false
            txtLastName.isFocusableInTouchMode = false

            spinner.isEnabled = false

        }
        else if(flag4 == true){
            //
            txtFirstName.isFocusable = false
            txtFirstName.isFocusableInTouchMode = false
            txtLastName.isFocusable = false
            txtLastName.isFocusableInTouchMode = false
            txtAge.isFocusable = false
            txtAge.isFocusableInTouchMode = false

        }
        else{
            // herhangi birisi true değilse hepsi erişilebilir olmalı
            txtFirstName.isFocusable = true
            txtFirstName.isFocusableInTouchMode = true
            txtFirstName.isActivated = true

            txtLastName.isFocusable = true
            txtLastName.isFocusableInTouchMode = true
            txtLastName.isActivated = true

            txtAge.isFocusable = true
            txtAge.isFocusableInTouchMode = true
            txtAge.isActivated = true

            spinner.isEnabled = true

        }

    }

}

