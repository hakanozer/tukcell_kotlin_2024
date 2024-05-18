package com.example.eray_altilar_odev_8.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.eray_altilar_odev_8.DetailActivity
import com.example.eray_altilar_odev_8.R
import com.example.eray_altilar_odev_8.model.Recipe
import com.google.gson.Gson

class RecipeAdaptor(private val context: Context, private var arr: List<Recipe>) :
    ArrayAdapter<Recipe>(context, R.layout.recipe_row, arr) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val rootView = convertView ?: inflater.inflate(R.layout.recipe_row, parent, false)
        val dt = arr[position]

        val rName = rootView.findViewById<TextView>(R.id.txtName)
        val rCaloriesPerServing = rootView.findViewById<TextView>(R.id.txtCaloriesPerServing)

        rName.text = dt.name
        rCaloriesPerServing.text = "${dt.caloriesPerServing} kcal"

        rootView.setOnClickListener {
            val dt = arr[position]

            val recipeJson = Gson().toJson(dt)

            // DetailActivity'ye yönlendir
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("recipe", recipeJson)
            context.startActivity(intent)
        }

        return rootView
    }
}
