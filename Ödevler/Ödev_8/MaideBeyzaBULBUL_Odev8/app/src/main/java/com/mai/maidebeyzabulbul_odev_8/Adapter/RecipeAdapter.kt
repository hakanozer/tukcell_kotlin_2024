package com.mai.maidebeyzabulbul_odev_8.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.mai.maidebeyzabulbul_odev_8.R
import com.mai.maidebeyzabulbul_odev_8.models.RecipeElement


class RecipeAdapter(context: Context, private var recipes: ArrayList<RecipeElement>) : ArrayAdapter<RecipeElement>(context, 0, recipes) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val recipe = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_recipe, parent, false)
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val caloriesTextView: TextView = view.findViewById(R.id.caloriesTextView)
        nameTextView.text = recipe?.name
        caloriesTextView.text = "Calories: ${recipe?.caloriesPerServing}"
        return view
    }

    fun updateRecipes(newRecipes: List<RecipeElement>) {
        recipes.clear()
        recipes.addAll(newRecipes)
        notifyDataSetChanged()
    }
}