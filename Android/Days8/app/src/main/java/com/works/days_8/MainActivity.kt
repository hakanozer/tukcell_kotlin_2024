package com.works.days_8

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.days_8.configs.ApiClient
import com.works.days_8.models.User
import com.works.days_8.models.UserLogin
import com.works.days_8.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var iDummyService: IDummyService
    lateinit var txtUserName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtUserName = findViewById(R.id.txtUserName)

        iDummyService = ApiClient.getClient().create(IDummyService::class.java)
        val userLogin = UserLogin("kminchelle", "0lelplR")
        iDummyService.userLogin(userLogin).enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, res: Response<User>) {
                // servis işlemi başarılı
                Log.d("status code", res.isSuccessful.toString() )
                val dt = res.body()
                dt?.let {
                    txtUserName.setText("${it.firstName} ${it.lastName}")
                }
            }

            override fun onFailure(call: Call<User>, th: Throwable) {
                // işlem sırasında bir hata oluştu!
                Log.d("Login Error", "onFailure: " + th.message)
            }
        })

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


        Log.d("line", "this line call")

    }

}