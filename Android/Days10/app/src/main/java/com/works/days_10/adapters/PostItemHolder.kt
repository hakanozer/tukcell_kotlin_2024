package com.works.days_10.adapters

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.works.days_10.MainActivity
import com.works.days_10.R
import com.works.days_10.models.Post

class PostItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItem(itemModel: Post) {
        val r_title = itemView.findViewById<TextView>(R.id.r_title)
        val r_userid = itemView.findViewById<TextView>(R.id.r_userid)

        r_title.text = itemModel.title
        r_userid.text = itemModel.userId.toString()

        itemView.setOnClickListener {
            Log.d("bindItem", "onBindViewHolder: click " + itemModel)
            val i = Intent(itemView.context, MainActivity::class.java)
            itemView.context.startActivity(i)
        }
    }

}