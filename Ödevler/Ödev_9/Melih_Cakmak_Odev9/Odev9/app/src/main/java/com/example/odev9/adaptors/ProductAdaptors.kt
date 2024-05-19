package com.example.odev9.adaptors

import android.app.Activity

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.odev9.R
import com.example.odev9.models.Product


class ProductAdaptors(
    private val context: Activity,
    private var arr: MutableList<Product>
) : ArrayAdapter<Product>(context, R.layout.product_row, arr) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = convertView ?: context.layoutInflater.inflate(R.layout.product_row, parent, false)
        val dt = arr[position]

        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_title = rootView.findViewById<TextView>(R.id.r_title)
        val r_price = rootView.findViewById<TextView>(R.id.r_price)

        r_title.text = dt.title
        r_price.text = "${dt.price}₺"

        val url = dt.thumbnail
        Glide.with(rootView).load(url).into(r_image)





        return rootView
    }

    fun updateData(newData: List<Product>) {
        arr.addAll(newData) // Yeni verileri mevcut verilere ekle
        notifyDataSetChanged()
    }


}
