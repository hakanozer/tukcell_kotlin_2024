package com.tlh.myapplication8.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.tlh.myapplication8.MainActivity
import com.tlh.myapplication8.R
import com.tlh.myapplication8.client.ApiClient
import com.tlh.myapplication8.models.User
import com.tlh.myapplication8.service.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var lastName: EditText
    private lateinit var age: EditText
    private lateinit var bloodType: Button
    private lateinit var filterButton: Button
    private lateinit var restoreButton: Button
    private lateinit var dummyService: DummyService
    private var selectedBloodType: String? = null

    var filteredUsers: User? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        name = findViewById(R.id.name_edit)
        lastName = findViewById(R.id.lastname_edit)
        age = findViewById(R.id.age_edit)
        bloodType = findViewById(R.id.blood_button)
        filterButton = findViewById(R.id.filter_button)
        restoreButton = findViewById(R.id.restore_Button)


        val letterFilter = InputFilter { source, start, end, _, _, _ ->
            for (i in start until end) {
                if (!Character.isLetter(source[i])) {
                    return@InputFilter ""
                }
            }
            null
        }

        name.filters = arrayOf(letterFilter)
        lastName.filters = arrayOf(letterFilter)


        val popupMenu = PopupMenu(this, bloodType)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.my_menu, popupMenu.menu)

        bloodType.setOnClickListener {
            popupMenu.show()
        }

        popupMenu.setOnMenuItemClickListener { menuItem ->
            selectedBloodType = when (menuItem.itemId) {
                R.id.aminus -> {
                    bloodType.text = "A-"
                    "A-"
                }

                R.id.aplus -> {
                    bloodType.text = "A+"
                    "A+"
                }

                R.id.bminus -> {
                    bloodType.text = "B-"
                    "B-"
                }

                R.id.bplus -> {
                    bloodType.text = "B+"
                    "B+"
                }

                R.id.zerominus -> {
                    bloodType.text = "O-"
                    "O-"
                }

                R.id.zeroplus -> {
                    bloodType.text = "0+"
                    "O+"
                }

                R.id.abminus -> {
                    bloodType.text = "AB-"
                    "AB-"
                }

                R.id.abplus -> {
                    bloodType.text = "AB+"
                    "AB+"
                }
                else -> null
            }
            checkButtonState()
            true
        }

        filterButton.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                checkButtonState()
                if (!s.isNullOrEmpty() && !s.toString().matches(Regex("\\d*"))) {
                    age.setText(s.removeRange(s.length - 1, s.length))
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        name.addTextChangedListener(textWatcher)
        lastName.addTextChangedListener(textWatcher)
        age.addTextChangedListener(textWatcher)
        bloodType.addTextChangedListener(textWatcher)

        filterButton.setOnClickListener {
            dummyService = ApiClient.getClient().create(DummyService::class.java)

            val filterKey: String
            val filterValue: String

            when {
                name.text.isNotBlank() -> {
                    filterKey = "firstName"
                    filterValue = name.text.toString()
                }

                lastName.text.isNotBlank() -> {
                    filterKey = "lastName"
                    filterValue = lastName.text.toString()
                }

                age.text.isNotBlank() -> {
                    filterKey = "age"
                    filterValue = age.text.toString()
                }

                bloodType.text.isNotBlank() -> {
                    filterKey = "bloodGroup"
                    filterValue = selectedBloodType.toString()
                }

                else -> return@setOnClickListener
            }

            dummyService.getUsersFilteredBy(filterKey, filterValue)
                .enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        if (response.isSuccessful) {
                            val users = response.body()
                            users?.let {
                                filteredUsers = it
                            }

                            val intent = Intent(this@DetailsActivity, MainActivity::class.java)
                            intent.putExtra("filteredUsers", filteredUsers)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        // Handle failure
                    }
                })
        }

        restoreButton.setOnClickListener {
            val intent = Intent(this@DetailsActivity, MainActivity::class.java)
            startActivity(intent)

        }

    }

    private fun checkButtonState() {
        val isNameFilled = name.text.isNotBlank()
        val isLastNameFilled = lastName.text.isNotBlank()
        val isAgeFilled = age.text.isNotBlank()
        val isBloodTypeFilled = selectedBloodType?.isNotBlank()

        val filledCount = listOf(
            isNameFilled,
            isLastNameFilled,
            isAgeFilled,
            isBloodTypeFilled
        ).count { it == true }

        filterButton.isEnabled = filledCount == 1
    }
}
