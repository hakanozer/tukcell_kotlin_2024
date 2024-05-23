package com.example.listegzersiz.adaptors

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.listegzersiz.R
import com.example.listegzersiz.models.Product

class ProductAdaptors(private val context:Activity,private var arr:MutableList<Product>):ArrayAdapter<Product>(context,
    R.layout.row,arr) {

    //private var filteredList: List<Product> = arr.toMutableList()


    //private val selectedItems = mutableSetOf<Int>()
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("selected_items_prefs", Context.MODE_PRIVATE)


    fun updateData(newProducts: List<Product>) {
        arr.addAll(newProducts)
        notifyDataSetChanged()
    }

    fun filterList(text:String){
        //arr.clear()
        //arr.addAll(filteredProducts)
        //clear()
        //arr.
        var filteredList = arr.filter { it.brand.contains(text, ignoreCase = true) }
        Log.d("filter",filteredList.toString())
        Log.d("filterlength",filteredList.size.toString())
        arr.addAll(filteredList)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return super.getFilter()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView=context.layoutInflater.inflate(R.layout.row,null,true)
        val dt=arr.get(position)

        val name=rootView.findViewById<TextView>(R.id.name)
        val surname=rootView.findViewById<TextView>(R.id.surname)
        val image=rootView.findViewById<ImageView>(R.id.image)

        name.setText(dt.brand)
        surname.setText(dt.price.toString())

        val url=dt.thumbnail
        Glide.with(rootView).load(url).into(image)

//        if (selectedItems.contains(position)) {
//            rootView.setBackgroundColor(Color.RED)
//        } else {
//            rootView.setBackgroundColor(Color.TRANSPARENT)
//        }
//
//
//        rootView.setOnClickListener {
//            if (selectedItems.contains(position)) {
//                selectedItems.remove(position)
//                rootView.setBackgroundColor(Color.TRANSPARENT)
//            } else {
//                selectedItems.add(position)
//                rootView.setBackgroundColor(Color.RED)
//            }
//            notifyDataSetChanged() // Adaptörü yenileyin
//        }

        if (sharedPreferences.getBoolean(position.toString(), false)) {
            rootView.setBackgroundColor(Color.RED)
        } else {
            rootView.setBackgroundColor(Color.TRANSPARENT)
        }

        rootView.setOnClickListener {
            val editor = sharedPreferences.edit()
            if (sharedPreferences.getBoolean(position.toString(), false)) {
                editor.remove(position.toString())
                rootView.setBackgroundColor(Color.TRANSPARENT)
            } else {
                editor.putBoolean(position.toString(), true)
                rootView.setBackgroundColor(Color.RED)
            }
            editor.apply()
        }


        //Log.d("selectedItems",selectedItems.toString())
//        rootView.setOnClickListener {
//            it.setBackgroundColor(Color.RED)
//        }

        return rootView

    }
}