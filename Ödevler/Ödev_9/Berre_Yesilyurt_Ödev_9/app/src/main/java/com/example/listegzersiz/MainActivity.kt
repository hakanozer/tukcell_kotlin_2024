package com.example.listegzersiz

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.AbsListView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listegzersiz.adaptors.ProductAdaptors
import com.example.listegzersiz.configs.ApiClient
import com.example.listegzersiz.models.Product
import com.example.listegzersiz.models.Products
import com.example.listegzersiz.services.IDumyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var dummyService:IDumyService
    lateinit var arr:MutableList<Product>
    lateinit var list:ListView
    lateinit var textSearch:EditText
    lateinit var productAdaptor:ProductAdaptors
    private var currentPage=0
    private var limit=10
    private var isLoading=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list=findViewById(R.id.list)
        textSearch=findViewById(R.id.textSearch)

        dummyService=ApiClient.getClient().create(IDumyService::class.java)

        // İlk olarak boş liste oluşturuldu
        arr= mutableListOf()
        productAdaptor= ProductAdaptors(this, arr)
        list.adapter=productAdaptor
        //getListProduct()


        //Servisteki veri geldikçe ekrana liste de geliyor
        dummyService.getProduct(limit,currentPage).enqueue(object:Callback<Products>{
            override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                if(p1.isSuccessful){
                    val newProducts = p1.body()?.products?: emptyList()
                    arr.addAll(newProducts)
                    //arr=p1.body()!!.products
                    Log.d("data",arr.toString())
                    //productAdaptor=ProductAdaptors(this@MainActivity,arr)
                    productAdaptor.updateData(arr)

                    Log.d("uzunluk ",arr.size.toString())
                }
            }

            override fun onFailure(p0: Call<Products>, p1: Throwable) {

            }

        })


        //Scroll sona geldiği zaman getListProduct() ile her seferinde 10 arttırılarak verilerin gelmesi beklenir
        list.setOnScrollListener(object :AbsListView.OnScrollListener{

            override fun onScrollStateChanged(p0: AbsListView?, p1: Int) {

            }

            override fun onScroll(p0: AbsListView?, p1: Int, p2: Int, p3: Int) {
                if (p1 + p2 >= p3 && p3 > 0) {
                    currentPage+=10
                    //limit+=10
                    getListProduct()
                    Log.d("son","sona gelindi")
                }
            }

        })



// Filtreleme yapmak için
        textSearch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("array",arr.toString())
                var filteredList=arr.filter { it.brand.contains(p0!!.toString(),ignoreCase = true) }
                //productAdaptor.filterList(filteredList)
                //Log.d("liste",filteredList.toString())
                //productAdaptor.updateData(filteredList)
                list.adapter=ProductAdaptors(this@MainActivity,filteredList.toMutableList())
                //productAdaptor.filter.filter(p0)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })


    }

    fun getListProduct(){
        dummyService.getProduct(limit,currentPage).enqueue(object:Callback<Products>{
            override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                if(p1.isSuccessful){
                    val newProducts = p1.body()?.products?: emptyList()
                    arr.addAll(newProducts)
                    //arr=p1.body()!!.products
                    Log.d("data",arr.toString())
                    //productAdaptor=ProductAdaptors(this@MainActivity,arr)
                    productAdaptor.updateData(arr)

                    Log.d("uzunluk ",arr.size.toString())
                }
            }

            override fun onFailure(p0: Call<Products>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }


}