package com.ns.enesarisoy_vize3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ns.enesarisoy_vize3.adapter.UserAdapter
import com.ns.enesarisoy_vize3.configs.ApiClient
import com.ns.enesarisoy_vize3.databinding.ActivityMainBinding
import com.ns.enesarisoy_vize3.model.User
import com.ns.enesarisoy_vize3.model.UserResponse
import com.ns.enesarisoy_vize3.services.UserService
import com.ns.enesarisoy_vize3.util.gone
import com.ns.enesarisoy_vize3.util.visible
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: UserAdapter = UserAdapter()

    // OnResume için resultIntent tanımlandı
    private var resultIntent: Intent? = null
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    // Pagination işlemleri için tanımlamalar yapıldı
    private var isLoading = false
    private var userList = mutableListOf<User>()
    private var limit = 10
    private var skip = 0
    private var total = 0

    private lateinit var userServices: UserService

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

        binding.rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvUsers.adapter = adapter

        userServices = ApiClient.getClient().create(UserService::class.java)


        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                resultIntent = result.data
            }
        }

        // Pagination
        binding.rvUsers.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    if (userList.size < total) {
                        loadMoreProducts()
                    }
                }
            }
        })

        // Detay'a gitmek için
        adapter.setOnItemClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("user", it)
            startActivity(intent)
        }

        loadMoreProducts()
        initClick()
    }

    override fun onResume() {
        super.onResume()
        resultIntent?.let {
            val users = it.getSerializableExtra("users") as? UserResponse

            // Gelen intenti kontrol ediyorum
            users?.let { userResponse ->
                adapter.clearUsers()
                adapter.setUsers(userResponse.users)
                isLoading = users.users.size < total

                binding.llClearFilter.visible()
                binding.tvClearFilter.setOnClickListener {
                    clearFilter()
                }

            } ?: run {
                // Intent boşsa bütün listeyi tekrar yüklüyorum
                binding.llClearFilter.gone()
                clearFilter()
            }
        }

    }

    private fun clearFilter() {
        adapter.clearUsers()
        userList.clear()
        binding.llClearFilter.gone()
        total = 0
        skip = 0
        loadMoreProducts()
    }

    // Pagination işlemleri
    private fun loadMoreProducts() {
        isLoading = true
        adapter.addLoadingFooter()

        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)

            val call = userServices.getUsers(limit, skip)

            call.enqueue(object : Callback<UserResponse> {
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    adapter.removeLoadingFooter()
                    if (response.isSuccessful) {
                        response.body()?.let {
                            userList.addAll(it.users)
                            adapter.setUsers(it.users)
                            skip += limit
                            total = it.total
                        }
                    }
                    isLoading = false
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    adapter.removeLoadingFooter()
                    isLoading = false
                }
            })
        }
    }

    private fun initClick() {
        binding.llFilter.setOnClickListener {
            resultIntent = Intent(this, FilterActivity::class.java)
            resultLauncher.launch(resultIntent!!)
        }
    }
}