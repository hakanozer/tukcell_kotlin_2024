package com.bengisusahin.odev_10.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bengisusahin.odev_10.R
import com.bengisusahin.odev_10.databinding.RecyclerRowNoteBinding
import com.bengisusahin.odev_10.models.Note

class NoteAdapter(private var notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var onNoteClick: ((Note) -> Unit)? = null

    // inner class can access to the outer class properties
    // because access to the onNoteClick this is inner class
    inner class NoteViewHolder(val binding: RecyclerRowNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(note: Note) {
            binding.recyclerViewNoteTitle.text = note.title
            binding.recyclerViewNoteDate.text = note.date
            binding.recyclerViewNoteContent.text = note.content
        }
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onNoteClick?.invoke(notes[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = RecyclerRowNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindItem(notes[position])
    }

    fun updateNotes(newNotes: List<Note>) {
        this.notes = newNotes
        notifyDataSetChanged()
    }
}