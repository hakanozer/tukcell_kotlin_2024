package com.ns.enesarisoy_odev8.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.ns.enesarisoy_odev8.R
import com.ns.enesarisoy_odev8.model.Recipe

class RecipeAdapter(
    private val context: Context,
    private val recipes: List<Recipe>
): ArrayAdapter<Recipe>(context, R.layout.item_recipe, recipes){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = LayoutInflater.from(context).inflate(R.layout.item_recipe, parent, false)
        val recipe = recipes[position]

        rootView.findViewById<TextView>(R.id.tvRecipeName).text = recipe.name
        rootView.findViewById<TextView>(R.id.tvCalories).text = "${recipe.caloriesPerServing} cal"

        return rootView
    }

}