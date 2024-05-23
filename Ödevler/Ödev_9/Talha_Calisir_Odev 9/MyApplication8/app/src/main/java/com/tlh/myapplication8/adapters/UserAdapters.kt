package com.tlh.myapplication8.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tlh.myapplication8.R
import com.tlh.myapplication8.models.Users

@Suppress("DEPRECATION")
class UserAdapters(private val context: Activity, private var arr: MutableList<Users>) :
    ArrayAdapter<Users>(context, R.layout.user_row, arr) {

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.user_row, null, true)
        val dt = arr[position]

        val name = rootView.findViewById<TextView>(R.id.name)
        val lastName = rootView.findViewById<TextView>(R.id.lastName)
        val age = rootView.findViewById<TextView>(R.id.age)
        val blood = rootView.findViewById<TextView>(R.id.blood)
        val image = rootView.findViewById<ImageView>(R.id.image)

        name.text = dt.firstName
        lastName.text = dt.lastName
        age.text = dt.age.toString()
        blood.text = dt.bloodGroup

        Glide.with(context)
            .load(dt.image)
            .into(image)


        Log.d("this", "row call")
        return rootView
    }


    fun addUsers(newUsers: List<Users>) {
        arr.addAll(newUsers)
        notifyDataSetChanged()
    }
}
