package com.works.days_9.adaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.works.days_9.R
import com.works.days_9.models.User

class UserAdaptors(private val context: Activity, private var arr: List<User>) :
    ArrayAdapter<User>(context, R.layout.user_row, arr)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.user_row, null, true)
        val dt = arr.get(position)

        val r_title = rootView.findViewById<TextView>(R.id.r_title)
        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_age = rootView.findViewById<TextView>(R.id.r_age)
        val r_blood = rootView.findViewById<TextView>(R.id.r_blood)

        r_title.text = dt.username
        r_age.text = dt.age.toString()
        r_blood.text=dt.bloodGroup

        val url = dt.image
        Glide.with(rootView).load(url).into(r_image)


        return rootView
    }
}