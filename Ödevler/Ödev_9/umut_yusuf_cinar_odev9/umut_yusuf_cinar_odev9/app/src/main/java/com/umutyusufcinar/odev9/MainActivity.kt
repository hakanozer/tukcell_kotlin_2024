package com.umutyusufcinar.odev9

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
import com.umutyusufcinar.odev9.adaptors.ProductAdaptors
import com.umutyusufcinar.odev9.configs.ApiClient
import com.umutyusufcinar.odev9.models.Product
import com.umutyusufcinar.odev9.models.Products
import com.umutyusufcinar.odev9.services.IDumyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

//servis nesnesi ve ekranda görüntüleyebilmek için liste tanımlamalarını vb yapacağım
class MainActivity : AppCompatActivity() {
    lateinit var dummyService:IDumyService
    lateinit var arr:MutableList<Product>
    lateinit var list:ListView
    lateinit var textSearch:EditText
    lateinit var productAdaptor:ProductAdaptors
    private var currentPage=0
    private var limit=10
    private var isLoading=true

    //onCreate ile xml elementleriyle eşleştireceğim ve client'ı getireceğim
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list=findViewById(R.id.list)
        textSearch=findViewById(R.id.textSearch)

        dummyService=ApiClient.getClient().create(IDumyService::class.java)

        // başlangıçta boş bir liste varolacak ardından adapter kullanacağım
        arr= mutableListOf()
        productAdaptor= ProductAdaptors(this, arr)
        list.adapter=productAdaptor
        //getListProductForScrolling()


        //Servisten veri geldikçe liste de ekrana geliyor adapter kullanıyorum
        dummyService.getProduct(limit,currentPage).enqueue(object:Callback<Products>{
            override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                if(p1.isSuccessful){
                    val newProducts = p1.body()?.products?: emptyList()
                    arr.addAll(newProducts)
                    Log.d("data",arr.toString())
                    productAdaptor.updateData(arr)

                    Log.d("data uzunluğu",arr.size.toString())
                }
            }

            //servise yönelik hata için şimdilik bir şey yazmayacağım
            override fun onFailure(p0: Call<Products>, p1: Throwable) {

            }

        })


        //getListProductForScrolling() ile her seferinde 10 arttırılarak verilerin gelsin istiyorum
        //burada doğrudan setOnScrollListener kullanacağım
        list.setOnScrollListener(object :AbsListView.OnScrollListener{

            override fun onScrollStateChanged(p0: AbsListView?, p1: Int) {

            }

            override fun onScroll(p0: AbsListView?, p1: Int, p2: Int, p3: Int) {
                if (p1 + p2 >= p3 && p3 > 0) {
                    currentPage+=10
                    //limit+=10
                    getListProductForScrolling()
                    Log.d("kaydırma sonu","en alta gelindi")
                }
            }

        })



        //filtreleme için TextChangeListener yapısını kullanacağım
        //değişim öncesi ve sonrası başka bir ekran veya arka taraf değişikliği olmayacağı için
        //before ve after kısımlarına herhangi bir ekleme yapmayacağım
        textSearch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            //Log.d yi derste kullandığımız gibi kullanıp filtrelenmiş liste için değişken oluşturup
            //adapter kullanıyorum
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("array",arr.toString())
                var filteredList=arr.filter { it.brand.contains(p0!!.toString(),ignoreCase = true) }
                list.adapter=ProductAdaptors(this@MainActivity,filteredList.toMutableList())
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })


    }

    //yukarıda bahsettiğim scrolling için servisten ürün listesini kullanmamı sağlayan fonk.
    fun getListProductForScrolling(){
        dummyService.getProduct(limit,currentPage).enqueue(object:Callback<Products>{
            override fun onResponse(p0: Call<Products>, p1: Response<Products>) {
                if(p1.isSuccessful){
                    val newProducts = p1.body()?.products?: emptyList()
                    arr.addAll(newProducts)
                    Log.d("data",arr.toString())
                    productAdaptor.updateData(arr) //güncellemeyi updateData ile sağladık

                    Log.d("gelecek data uzunluğu ",arr.size.toString())
                }
            }

            override fun onFailure(p0: Call<Products>, p1: Throwable) {
            }

        })

    }


}