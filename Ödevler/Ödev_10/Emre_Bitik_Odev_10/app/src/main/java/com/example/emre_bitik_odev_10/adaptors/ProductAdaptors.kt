package com.example.emre_bitik_odev_10.adaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.emre_bitik_odev_10.R
import com.example.emre_bitik_odev_10.models.Note

class ProductAdaptors(private val context: Activity, private val arr:List<Note>)
    : ArrayAdapter<Note>(context,R.layout.product_row)
{
    override fun getCount(): Int {
        return arr.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView =context.layoutInflater.inflate(R.layout.product_row,null,true)

        val dt =arr.get(position)
        val r_title: TextView = rootView.findViewById(R.id.r_title)
        val r_detail: TextView = rootView.findViewById(R.id.r_detail)
        r_title.text = dt.title
        r_detail.text = dt.details



        return rootView
    }


}