package com.toren.odev8.ui.adapter

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.toren.odev8.R
import com.toren.odev8.model.Recipe
import com.toren.odev8.databinding.RecipesRowBinding
import com.toren.odev8.ui.activity.DetailActivity

class RecipesAdapter (
    val context: Activity,
    val recipes: MutableList<Recipe>
): ArrayAdapter<Recipe>(context, R.layout.recipes_row, recipes){

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val binding =
                RecipesRowBinding.inflate(context.layoutInflater, parent, false)


            binding.rowRecipeNameTw.text = recipes[position].name
            binding.rowCaloriesTw.text = "${recipes[position].caloriesPerServing.toString()} kcal"

            binding.layout.setOnClickListener{
                val i = Intent(context, DetailActivity::class.java)
                i.putExtra("recipe", recipes[position])
                context.startActivity(i)
            }

            return binding.root
    }

    fun updateRecipes(recipeList: List<Recipe>) {
        recipes.clear()
        recipes.addAll(recipeList)
        notifyDataSetChanged()
    }
}