package com.example.eray_altilar_odev_10.presentation.homepage

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eray_altilar_odev_10.R
import com.example.eray_altilar_odev_10.models.Note

class TaskViewHolder(itemView: View, private val deleteNote: (Int) -> Unit, private val editNote: (Note) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val txtTaskTitle: TextView = itemView.findViewById(R.id.txtTaskTitle)
    private val imgDelete: ImageView = itemView.findViewById(R.id.btnDeleteNote)

    fun bind(note: Note) {
        txtTaskTitle.text = note.noteTitle
        imgDelete.setOnClickListener {
            deleteNote(note.nid)
        }
        itemView.setOnClickListener {
            editNote(note)
        }
    }
}
