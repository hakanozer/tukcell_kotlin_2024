package com.example.odev9.adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.odev9.R
import com.example.odev9.models.Product

class ProductAdapter(private val context: Activity, private var arr: MutableList<Product>) : ArrayAdapter<Product>(context, R.layout.product_row, arr) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.product_row, parent, false)
        val dt = arr.get(position)
        val image = rootView.findViewById<ImageView>(R.id.rowImage)

        val title = rootView.findViewById<TextView>(R.id.rowTitle)
        title.setText(dt.title.toString())

        val price = rootView.findViewById<TextView>(R.id.rowPrice)
        price.setText("Price: "+dt.price.toString())

        val url = dt.thumbnail
        Glide.with(rootView).load(url).into(image)

        return rootView
    }
}