package com.cevdetkilickeser.odev8.adapter

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.cevdetkilickeser.odev8.DetailActivity
import com.cevdetkilickeser.odev8.R
import com.cevdetkilickeser.odev8.model.Recipe

class RecipeAdapter(private val context: Activity, private var arr: List<Recipe>) :
    ArrayAdapter<Recipe>(context, R.layout.row_recipe, arr) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.row_recipe, null, true)
        val recipe = arr.get(position)

        val row = rootView.findViewById<LinearLayout>(R.id.row)
        val rowImg = rootView.findViewById<ImageView>(R.id.imgRow)
        val rowName = rootView.findViewById<TextView>(R.id.txtName)
        val rowCal = rootView.findViewById<TextView>(R.id.txtCal)

        Glide.with(rowImg).load(recipe.image).into(rowImg)
        rowName.text = recipe.name
        rowCal.text = recipe.caloriesPerServing.toString() + " Kcal"
        row.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("recipe", recipe)
            context.startActivity(intent)
        }

        return rootView
    }
}