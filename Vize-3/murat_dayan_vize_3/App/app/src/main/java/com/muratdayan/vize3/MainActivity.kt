package com.muratdayan.vize3

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.appbar.MaterialToolbar
import com.muratdayan.vize3.adapters.UserAdapter
import com.muratdayan.vize3.components.CustomToast
import com.muratdayan.vize3.configs.ApiClient
import com.muratdayan.vize3.databinding.ActivityMainBinding
import com.muratdayan.vize3.models.User
import com.muratdayan.vize3.models.UsersRespond
import com.muratdayan.vize3.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var iDummyService: IDummyService
    private lateinit var userAdapter: UserAdapter
    lateinit var userList: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolbarMain: MaterialToolbar = binding.materialToolbar
        setSupportActionBar(toolbarMain)

        binding.rvUsers.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)

        iDummyService = ApiClient.getClient().create(IDummyService::class.java)



        val key = intent.getStringExtra("key")
        val value = intent.getStringExtra("value")


        // key ve value boş ise filtresiz boş değil ise filtreli istek atar
        if (value.isNullOrEmpty() || key.isNullOrEmpty()){
            getAllUsers()
        }else{
            binding.filterCard.visibility= View.VISIBLE
            binding.txtFilterName.setText("$key=$value")
            getAllUsersByFilter(key,value)
        }

        binding.filterCard.setOnClickListener {
            clearFilters()
        }

    }


    // servisteki tüm kullanıcıları getirir
    private fun getAllUsers(){
        showControlProgressBar(true)
        iDummyService.getAllUsers().enqueue(object : Callback<UsersRespond> {
            override fun onResponse(p0: Call<UsersRespond>, res: Response<UsersRespond>) {
                if (res.isSuccessful){
                    userList = res.body()!!.users

                    userAdapter = UserAdapter(userList)
                    binding.rvUsers.adapter = userAdapter
                    showControlProgressBar(false)
                }
            }

            override fun onFailure(p0: Call<UsersRespond>, err: Throwable) {
                Log.d("onfailure", err.message.toString())
                CustomToast(this@MainActivity,"Veri alınamıyor",Toast.LENGTH_SHORT).show()
            }

        })
    }

    // key ve value değerlerine göre filtreli veriyi getirir
    private fun getAllUsersByFilter(key:String,value:String){
        showControlProgressBar(true)
        iDummyService.getUsersByFilter(key,value).enqueue(object : Callback<UsersRespond>{
            override fun onResponse(p0: Call<UsersRespond>, res: Response<UsersRespond>) {
                if (res.isSuccessful){
                    val filteredList = res.body()!!.users

                    userAdapter = UserAdapter(filteredList)
                    binding.rvUsers.adapter = userAdapter
                    showControlProgressBar(false)
                    CustomToast(this@MainActivity,"${filteredList.size} users found",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(p0: Call<UsersRespond>, err: Throwable) {
                Log.d("onfailure filter", err.message.toString())
                CustomToast(this@MainActivity,"Veri alınamıyor",Toast.LENGTH_SHORT).show()

            }

        })
    }

    // arama sorgusunda gelen kelimeye göre arama yapar
    private fun getUsersBySearch(searchText:String){
        showControlProgressBar(true)
        iDummyService.getUsersBySearch(searchText).enqueue(object : Callback<UsersRespond>{
            override fun onResponse(p0: Call<UsersRespond>, res: Response<UsersRespond>) {
                if (res.isSuccessful){
                    val searchedList = res.body()!!.users

                    userAdapter = UserAdapter(searchedList)
                    binding.rvUsers.adapter = userAdapter
                    showControlProgressBar(false)
                    binding.filterCard.visibility = View.GONE
                }
            }

            override fun onFailure(p0: Call<UsersRespond>, err: Throwable) {
                Log.d("onfailure filter", err.message.toString())
                CustomToast(this@MainActivity,"Veri alınamıyor",Toast.LENGTH_SHORT).show()
            }

        })
    }

    // filtreleri temizler
    private fun clearFilters(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("CLEAR FILTERS")
        builder.setMessage("are you sure you want to clean the filter")

        builder.setPositiveButton("YES") { dialog, which ->
            binding.filterCard.visibility = View.GONE
            getAllUsers()
        }

        builder.setNegativeButton("CANCEL") { dialog, which ->
            dialog.dismiss()
        }

        builder.show()

    }

    // progress bar görünürlüğünü kontrol eder
    private fun showControlProgressBar(isShow:Boolean){
        if (isShow){
            binding.progressBar.visibility = View.VISIBLE
            binding.rvUsers.visibility = View.GONE
        }else{
            binding.progressBar.visibility = View.GONE
            binding.rvUsers.visibility = View.VISIBLE
        }
    }

    // options menüyü bağlama işlevi
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_options_menu, menu)
        menu?.let {
            val item = it.findItem(R.id.actionSearch)
            val searchView = item.actionView as SearchView
            searchView.isSubmitButtonEnabled =false
            searchView.setOnQueryTextListener(this)



        }
        return true
    }

    // menü item listener
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.actionSearch-> {
                return true
            }
            R.id.actionFilter-> {
                val intent = Intent(this, FilterActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

    // arama işlemi bitince çağrılır
    override fun onQueryTextSubmit(query: String?): Boolean {


        

        return true
    }


    // arama işlemi her harfte çağrılır
    override fun onQueryTextChange(newText: String?): Boolean {
        newText?.let {
            getUsersBySearch(it)

        }

        return true
    }
}