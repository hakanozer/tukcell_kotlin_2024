package com.aliberkaygedikoglu.vize3practices

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aliberkaygedikoglu.vize3practices.adapter.UsersAdapter
import com.aliberkaygedikoglu.vize3practices.config.ApiClient
import com.aliberkaygedikoglu.vize3practices.databinding.ActivityMainBinding
import com.aliberkaygedikoglu.vize3practices.model.User
import com.aliberkaygedikoglu.vize3practices.model.Users
import com.aliberkaygedikoglu.vize3practices.service.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dummyService: DummyService
    lateinit var userRV: RecyclerView

    lateinit var arr: List<User>
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val filteredList = intent.getSerializableExtra("filteredData",Users::class.java)
        Log.d("intent",filteredList.toString())

        if (filteredList ==null){
            getAll()

        }else{
            userRV = binding.recyclerView
            userRV.layoutManager = LinearLayoutManager(this@MainActivity)
            userRV.adapter = UsersAdapter(filteredList.users)
        }


        binding.button.setOnClickListener {
            val intent = Intent(this,FilterActivity::class.java)
            startActivity(intent)
        }





    }
    private fun getAll(){
        dummyService=ApiClient.getClient().create(DummyService::class.java)
        dummyService.getUsers().enqueue(object : Callback<Users>{
            override fun onResponse(p0: Call<Users>, p1: Response<Users>) {

                if (p1.isSuccessful) {
                    arr = p1.body()!!.users

                    Log.d("getAll",arr.toString())
                    val adapter = UsersAdapter(arr)
                    userRV = binding.recyclerView
                    userRV.layoutManager = LinearLayoutManager(this@MainActivity)
                    userRV.adapter=adapter
                }
            }

            override fun onFailure(p0: Call<Users>, p1: Throwable) {

            }

        })
    }


}