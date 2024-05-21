package com.ns.enesarisoy_vize3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.ns.enesarisoy_vize3.configs.ApiClient
import com.ns.enesarisoy_vize3.databinding.ActivityFilterBinding
import com.ns.enesarisoy_vize3.model.UserResponse
import com.ns.enesarisoy_vize3.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding
    private lateinit var userService: UserService
    private lateinit var filterIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userService = ApiClient.getClient().create(UserService::class.java)
        filterIntent = Intent(this, MainActivity::class.java)

        binding.apply {
            llBloodGroup.setOnClickListener {
                val popup = PopupMenu(this@FilterActivity, llBloodGroup)
                popup.menuInflater.inflate(R.menu.blood_group_menu, popup.menu)
                popup.setOnMenuItemClickListener { item ->
                    tvBloodGroup.text = item.title
                    true
                }
                // show menu
                popup.show()
            }

            onBackPressedDispatcher.addCallback {
                checkTexts()
            }

            toolbarFilter.setNavigationOnClickListener {
                checkTexts()
            }
        }
    }

    private fun checkTexts() {
        binding.apply {
            val filters = mapOf(
                "firstName" to etFirstName.text.toString().trim(),
                "lastName" to etLastName.text.toString().trim(),
                "age" to etAge.text.toString().trim(),
                "bloodGroup" to if (tvBloodGroup.text == "Blood Group") ""
                else tvBloodGroup.text.trim().toString()
            )

            val filledFilters = filters.filter { it.value.isNotEmpty() }

            if (filledFilters.size > 1) {
                showWarning("Sadece bir alan doldurulabilir.")
            } else {
                filledFilters.entries.firstOrNull()?.let { filter ->
                    fetchFilteredUsers(filter.key, filter.value)
                } ?: run {
                    filterIntent.removeExtra("users")
                    setResult(Activity.RESULT_OK, filterIntent)
                    finish()
                }
            }
        }
    }

    private fun showWarning(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun fetchFilteredUsers(key: String, value: String) {
        userService.getFilteredUsers(key, value).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    filterIntent.putExtra("users", users)
                    setResult(Activity.RESULT_OK, filterIntent)
                    finish()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }


}