package com.canerdedeoglu.days_9.adaptors

import android.app.Activity
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.canerdedeoglu.days_9.R
import com.canerdedeoglu.days_9.models.Product

class ProductAdaptors(private val context : Activity, private var arr : List<Product>) :ArrayAdapter<Product>(context, R.layout.product_row, arr)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.product_row, null, true)
        val dt = arr.get(position)

        val r_image : ImageView = rootView.findViewById(R.id.r_image)
        val r_title : TextView = rootView.findViewById(R.id.r_title)
        val r_price : TextView = rootView.findViewById(R.id.r_price)

        r_title.setText(dt.title)
        r_price.setText("${dt.price} ₺")

        val url = dt.thumbnail
        Glide.with(rootView).load(url).into(r_image)

        return rootView
    }

}