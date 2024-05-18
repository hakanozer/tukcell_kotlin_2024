package com.beyzaparlak.odev8.adaptors

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.beyzaparlak.odev8.DetailsActivity
import com.beyzaparlak.odev8.R
import com.beyzaparlak.odev8.models.Recipe
import com.google.gson.Gson

class RecipeAdaptors (private val context: Activity, private var arr: List<Recipe>)
    : ArrayAdapter<Recipe>(context, R.layout.recipe_row, arr){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.recipe_row, null, true)
        val dt = arr.get(position)

        val r_image = rootView.findViewById<ImageView>(R.id.r_img)
        val r_title = rootView.findViewById<TextView>(R.id.r_title)
        val r_calorie = rootView.findViewById<TextView>(R.id.r_price)

        // textler içerisine yemek adı ve fiyatlarını atıyorum
        r_title.setText(dt.name)
        r_calorie.setText("${dt.caloriesPerServing} Calorie")

        rootView.setOnClickListener {
            val recipeJson = Gson().toJson(dt)
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("recipeJson", recipeJson)
            context.startActivity(intent)
        }
        return rootView
    }
}