package com.example.odev10.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.odev10.R
import com.example.odev10.entitie.Note
class NoteAdapter(
    private var notes: List<Note>,
    private val onDeleteClick: (note: Note) -> Unit,
    private val onEditClick: (note: Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var originalNotes: List<Note> = notes.toList()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.note_title)
        val contentTextView: TextView = itemView.findViewById(R.id.note_content)
        val deleteButton: Button = itemView.findViewById(R.id.btnDelete)
        val editButton: Button = itemView.findViewById(R.id.btnEdit)

        init {
            deleteButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onDeleteClick(notes[position])
                }
            }

            editButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onEditClick(notes[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_note,
            parent,
            false
        )
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notes[position]
        holder.titleTextView.text = currentNote.title
        holder.contentTextView.text = currentNote.content
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun updateNotes(newNotes: List<Note>) {
        notes = newNotes
        originalNotes = newNotes.toList()
        notifyDataSetChanged()
    }

    fun searchNotes(query: String) {
        val filteredNotes = mutableListOf<Note>()
        originalNotes.forEach { note ->
            if (note.title.contains(query, true) || note.content.contains(query, true)) {
                filteredNotes.add(note)
            }
        }
        notes = filteredNotes
        notifyDataSetChanged()
    }
}