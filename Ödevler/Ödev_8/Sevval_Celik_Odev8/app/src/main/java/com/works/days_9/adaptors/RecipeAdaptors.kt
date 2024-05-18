package com.works.days_9.adaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.works.days_9.R
import com.works.days_9.models.Recipe

class RecipeAdaptors(private val context: Activity, private var arr: List<Recipe>) :
    ArrayAdapter<Recipe>(context, R.layout.recipe_row, arr) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.recipe_row, null, true)
        val dt = arr[position]

        val r_title = rootView.findViewById<TextView>(R.id.r_title)
        val r_price = rootView.findViewById<TextView>(R.id.r_price)

        r_title.text = dt.name
        r_price.text = "${dt.caloriesPerServing}"

        return rootView
    }
}