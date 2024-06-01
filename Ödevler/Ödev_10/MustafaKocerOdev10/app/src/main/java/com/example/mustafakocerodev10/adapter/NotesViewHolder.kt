package com.example.mustafakocerodev10.adapter

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mustafakocerodev10.R
import com.example.mustafakocerodev10.activitiy.DetailsActivity
import com.example.mustafakocerodev10.entity.Notes
import com.google.gson.Gson

class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindNotes(notes: Notes) {
        val title = itemView.findViewById<TextView>(R.id.rowTitle)
        val description = itemView.findViewById<TextView>(R.id.rowDesc)
        val date = itemView.findViewById<TextView>(R.id.rowDate)
        date.text = notes.creationDate
        title.text = notes.title
        description.text = notes.description

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, DetailsActivity::class.java)
            val gson = Gson()
            val stNotes = gson.toJson(notes)

            intent.putExtra("detailObj", stNotes)
            itemView.context.startActivity(intent)
        }

    }

}