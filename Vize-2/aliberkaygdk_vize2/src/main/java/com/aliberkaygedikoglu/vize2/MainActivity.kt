package com.aliberkaygedikoglu.vize2

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aliberkaygedikoglu.vize2.databinding.ActivityMainBinding
import com.aliberkaygedikoglu.vize2.models.Plant
import com.aliberkaygedikoglu.vize2.services.XmlService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var list: List<Plant>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //arama girmeden detay butonuna basarsak bloodroot adlı nesne ve özellikleri gelicektir.
        binding.buttonDetail.setOnClickListener {
            if (binding.editTextSearch.text.toString() == "") {

                Toast.makeText(this, "Arama kısmı boş bırakılamaz!", Toast.LENGTH_SHORT).show()
            } else {
                Thread {

                    list = XmlService().xmlReader()
                    val filterlist = list.filter {
                        it.common.lowercase().contains(binding.editTextSearch.text.toString())
                    }
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("common", filterlist.get(0))
                    startActivity(intent)


                }.start()
            }
        }


        //arama edittex boş bırakılıp ara butonuna basılırsa tüm 36 adet eleman bulunuyor. Bunu istemiyoruz. o yüzden bir if-else ekledim
        binding.buttonSearch.setOnClickListener {
            if (binding.editTextSearch.text.toString() == "") {

                Toast.makeText(this, "Arama kısmı boş bırakılamaz!", Toast.LENGTH_SHORT).show()
            } else {
                Thread {

                    list = XmlService().xmlReader()
                    val filterlist = list.filter {
                        it.common.lowercase().contains(binding.editTextSearch.text.toString())
                    }
                    binding.textViewFound.text = "Bulunan : ${filterlist.size}"
                    println(filterlist)

                }.start()
            }

        }

    }
}