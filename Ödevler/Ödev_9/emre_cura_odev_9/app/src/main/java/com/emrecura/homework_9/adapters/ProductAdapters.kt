package com.emrecura.homework_9.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.emrecura.homework_9.R
import com.emrecura.homework_9.models.Product


class ProductAdapters(private val context: Activity, private var arr: List<Product>) :
    ArrayAdapter<Product>(context, R.layout.product_row) {

    override fun getCount(): Int {
        return arr.count()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.product_row, null, true)
        val dt = arr.get(position)
        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_title = rootView.findViewById<TextView>(R.id.r_title)
        val r_price = rootView.findViewById<TextView>(R.id.r_price)

        Glide.with(rootView).load(dt.images.get(0)).into(r_image)
        r_title.setText(dt.title)
        r_price.setText("${dt.price}$")

        return rootView
    }



}