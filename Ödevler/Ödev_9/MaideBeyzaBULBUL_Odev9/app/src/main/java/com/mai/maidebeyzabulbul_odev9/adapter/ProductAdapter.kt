package com.mai.maidebeyzabulbul_odev9.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.mai.maidebeyzabulbul_odev9.R
import com.mai.maidebeyzabulbul_odev9.models.ProductElement

class ProductAdapter(context: Context, private val products: MutableList<ProductElement>) : ArrayAdapter<ProductElement>(context, 0, products) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val product = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        view.findViewById<TextView>(R.id.productTitle).text = product?.title
        view.findViewById<TextView>(R.id.productDescription).text = product?.description
        view.findViewById<TextView>(R.id.productPrice).text = product?.price.toString()
        return view
    }
}