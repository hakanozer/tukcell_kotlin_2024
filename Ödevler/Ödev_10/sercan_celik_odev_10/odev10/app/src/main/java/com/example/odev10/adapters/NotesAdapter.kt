package com.example.odev10.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.odev10.R
import com.example.odev10.models.Note

class NotesAdapter(val notes: MutableList<Note>) : RecyclerView.Adapter<NoteViewHolder>() {

    var onItemClick: ((Note) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_card_item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notes[position]
        holder.titleTextView.text = currentNote.title
        holder.contentTextView.text = currentNote.content
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentNote)
        }
    }

    override fun getItemCount() = notes.size
}

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView = itemView.findViewById(R.id.tv_note_title)
    val contentTextView: TextView = itemView.findViewById(R.id.tv_note_content)
}
