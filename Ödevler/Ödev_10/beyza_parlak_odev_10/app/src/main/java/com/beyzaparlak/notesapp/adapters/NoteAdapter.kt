package com.beyzaparlak.notesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.beyzaparlak.notesapp.R
import com.beyzaparlak.notesapp.entities.Note

class NoteAdapter(
    private var notes: MutableList<Note>,
    private val onUpdateClick: (Note) -> Unit,
    private val onDeleteClick: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.findViewById(R.id.noteTitle)
        val noteDetail: TextView = itemView.findViewById(R.id.noteDetail)
        val btnUpdate: Button = itemView.findViewById(R.id.btnUpdate)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)
    }

    // view holder nesnesi item_note.xml temsil eder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    // title ve detail için position ayarlar
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.noteTitle.text = note.title
        holder.noteDetail.text = note.detail
        // güncelleme
        holder.btnUpdate.setOnClickListener {
            onUpdateClick(note)
        }
        // silme
        holder.btnDelete.setOnClickListener {
            onDeleteClick(note)
        }
    }

    // notların sayısı
    override fun getItemCount(): Int = notes.size

    // RecyclerView'ı güncelleme
    fun updateNotes(newNotes: List<Note>) {
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }

}