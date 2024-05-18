package com.example.odev_8.adaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.odev_8.R
import com.example.odev_8.models.Recipe

class RecipeAdaptors (private val context: Activity, private var arr: List<Recipe>) :
    ArrayAdapter<Recipe>(context, R.layout.recipe_row, arr)
{
    override fun getCount(): Int {
        return arr.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.recipe_row, null, true)
        val dt = arr.get(position)

        val r_name = rootView.findViewById<TextView>(R.id.r_name)
        val r_caloriesPerServing = rootView.findViewById<TextView>(R.id.r_caloriesPerServing)

        r_name.setText(dt.name)
        r_caloriesPerServing.setText("${dt.caloriesPerServing}")
        return rootView
    }

}