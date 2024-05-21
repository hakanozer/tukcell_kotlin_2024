package com.mai.maidebeyzabulbul_vize3.adapter

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import com.mai.maidebeyzabulbul_vize3.R
import com.mai.maidebeyzabulbul_vize3.models.User
import com.squareup.picasso.Picasso

class UserAdapter(context: Context, users: List<User>) : ArrayAdapter<User>(context, 0, users) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)
        }

        val user = getItem(position)
        if (user != null) {
            val userImage = view?.findViewById<ImageView>(R.id.userImage)
            val userName = view?.findViewById<TextView>(R.id.userName)

            Picasso.get().load(user.image).into(userImage)
            userName?.text = "${user.firstName} ${user.lastName}"
        }

        return view!!
    }
}

