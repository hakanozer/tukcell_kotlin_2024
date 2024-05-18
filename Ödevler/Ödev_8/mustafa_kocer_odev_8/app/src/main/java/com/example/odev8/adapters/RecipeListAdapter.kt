package com.example.odev8.adapters

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.odev8.DetailActivity
import com.example.odev8.R
import com.example.odev8.models.Recipe

class RecipeListAdapter(private val context:Activity, private var arr : List<Recipe>):ArrayAdapter<Recipe>(context, R.layout.recipe_row, arr){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.recipe_row, null, true)
        /*
Data nerede önemli bir durum var.
Burası bir for loop'tur
Arr yapısı her çalıştığında bu fonksiyon da çalışacak
// her bir liste elemanı için bu fonksiyon çalışmalı
 */
        val dt = arr.get(position)
        val imgView = rootView.findViewById<ImageView>(R.id.imgView)
        val txtName = rootView.findViewById<TextView>(R.id.txtName)
        val txtCalories = rootView.findViewById<TextView>(R.id.txtCalories)

        txtName.text = dt.name.toString()
        txtCalories.text = "${dt.caloriesPerServing} Calories"

        val url = dt.image
        Glide.with(rootView).load(url).into(imgView)

        rootView.setOnClickListener {
            // detay aktiviteye gidilecek
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("selectedObject", dt)
            context.startActivity(intent)

        }

        return rootView
    }

}