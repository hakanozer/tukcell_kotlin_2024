package com.tlh.classicrecipe.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tlh.classicrecipe.R
import com.tlh.classicrecipe.RecipeDetailsActivity
import com.tlh.classicrecipe.model.Recipe

class RecipeAdapter(private val context: Activity, private val array: List<Recipe>) :
    ArrayAdapter<Recipe>(context, R.layout.recipe_row, array) {
    @SuppressLint("ViewHolder", "InflateParams")


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.recipe_row, null, true)
        val arrayData = array[position]

        val rowName: TextView = rootView.findViewById(R.id.recipe_name)
        val rowCalories: TextView = rootView.findViewById(R.id.recipe_calories)
        val buttonDetails: TextView = rootView.findViewById(R.id.details_button)
        val imageView: ImageView = rootView.findViewById(R.id.recipe_image)

        rowName.text = arrayData.name
        rowCalories.text = arrayData.caloriesPerServing.toString()

        Glide.with(context)
            .load(arrayData.image)
            .into(imageView)


        buttonDetails.setOnClickListener {
            val intent =Intent(context, RecipeDetailsActivity::class.java).apply {
                putExtra("recipe", arrayData)
            }
            context.startActivity(intent)
        }

        return rootView



    }

}