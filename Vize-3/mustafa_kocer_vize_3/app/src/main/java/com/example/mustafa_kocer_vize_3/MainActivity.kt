package com.example.mustafa_kocer_vize_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mustafa_kocer_vize_3.adapters.RecyclerUserAdapter
import com.example.mustafa_kocer_vize_3.configs.ApiClient
import com.example.mustafa_kocer_vize_3.datas.FilterControl
import com.example.mustafa_kocer_vize_3.models.User
import com.example.mustafa_kocer_vize_3.models.UsersModel
import com.example.mustafa_kocer_vize_3.services.IDummyService
import com.example.mustafa_kocer_vize_3.services.SharedPreferencesClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val iDummyService : IDummyService = ApiClient.getClient().create(IDummyService::class.java)
private lateinit var userList: List<User>
private lateinit var userListFiltered: List<User>

private lateinit var btnTemizle : Button
private lateinit var recyclerView: RecyclerView
private lateinit var btnFilter : Button
private var isFiltered = false

private lateinit var shared : SharedPreferencesClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnTemizle = findViewById(R.id.btn_temizle)
        recyclerView = findViewById(R.id.recyclerView)
        btnFilter = findViewById(R.id.btn_filter)
        shared = SharedPreferencesClass(this@MainActivity,"users_file", MODE_PRIVATE)


        try {
            // program başlayınca verilerimizi çekip listeletiyor

            iDummyService.getAllUsers().enqueue(object : Callback<UsersModel> {
                override fun onResponse(p0: Call<UsersModel>, p1: Response<UsersModel>) {
                    Log.d("onResponse", "Cevap geldi -> ${p1.body()}")
                    p1.body()?.let {
                        userList = it.users

                        val adapter = RecyclerUserAdapter(userList)
                        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 1, GridLayoutManager.VERTICAL, false)
                        recyclerView.adapter = adapter
                    }
                }

                override fun onFailure(p0: Call<UsersModel>, p1: Throwable) {
                    Log.d("onFailure", "Basarisiz -> ${p1.stackTrace}")
                }
            })

        }catch (ex: Exception){
            Log.e("catch", "Catch : Error-> ${ex.stackTrace}")
        }



        btnFilter.setOnClickListener {
            // filtreleme ekranına götürüyor
            val intent = Intent(this@MainActivity, FilterActivity::class.java)
            startActivity(intent)
        }

        btnTemizle.setOnClickListener {
            // tüm verileri tekrar çekiyor
            try {
                iDummyService.getAllUsers().enqueue(object : Callback<UsersModel> {
                    override fun onResponse(p0: Call<UsersModel>, p1: Response<UsersModel>) {
                        Log.d("onResponse", "Cevap geldi -> ${p1.body()}")
                        p1.body()?.let {
                            userList = it.users

                            val adapter = RecyclerUserAdapter(userList)
                            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 1, GridLayoutManager.VERTICAL, false)
                            recyclerView.adapter = adapter
                        }
                    }

                    override fun onFailure(p0: Call<UsersModel>, p1: Throwable) {
                        Log.d("onFailure", "Basarisiz -> ${p1.stackTrace}")
                    }
                })

            }catch (ex: Exception){
                Log.e("catch", "Catch : Error-> ${ex.stackTrace}")
            }

        }

    } // oncreate


    override fun onStart() {
        super.onStart()
        // Burada eğer filtrelenmişse filtreye göre sonuç döndürüyoruz.
        // shared preferences ve Static beraber kullanıldı
        // sadece static veya sadece shared da kullanılabilirdi.

        // kullanıcıyı biraz bekletmemiz gerekecek  bunun için bir loading simgesi koyabilirsin

        if (FilterControl.getIsFiltered()){
            // eğer filtrelenmişse filtreyi shader'dan oku ve apiye gönder
            val temp = shared.getStr("filter")
            val querryKey = FilterControl.getKeyName()
            try {
                iDummyService.getUsersByFilter(querryKey,temp!!).enqueue(object : Callback<UsersModel> {
                    override fun onResponse(p0: Call<UsersModel>, p1: Response<UsersModel>) {
                        Log.d("onResponse", "Cevap geldi -> ${p1.body()}")
                        p1.body()?.let {
                            userListFiltered = it.users
                            val adapter = RecyclerUserAdapter(userListFiltered)
                            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 1, GridLayoutManager.VERTICAL, false)
                            recyclerView.adapter = adapter
                        }
                        // BURADA FİLTREYE UYGUN BİR ŞEY YOK YAZDIRABİLİRSİN
                    }

                    override fun onFailure(p0: Call<UsersModel>, p1: Throwable) {
                        Log.d("onFailure", "Basarisiz -> ${p1.stackTrace}")
                    }
                })

            }catch (ex: Exception){
                Log.e("catch", "Catch : Error-> ${ex.stackTrace}")
            }


        } // End of the if
    } // End of OnStart




}