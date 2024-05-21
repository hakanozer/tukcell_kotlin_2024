package com.example.sinavcalismasi2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sinavcalismasi2.FilterActivity
import com.example.sinavcalismasi2.adaptors.UserAdaptor
import com.example.sinavcalismasi2.configs.ApiClient
import com.example.sinavcalismasi2.models.User
import com.example.sinavcalismasi2.models.Users
import com.example.sinavcalismasi2.services.IDummyServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var dummyService: IDummyServices
    //lateinit var filtereddummyService:IDummyServices

    lateinit var arr:List<User>
    lateinit var userAdaptor: UserAdaptor
    lateinit var list: ListView
    lateinit var button: Button

    var FILTER_REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list=findViewById(R.id.listView)
        button=findViewById(R.id.button)


        dummyService= ApiClient.getClient().create(IDummyServices::class.java) // Sayfa ilk açıldığında çağırılan servis, ana liste için
        dummyService.getUsers().enqueue(object : Callback<Users> {
            override fun onResponse(p0: Call<Users>, p1: Response<Users>) {
                if(p1.isSuccessful){
                    arr=p1.body()!!.users
                    Log.d("users",arr.size.toString())
                    userAdaptor= UserAdaptor(this@MainActivity,arr)
                    list.adapter=userAdaptor

                }

            }

            override fun onFailure(p0: Call<Users>, p1: Throwable) {
                Log.e("hata",p1.message!!)
            }

        })

        //filterService()

        button.setOnClickListener { // Butona basınca filtre sayfasına gider
            val i= Intent(this, FilterActivity::class.java)
            startActivityForResult(i,FILTER_REQUEST_CODE)
            //FILTER_REQUEST_CODE++
        }

    }

    // OnResume ile de sharedPreferences kullanılarak veriler kaydedilebilir
    /*override fun onResume() {
        super.onResume()
        val sharedPreferences = getSharedPreferences("FilterPrefs", Context.MODE_PRIVATE)
        val filterType = sharedPreferences.getString("filterType", null)
        val filterText = sharedPreferences.getString("filterText", null)



        if (!filterType.isNullOrEmpty() && !filterText.isNullOrEmpty()) {
            Log.d("filtertypesecond", filterType)
            Log.d("filtertextsecond", filterText)
            filterService(filterType, filterText)
        }
    }*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { // Filtre sayfasına FILTER_REQUEST_CODE ile geçiş yapıyoruz ve bir değer beklediğimizi belirtiyoruz
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == FILTER_REQUEST_CODE && resultCode == RESULT_OK) {
            val filterType = data?.getStringExtra("filterType")
            val filterText = data?.getStringExtra("filterText")
            Log.d("filtertypesecond", filterType.toString())
            Log.d("filtertextsecond", filterText.toString())

            //filterService()

            val filteredList = arr.filter { user -> // Parametrelere göre filtreleme işlemi için filterService çağırılıyor
                when (filterType) {
                    "firstName" -> {filterService(filterType,filterText)
                        true
                    }//user.firstName.contains(filterText ?: "", ignoreCase = true)
                    "lastName" -> {filterService(filterType,filterText)
                        true
                    }//user.lastName.contains(filterText ?: "", ignoreCase = true)
                    "age" -> {filterService(filterType,filterText)
                        true
                    }//user.age.toString().contains(filterText ?: "", ignoreCase = true)
                    "bloodGroup" -> {filterService(filterType,filterText)
                        true
                    }//user.bloodGroup.contains(filterText ?: "", ignoreCase = true)


                    else -> true
                }
            }

            Log.d("filterlist",filteredList.toString())
            Log.d("filterlistszie",filteredList.size.toString())


            userAdaptor = UserAdaptor(this, filteredList) // Artık filtrelenmiş listeyi görmek istediğimiz için adapter'a listeyi veriyoruz

            list.adapter = userAdaptor
        }
    }

    fun filterService(key:String?,value:String?){
        //dummyService=ApiClient.getClient().create(IDummyServices::class.java)
        dummyService.getUsersFilter(key,value).enqueue(object : Callback<Users> {
            override fun onResponse(p0: Call<Users>, p1: Response<Users>) {
                if(p1.isSuccessful){
                    val dt=p1.body()!!.users
                    Log.d("filterservice",dt.toString())
                    Log.d("filterservice",dt.size.toString())
                    userAdaptor= UserAdaptor(this@MainActivity,dt)
                    list.adapter=userAdaptor

                }

            }

            override fun onFailure(p0: Call<Users>, p1: Throwable) {
                Log.e("hatafiltered",p1.message!!)
            }

        })
    }

}