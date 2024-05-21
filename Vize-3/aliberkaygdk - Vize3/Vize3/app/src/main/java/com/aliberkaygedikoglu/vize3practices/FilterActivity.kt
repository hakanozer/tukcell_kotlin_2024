package com.aliberkaygedikoglu.vize3practices

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aliberkaygedikoglu.vize3practices.config.ApiClient
import com.aliberkaygedikoglu.vize3practices.databinding.ActivityFilterBinding
import com.aliberkaygedikoglu.vize3practices.model.Users
import com.aliberkaygedikoglu.vize3practices.service.DummyService
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilterBinding
    private lateinit var dummyService: DummyService

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


        binding.buttonFilter.setOnClickListener {
            getFilter()
        }
        binding.button1.setOnClickListener {

            binding.editTextText.visibility = View.VISIBLE


        }
        binding.button2.setOnClickListener {

            binding.editTextText.visibility = View.VISIBLE


        }
        binding.button3.setOnClickListener {

            binding.editTextText.visibility = View.VISIBLE


        }


        binding.button4.setOnClickListener {

            binding.editTextText.visibility = View.INVISIBLE
            showPopupMenu(it)

        }


    }

     private fun getFilter() {
         val toggleGroup = findViewById<MaterialButtonToggleGroup>(R.id.toggleButton)
         val checkedButtonId = toggleGroup.checkedButtonId

         val checkedButton = findViewById<Button>(checkedButtonId)
         val  buttonText = checkedButton.text.toString()

        val value = binding.editTextText.text.toString()
        Log.d("query", value)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        dummyService.getFilter(buttonText, value).enqueue(object : Callback<Users> {
            override fun onResponse(p0: Call<Users>, p1: Response<Users>) {

                if (p1.isSuccessful) {
                    val user = p1.body()!!

                    Log.d("sonuc", user.toString())
                    val intent = Intent(this@FilterActivity, MainActivity::class.java)
                    intent.putExtra("filteredData", user)
                    startActivity(intent)

                }
            }

            override fun onFailure(p0: Call<Users>, p1: Throwable) {

            }


        })

    }
    private fun getFilterBlood(group:String) {


        dummyService = ApiClient.getClient().create(DummyService::class.java)
        dummyService.getFilter("bloodGroup", group).enqueue(object : Callback<Users> {
            override fun onResponse(p0: Call<Users>, p1: Response<Users>) {

                if (p1.isSuccessful) {
                    val user = p1.body()!!

                    Log.d("sonuc", user.toString())
                    val intent = Intent(this@FilterActivity, MainActivity::class.java)
                    intent.putExtra("filteredData", user)
                    startActivity(intent)

                }
            }

            override fun onFailure(p0: Call<Users>, p1: Throwable) {

            }


        })

    }

    private fun showPopupMenu(view: View) = PopupMenu(view.context, view).run {
        menuInflater.inflate(R.menu.menu, menu)
        setOnMenuItemClickListener { item ->
            getFilterBlood(item.title.toString())
            true
        }
        show()
    }
}