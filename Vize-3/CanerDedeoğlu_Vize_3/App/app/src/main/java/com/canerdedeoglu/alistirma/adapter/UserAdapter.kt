package com.canerdedeoglu.alistirma.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.canerdedeoglu.alistirma.R
import com.canerdedeoglu.alistirma.models.User

class UserAdapter (private val context : Activity, private val arr : List<User>)
    : ArrayAdapter<User>(context, R.layout.user_row,arr)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.user_row, null, true)
        val data = arr.get(position)

        val u_image : ImageView = rootView.findViewById(R.id.u_image)
        val u_name : TextView = rootView.findViewById(R.id.u_name)
        val u_lastName : TextView = rootView.findViewById(R.id.u_lastname)
        val u_age : TextView = rootView.findViewById(R.id.u_age)

        u_name.setText(data.firstName)
        u_lastName.setText(data.lastName)
        u_age.setText("${data.age.toString()} yaş")

        val url = data.image
        Glide.with(rootView).load(url).into(u_image)

        return rootView
    }
}