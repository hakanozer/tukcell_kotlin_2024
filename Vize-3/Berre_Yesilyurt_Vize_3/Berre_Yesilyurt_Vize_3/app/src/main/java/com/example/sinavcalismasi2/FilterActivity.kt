package com.example.sinavcalismasi2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sinavcalismasi2.MainActivity
import com.example.sinavcalismasi2.R

class FilterActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var surnameEditText: EditText
    private lateinit var oldEditText: EditText
    //private lateinit var bloodTestEditText: EditText
    //private lateinit var btnBack: Button
    private lateinit var btnPopup:Button
    private lateinit var arrow:ImageView

    var filterText=""
    var filterType=""

    var FILTER_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        nameEditText = findViewById(R.id.name)
        surnameEditText = findViewById(R.id.surname)
        oldEditText = findViewById(R.id.old)
        //bloodTestEditText = findViewById(R.id.bloodTest)
        //btnBack=findViewById(R.id.btnBack)
        btnPopup=findViewById(R.id.btnPopup)
        arrow=findViewById(R.id.backImage)


        val popup=PopupMenu(this,btnPopup)
        popup.menuInflater.inflate(R.menu.popupmenu,popup.menu)

        popup.setOnMenuItemClickListener { // Popup menü, tıklanılan içeriği tespit eder ve diğer input butonları disable eder
            when(it.itemId){
                R.id.apozitif->{
                    Log.d("Tıklandı","A+ tıklandı")
                    disableAllInputs() // Diğer butonlar disable oldu
                    filterType="bloodTest"
                    filterText="A+"
                    true
                }
                R.id.anegatif->{
                    Log.d("Tıklandı","A- tıklandı")
                    disableAllInputs()
                    filterType="bloodTest"
                    filterText="A-"
                    true
                }
                R.id.bpozitif->{
                    Log.d("Tıklandı","B+ tıklandı")
                    disableAllInputs()
                    filterType="bloodTest"
                    filterText="B+"
                    true
                }
                R.id.bnegatif->{
                    Log.d("Tıklandı","B- tıklandı")
                    disableAllInputs()
                    filterType="bloodTest"
                    filterText="B-"
                    true
                }
                R.id.sifirpozitif->{
                    Log.d("Tıklandı","0+ tıklandı")
                    disableAllInputs()
                    filterType="bloodTest"
                    filterText="0+"
                    true
                }
                R.id.sifirnegatif->{
                    Log.d("Tıklandı","0- tıklandı")
                    disableAllInputs()
                    filterType="bloodTest"
                    filterText="0-"
                    true
                }
                R.id.abpozitif->{
                    Log.d("Tıklandı","AB+ tıklandı")
                    disableAllInputs()
                    filterType="bloodTest"
                    filterText="AB+"
                    true
                }
                R.id.abnegatif->{
                    Log.d("Tıklandı","AB- tıklandı")
                    disableAllInputs()
                    filterType="bloodTest"
                    filterText="AB-"
                    true
                }
                else->false


            }
            //sendResult()
            true
        }


        btnPopup.setOnClickListener { // Popup'ın açılması
            popup.show()
        }

        val editTexts = listOf(nameEditText, surnameEditText, oldEditText) // Bir edittext'E değer girince diğerlerinin disable olamsı için liste

        editTexts.forEach { editText ->
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    handleTextChange(editText, editTexts)                }

                override fun afterTextChanged(p0: Editable?) {
                }

            })
        }

        arrow.setOnClickListener { // Geri tuşuna basınca, bizden değer bekleyen mainActivity'E Intent ile parametre yollanır ve onActivityResult metodunun harekete geçirilmesi amaçlanır
            val sharedPreferences = getSharedPreferences("FilterPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            val i=Intent(this, MainActivity::class.java)
            if(filterText==""){ // Filtrenin tipi ve hangi değeri aldığı belirlenir
                filterText=editTexts.firstOrNull { it.text.isNotEmpty() }?.text.toString()
            }
            else{
                filterText=filterText
            }
            filterType = when {
                nameEditText.text.isNotEmpty() -> "firstName"
                surnameEditText.text.isNotEmpty() -> "lastName"
                oldEditText.text.isNotEmpty() -> "age"
                //bloodTestEditText.text.isNotEmpty() -> "bloodGroup"
                else -> "bloodGroup"
            }

            // veriler yazılıp ana sayfaya gönderilir
            editor.putString("filterType", filterType)
            editor.putString("filterText", filterText)
            editor.apply()

            intent.putExtra("filterType", filterType)
            intent.putExtra("filterText", filterText)
            Log.d("filtertypefirst",filterType.toString())
            Log.d("filtertextfirst",filterText.toString())

            setResult(RESULT_OK, intent)
            finish()
        }

        /*btnBack.setOnClickListener {
            val sharedPreferences = getSharedPreferences("FilterPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            val i=Intent(this,MainActivity::class.java)
            filterText=editTexts.firstOrNull { it.text.isNotEmpty() }?.text.toString()
            filterType = when {
                nameEditText.text.isNotEmpty() -> "firstName"
                surnameEditText.text.isNotEmpty() -> "lastName"
                oldEditText.text.isNotEmpty() -> "age"
                bloodTestEditText.text.isNotEmpty() -> "bloodGroup"
                else -> ""
            }

            editor.putString("filterType", filterType)
            editor.putString("filterText", filterText)
            editor.apply()

            intent.putExtra("filterType", filterType)
            intent.putExtra("filterText", filterText)
            Log.d("filtertypefirst",filterType.toString())
            Log.d("filtertextfirst",filterText.toString())

            setResult(RESULT_OK, intent)
            finish()
            //startActivityForResult(i,FILTER_REQUEST_CODE)
        }*/

    }


    fun handleTextChange(changedEditText: EditText, editTexts: List<EditText>){ // Popup butonun ve inputların kontrolünü yapar, birisine değer girilince diğerlerinin disable olması için
        val text = changedEditText.text.toString()
        if (text.isNotEmpty()) {
            editTexts.forEach { editText ->
                if (editText != changedEditText) {
                    editText.isEnabled = false
                }
            }
            btnPopup.isEnabled = false
        } else {
            editTexts.forEach { editText ->
                editText.isEnabled = true
            }
            btnPopup.isEnabled = true
        }

    }

    private fun disableAllInputs() { // İnputlara bir değer girildiyse diğer hepsinin disable olması
        val editTexts = listOf(nameEditText, surnameEditText, oldEditText)
        editTexts.forEach { it.isEnabled = false }
        btnPopup.isEnabled = false
    }
}