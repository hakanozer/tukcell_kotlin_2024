package com.example.odev_8.adaptors

import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.odev_8.Models.Recipe
import com.example.odev_8.R

class RecipeAdaptors(private val context: Activity, private var arr:List<Recipe>):
ArrayAdapter<Recipe>(context, R.layout.recipe_row,arr){

    override fun getCount(): Int {
        return arr.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView=context.layoutInflater.inflate(R.layout.recipe_row,null,true)
        val dt=arr.get(position)

        Log.d("dt",dt.toString())

        //val r_image=rootView.findViewById<ImageView>(R.id.imageView2)
        val r_title=rootView.findViewById<TextView>(R.id.name)
        val r_price=rootView.findViewById<TextView>(R.id.surname)

        r_title.setText(dt.name)
        r_price.setText("${dt.caloriesPerServing}")

        return  rootView
    }

    fun updateData(newList: List<Recipe>) {
        arr = newList
        notifyDataSetChanged() // Değişiklikleri adapter'a bildir
    }

}