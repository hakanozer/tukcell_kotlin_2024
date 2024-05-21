package com.cevdetkilickeser.cevdetkilickeservize3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.cevdetkilickeser.cevdetkilickeservize3.databinding.ActivityMainBinding
import com.cevdetkilickeser.cevdetkilickeservize3.adapter.UserAdapter
import com.cevdetkilickeser.cevdetkilickeservize3.config.ApiClient
import com.cevdetkilickeser.cevdetkilickeservize3.model.User
import com.cevdetkilickeser.cevdetkilickeservize3.model.Users
import com.cevdetkilickeser.cevdetkilickeservize3.service.IDummyService
import com.cevdetkilickeser.cevdetkilickeservize3.utils.FilterValue
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var iDummyService: IDummyService
    private lateinit var userAdapter: UserAdapter
    private lateinit var listView: ListView
    lateinit var userList: List<User>
    lateinit var filteredList: MutableList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iDummyService = ApiClient.getClient().create(IDummyService::class.java)
        listView = binding.listView
        filteredList = mutableListOf()

        userAdapter = UserAdapter(this@MainActivity, filteredList)
        listView.adapter = userAdapter

        getUsersFromService()

        binding.btnFilter.setOnClickListener {
            if (binding.progressBar.visibility == View.INVISIBLE){
                val intent = Intent(this, FilterActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun getUsersFromService() { //Filtreleme yapılıp yapılmadığını kontrol ederek ilgili servise istek atar

        binding.progressBar.visibility = View.VISIBLE
        binding.txtNotFound.visibility = View.INVISIBLE

        if (FilterValue.key.isNotBlank() || FilterValue.value.isNotBlank()) {
            iDummyService.getUsersWithFilter(FilterValue.key, FilterValue.value).enqueue(object : Callback<Users>{
                override fun onResponse(p0: Call<Users>, p1: Response<Users>) {
                    if (p1.isSuccessful){
                        userList = p1.body()!!.users
                        filteredList.clear()
                        filteredList.addAll(userList)
                        userAdapter.notifyDataSetChanged()
                        controlVisibility(filteredList)
                    }
                }

                override fun onFailure(p0: Call<Users>, p1: Throwable) {
                    Snackbar.make(listView, p1.message.toString(), Snackbar.LENGTH_LONG).show()
                }
            })
        } else {
            iDummyService.getUsers().enqueue(object : Callback<Users> {
                override fun onResponse(p0: Call<Users>, p1: Response<Users>) {
                    if (p1.isSuccessful) {
                        userList = p1.body()!!.users
                        filteredList.clear()
                        filteredList.addAll(userList)
                        userAdapter.notifyDataSetChanged()
                        controlVisibility(filteredList)
                    }
                }

                override fun onFailure(p0: Call<Users>, p1: Throwable) {
                    Snackbar.make(listView, p1.message.toString(), Snackbar.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun controlVisibility(list: List<User>) {
        binding.progressBar.visibility = View.INVISIBLE
        if (list.isEmpty()){
            binding.txtNotFound.visibility = View.VISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        getUsersFromService() //FilterActivity'den MainActivity'e geri dönüldüğünde servise istek atar
    }
}