package com.example.mustafakocerodev10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mustafakocerodev10.R
import com.example.mustafakocerodev10.dao.NotesDao
import com.example.mustafakocerodev10.entity.Notes

class RecyclerNotesAdapter(private val noteList: MutableList<Notes>) :
    RecyclerView.Adapter<NotesViewHolder>() {
    private lateinit var notesDao: NotesDao


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        val viewHolder = NotesViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {

        return noteList.size

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        holder.bindNotes(noteList[position])

    }

}

