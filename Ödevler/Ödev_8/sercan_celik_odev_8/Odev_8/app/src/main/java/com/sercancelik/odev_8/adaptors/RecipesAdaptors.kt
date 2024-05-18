package com.sercancelik.odev_8.adaptors

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.sercancelik.odev_8.DetailsActivity
import com.sercancelik.odev_8.R
import com.sercancelik.odev_8.configs.ImageLoader
import com.sercancelik.odev_8.models.Recipe

class RecipesAdaptors(private val context: Activity, private var arr: List<Recipe>) :
    ArrayAdapter<Recipe>(context, R.layout.recipe_row, arr) {

    @SuppressLint("ViewHolder", "MissingInflatedId", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.recipe_row, null, true)
        val dt = arr[position]

        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_title = rootView.findViewById<TextView>(R.id.r_name)
        val r_calories = rootView.findViewById<TextView>(R.id.r_calories)

        r_title.text = dt.name
        r_calories.text = "${dt.caloriesPerServing} calories"
        ImageLoader.loadImage(this.context, dt.image, r_image)


        rootView.setOnClickListener {
            showRecipeDetails(dt.id)
        }

        return rootView
    }

    private fun showRecipeDetails(recipeID: Long) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("recipe_id", recipeID)
        context.startActivity(intent)
    }
}
