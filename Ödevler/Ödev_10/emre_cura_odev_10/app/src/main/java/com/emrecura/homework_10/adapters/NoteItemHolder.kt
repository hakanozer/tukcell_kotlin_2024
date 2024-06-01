package com.emrecura.homework_10.adapters

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.emrecura.homework_10.R
import com.emrecura.homework_10.model.NoteModel
import com.emrecura.homework_10.presentation.DetailActivity

class NoteItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItem(itemModel: NoteModel){
        val n_title = itemView.findViewById<TextView>(R.id.titleTextView)
        val n_details = itemView.findViewById<TextView>(R.id.detailTextView)

        n_title.text = itemModel.title
        n_details.text = itemModel.detail

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("clickedNote", itemModel)
            itemView.context.startActivity(intent)
        }

    }
}