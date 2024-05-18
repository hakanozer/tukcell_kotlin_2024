package com.emrecura.homework8.adaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.emrecura.homework8.R
import com.emrecura.homework8.models.Recipe

class RecipeAdaptors(private val context : Activity, private var list: List<Recipe>) :
ArrayAdapter<Recipe>(context, R.layout.recipe_row, list)
{
    override fun getCount(): Int {
        return list.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.recipe_row, null,true)
        val recipe = list.get(position)

        val recipe_image = rootView.findViewById<ImageView>(R.id.recipeImage)
        val recipe_name = rootView.findViewById<TextView>(R.id.recipeName)
        val recipe_difficulty = rootView.findViewById<TextView>(R.id.recipeDifficulty)
        val recipe_rating = rootView.findViewById<TextView>(R.id.ratingText)
        val recipe_duration = rootView.findViewById<TextView>(R.id.durationText)

        recipe_name.setText(recipe.name)
        recipe_difficulty.setText("Difficulty : ${recipe.difficulty}")
        recipe_rating.setText("Rate : ${recipe.rating.toString()}")
        recipe_duration.setText("Min : ${recipe.cookTimeMinutes.toString()}")
        Glide.with(context)
            .load(recipe.image)
            .into(recipe_image)

        return rootView
    }
}

