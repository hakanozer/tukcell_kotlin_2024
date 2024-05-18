package com.umutyusufcinar.odev8recipeapp.adaptors

import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.umutyusufcinar.odev8recipeapp.models.Recipe
import com.umutyusufcinar.odev8recipeapp.R

class RecipeAdaptors(private val context: Activity, private var arr:List<Recipe>):
    ArrayAdapter<Recipe>(context, R.layout.recipe,arr){

    override fun getCount(): Int {
        return arr.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView=context.layoutInflater.inflate(R.layout.recipe,null,true)
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