package com.works.days_9.adaptors


import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.works.days_9.R
import com.works.days_9.models.Product
import android.app.Activity

class ProductAdaptors(private val context: Activity, private var arr: List<Product>) :
    ArrayAdapter<Product>(context, R.layout.product_row, arr) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        val rootView: View

        if (convertView == null) {
            val inflater = context.layoutInflater
            rootView = inflater.inflate(R.layout.product_row, parent, false)

            viewHolder = ViewHolder()
            viewHolder.rImage = rootView.findViewById(R.id.r_image)
            viewHolder.rTitle = rootView.findViewById(R.id.r_title)
            viewHolder.rPrice = rootView.findViewById(R.id.r_price)

            rootView.tag = viewHolder
        } else {
            rootView = convertView
            viewHolder = rootView.tag as ViewHolder
        }

        val dt = arr[position]
        viewHolder.rTitle?.text = dt.title
        viewHolder.rPrice?.text = "${dt.price}₺"

        val url = dt.thumbnail
        viewHolder.rImage?.let { Glide.with(context).load(url).into(it) }

        return rootView
    }

    private class ViewHolder {
        var rImage: ImageView? = null
        var rTitle: TextView? = null
        var rPrice: TextView? = null
    }
}
