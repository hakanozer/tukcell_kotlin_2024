package com.ns.enesarisoy_odev11.presentation.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ns.enesarisoy_odev11.R
import com.ns.enesarisoy_odev11.model.Note
import kotlin.random.Random

class NoteAdapter(private var notes: MutableList<Note>, private val listener: OnNoteClickListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val colors = arrayOf(
        Color.parseColor("#D9E8FC"),
        Color.parseColor("#FFD8F4"),
        Color.parseColor("#B0E9CA"),
        Color.parseColor("#FDE99D"),
        Color.parseColor("#FCFAD9"),
        Color.parseColor("#FFEADD")
    )

    fun updateNotes(notes: List<Note>) {
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.titleTextView.text = note.title
        holder.contentTextView.text = note.content
        holder.cardView.setCardBackgroundColor(colors[position % colors.size])

        holder.itemView.setOnClickListener {
            listener.onNoteClick(note)
        }
        holder.itemView.setOnLongClickListener {
            Snackbar.make(it, "Not silinsin mi??", Snackbar.LENGTH_LONG)
                .setAction("Sil") {
                    listener.onNoteLongClick(note)
                }
                .show()
            true
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.noteTitle)
        val contentTextView: TextView = itemView.findViewById(R.id.noteContent)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    interface OnNoteClickListener {
        fun onNoteClick(note: Note)
        fun onNoteLongClick(note: Note)
    }

}