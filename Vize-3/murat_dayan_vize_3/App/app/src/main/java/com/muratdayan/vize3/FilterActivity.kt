package com.muratdayan.vize3

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muratdayan.vize3.components.CustomToast
import com.muratdayan.vize3.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnGetFilter.isEnabled = false
        checkButtonColor()

        // edittext listener
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                checkButtonState()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        binding.editTxtFirstName.addTextChangedListener(textWatcher)
        binding.editTxtLastName.addTextChangedListener(textWatcher)
        binding.editTxtAge.addTextChangedListener(textWatcher)
        binding.editTxtBloodGroup.addTextChangedListener(textWatcher)



        binding.editTxtBloodGroup.isFocusable = false
        binding.editTxtBloodGroup.isFocusableInTouchMode = false

        binding.editTxtBloodGroup.setOnClickListener {
            showPopUp()
        }

        // editextlerden dolu olanı bulur ve key ve value ona göre değişir
        binding.btnGetFilter.setOnClickListener {
            val firstName = binding.editTxtFirstName.text.toString().lowercase().capitalize().trim()
            val lastName = binding.editTxtLastName.text.toString().lowercase().capitalize().trim()
            val age = binding.editTxtAge.text.toString().trim()
            val bloodGroup = binding.editTxtBloodGroup.text.toString().trim()


            val (key, value) = when {
                firstName.isNotEmpty() -> Pair("firstName", firstName)
                lastName.isNotEmpty() -> Pair("lastName", lastName)
                age.isNotEmpty() -> Pair("age", age)
                bloodGroup.isNotEmpty() -> Pair("bloodGroup", bloodGroup)
                else -> Pair("", "")  // Handle empty input case
            }

            if (key.isNotEmpty() && value.isNotEmpty()){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("key", key)
                intent.putExtra("value", value)
                startActivity(intent)
                finish()
            }
        }

        binding.imgViewBackicon.setOnClickListener {
            finish()
        }



    }

    // popup menü gösterimi ve item listener
    private fun showPopUp(){
        val popUpMenu = PopupMenu(this@FilterActivity, binding.editTxtBloodGroup)
        popUpMenu.menuInflater.inflate(R.menu.blood_group_menu, popUpMenu.menu)

        popUpMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.actionAPlus -> {
                    binding.editTxtBloodGroup.setText(it.title)
                    true
                }

                R.id.actionAMinus -> {
                    binding.editTxtBloodGroup.setText(it.title)
                    true
                }

                R.id.actionBPlus -> {
                    binding.editTxtBloodGroup.setText(it.title)
                    true
                }
                R.id.actionBMinus -> {
                    binding.editTxtBloodGroup.setText(it.title)
                    true
                }
                R.id.actionZeroPlus -> {
                    binding.editTxtBloodGroup.setText(it.title)
                    true
                }
                R.id.actionZeroMinus -> {
                    binding.editTxtBloodGroup.setText(it.title)
                    true
                }
                R.id.actionABMinus -> {
                    binding.editTxtBloodGroup.setText(it.title)
                    true
                }
                R.id.actionABPlus -> {
                    binding.editTxtBloodGroup.setText(it.title)
                    true
                }
                R.id.actionNothing ->{
                    binding.editTxtBloodGroup.setText("")
                    true
                }

                else -> false
            }
        }

        popUpMenu.show()
    }

    // buttonun enable olma ve olmama durumu
    private fun checkButtonState() {
        val isEditText1Filled = binding.editTxtFirstName.text?.isNotBlank()
        val isEditText2Filled = binding.editTxtLastName.text?.isNotBlank()
        val isEditText3Filled = binding.editTxtAge.text?.isNotBlank()
        val isEditText4Filled = binding.editTxtBloodGroup.text?.isNotBlank()

        val filledEditTextsCount = listOf(isEditText1Filled, isEditText2Filled, isEditText3Filled, isEditText4Filled).count { it == true }

        binding.btnGetFilter.isEnabled = filledEditTextsCount == 1
        checkButtonColor()
    }

    // button enable özelliğine göre arka plan renk değişimi
    @SuppressLint("ResourceAsColor")
    private fun checkButtonColor(){
        val button = binding.btnGetFilter // Get the reference to the button

        if (button.isEnabled) {
            // Set default color for enabled state (assuming you have a default color)
            button.setBackgroundColor(this.resources?.getColor(R.color.orangeYellow) ?: Color.WHITE)
        } else {
            button.setBackgroundColor(this.resources?.getColor(R.color.gray) ?: Color.GRAY)
        }
    }


}