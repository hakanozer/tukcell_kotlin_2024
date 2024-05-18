package com.example.emre_bitik_odev_8.adaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.emre_bitik_odev_8.R
import com.example.emre_bitik_odev_8.models.Recipe

class ProductAdaptors(private val context: Activity,private val arr:List<Recipe>)
    : ArrayAdapter<Recipe>(context,R.layout.product_row)
{
    override fun getCount(): Int {
        return arr.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView =context.layoutInflater.inflate(R.layout.product_row,null,true)

        val dt =arr.get(position)
        val r_name: TextView = rootView.findViewById(R.id.r_name)
        val r_caloriesPerServing: TextView = rootView.findViewById(R.id.r_caloriesPerServing)
        r_name.setText(dt.name)
        r_caloriesPerServing.setText("${dt.caloriesPerServing}")


        return rootView.rootView
    }


}