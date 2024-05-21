package com.cevdetkilickeser.cevdetkilickeservize3.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cevdetkilickeser.cevdetkilickeservize3.R
import com.cevdetkilickeser.cevdetkilickeservize3.model.User

class UserAdapter(private val context: Activity, private var arr: List<User>) :
    ArrayAdapter<User>(context, R.layout.user_row, arr) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.user_row, null, true)
        val user = arr.get(position)

        val rowFirstname = rootView.findViewById<TextView>(R.id.txtRowFirstname)
        val rowLastname = rootView.findViewById<TextView>(R.id.txtRowLastname)
        val rowAge = rootView.findViewById<TextView>(R.id.txtRowAge)
        val rowBlood = rootView.findViewById<TextView>(R.id.txtRowBlood)
        val rowImg = rootView.findViewById<ImageView>(R.id.imgRowImg)

        Glide.with(rootView).load(user.image).apply(RequestOptions.circleCropTransform()).into(rowImg)
        rowFirstname.text = user.firstName
        rowLastname.text = user.lastName
        rowAge.text = "Yaş : " + user.age.toString()
        rowBlood.text = "Kan Grubu : " + user.bloodGroup

        return rootView
    }
}