package com.example.sinavcalismasi2.adaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sinavcalismasi2.R
import com.example.sinavcalismasi2.models.User

class UserAdaptor(private val context: Activity, private var arr:List<User>):
    ArrayAdapter<User>(context, R.layout.layout_row,arr){

    override fun getCount(): Int {
        return arr.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.layout_row, null, true)
        val dt = arr.get(position)

        val userName = rootView.findViewById<TextView>(R.id.userName)
        val age = rootView.findViewById<TextView>(R.id.age)
        val blood = rootView.findViewById<TextView>(R.id.blood)
        val image=rootView.findViewById<ImageView>(R.id.imageView)


        userName.setText(dt.firstName + " " + dt.lastName)
        age.setText(dt.age.toString())
        blood.setText(dt.bloodGroup)

        val url=dt.image
        Glide.with(rootView).load(url).into(image)

        return rootView


    }

}