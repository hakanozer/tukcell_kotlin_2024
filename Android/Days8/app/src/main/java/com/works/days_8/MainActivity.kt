package com.works.days_8

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.works.days_8.configs.ApiClient
import com.works.days_8.models.User
import com.works.days_8.models.UserLogin
import com.works.days_8.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var shared: SharedPreferences
    lateinit var editor: Editor

    lateinit var iDummyService: IDummyService
    lateinit var txtUserName: TextView
    lateinit var txtName: EditText
    lateinit var txtPassword: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtUserName = findViewById(R.id.txtUserName)
        txtName = findViewById(R.id.txtName)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        shared = getSharedPreferences("customer", MODE_PRIVATE)
        editor = shared.edit()

        iDummyService = ApiClient.getClient().create(IDummyService::class.java)
        btnLogin.setOnClickListener {
            val name = txtName.text.toString()
            val password = txtPassword.text.toString()
            val userLogin = UserLogin(name, password)
            iDummyService.userLogin(userLogin).enqueue(object: Callback<User> {
                override fun onResponse(call: Call<User>, res: Response<User>) {
                    // servis işlemi başarılı
                    val dt = res.body()
                    dt?.let {
                        val gson = Gson()
                        val stUser = gson.toJson(it)
                        txtUserName.setText("${it.firstName} ${it.lastName}")
                        editor.putString("token", it.token)
                        editor.putString("name", "${it.firstName} ${it.lastName}" )
                        editor.putString("user", stUser)
                        editor.commit()
                    }
                }
                override fun onFailure(call: Call<User>, th: Throwable) {
                    // işlem sırasında bir hata oluştu!
                    Log.d("Login Error", "onFailure: " + th.message)
                }
            })
        }


        /*
        // sync
        val rn = Runnable {
            try {
                val res =  iDummyService.userLogin(userLogin).execute()
                if (res.isSuccessful) {
                    Log.d("mesaj", res.message())
                    val dt = res.body()
                    dt?.let {
                        Log.d("execute", it.toString())
                    }
                }
            }catch (ex:Exception) {
                Log.e("ex", ex.toString() )
            }
        }
        val th = Thread(rn)
        th.start()
         */

    }

}