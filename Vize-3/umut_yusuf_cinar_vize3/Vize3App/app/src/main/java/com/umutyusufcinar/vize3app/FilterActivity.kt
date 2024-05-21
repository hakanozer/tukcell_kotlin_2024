package com.umutyusufcinar.vize3app


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umutyusufcinar.vize3app.configs.ApiClient
import com.umutyusufcinar.vize3app.databinding.ActivityFilterBinding
import com.umutyusufcinar.vize3app.model.User
import com.umutyusufcinar.vize3app.service.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding
    private lateinit var dummyService: DummyService
    var filteredUsers: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                checkButtonState()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        binding.editTextText.addTextChangedListener(textWatcher)
        binding.editTextText2.addTextChangedListener(textWatcher)
        binding.editTextText3.addTextChangedListener(textWatcher)

        //Burada kan grubu için yapılan listeyi çekiyorum
        val bloods = resources.getStringArray(R.array.bloods)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item,bloods)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
        binding.autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener{
                adapterView, view, i, l ->

            val itemSelected = adapterView.getItemAtPosition(i).toString()
            binding.button2.isEnabled = true
        }

        //Burada Geri butonuna basılırken yaşanan aksiyonu gösterir
        binding.button2.setOnClickListener {
            dummyService = ApiClient.getClient().create(DummyService::class.java)

            //Burada İsime göre sorgu yapılıyor
            if (binding.editTextText.text.isNotEmpty()){
                dummyService.getUsersByFirstName(value = binding.editTextText.text.toString()).enqueue(object : Callback<User> {
                    override fun onResponse(p0: Call<User>, p1: Response<User>) {
                        if (p1.isSuccessful) {

                            val user = p1.body()
                            user?.let {
                                filteredUsers = it
                            }
                            val intent = Intent(this@FilterActivity, MainActivity::class.java)
                            intent.putExtra("filteredUsers", filteredUsers)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)
                        }
                    }
                    override fun onFailure(p0: Call<User>, p1: Throwable) {
                        // sonar comment
                    }
                })
            }
            //Burada Soyisime göre sorgu yapılıyor
            else if(binding.editTextText2.text.isNotEmpty()){
                dummyService.getUsersByLastName(value = binding.editTextText2.text.toString()).enqueue(object : Callback<User> {
                    override fun onResponse(p0: Call<User>, p1: Response<User>) {
                        if (p1.isSuccessful) {

                            val user = p1.body()
                            user?.let {
                                filteredUsers = it
                            }
                            val intent = Intent(this@FilterActivity, MainActivity::class.java)
                            intent.putExtra("filteredUsers", filteredUsers)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)
                        }
                    }
                    override fun onFailure(p0: Call<User>, p1: Throwable) {
                        // sonar comment
                    }
                })
            }
            //Burada yaşa göre sorgu yapılıyor
            else if(binding.editTextText3.text.isNotEmpty()){
                dummyService.getUsersByAge(value = binding.editTextText3.text.toString().toInt()).enqueue(object : Callback<User> {
                    override fun onResponse(p0: Call<User>, p1: Response<User>) {
                        if (p1.isSuccessful) {

                            val user = p1.body()
                            user?.let {
                                filteredUsers = it
                            }
                            val intent = Intent(this@FilterActivity, MainActivity::class.java)
                            intent.putExtra("filteredUsers", filteredUsers)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)
                        }
                    }
                    override fun onFailure(p0: Call<User>, p1: Throwable) {
                    }
                })
            }
            //Burada kan grubuna göre sorgu yapılıyor
            else if(binding.autoCompleteTextView.isEnabled){

                binding.autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                    val selectedItem = parent.getItemAtPosition(position)
                    Toast.makeText(this, "Seçilen: $selectedItem", Toast.LENGTH_SHORT).show()

                    dummyService.getUsersByBlood(value = selectedItem.toString()).enqueue(object : Callback<User> {
                        override fun onResponse(p0: Call<User>, p1: Response<User>) {
                            if (p1.isSuccessful) {

                                val user = p1.body()
                                user?.let {
                                    filteredUsers = it
                                }
                                val intent = Intent(this@FilterActivity, MainActivity::class.java)
                                intent.putExtra("filteredUsers", filteredUsers)
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                startActivity(intent)
                            }
                        }
                        override fun onFailure(p0: Call<User>, p1: Throwable) {

                        }
                    })
                }


            }
        }
    }

    //Burada da aynı anda iki filtreleme yapılmaması için bir kontrol
    private fun checkButtonState() {
        val isEditText1Filled = binding.editTextText.text.isNotBlank()
        val isEditText2Filled = binding.editTextText2.text.isNotBlank()
        val isEditText3Filled = binding.editTextText3.text.isNotBlank()

        val filledEditTextsCount = listOf(isEditText1Filled, isEditText2Filled, isEditText3Filled).count { it }

        binding.button2.isEnabled = filledEditTextsCount == 1
    }
}