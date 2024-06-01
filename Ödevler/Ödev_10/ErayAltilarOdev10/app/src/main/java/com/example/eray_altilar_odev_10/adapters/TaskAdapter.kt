package com.example.eray_altilar_odev_10.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eray_altilar_odev_10.R
import com.example.eray_altilar_odev_10.models.Note
import com.example.eray_altilar_odev_10.presentation.homepage.TaskViewHolder

class TaskAdapter(private val notes: MutableList<Note>, private val deleteNote: (Int) -> Unit, private val editNote: (Note) -> Unit) : RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_row, parent, false)
        return TaskViewHolder(view, deleteNote, editNote)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun addNotes(newNotes: List<Note>) {
        notes.clear()  // Eski notları temizle
        notes.addAll(newNotes)  // Yeni notları ekle
        notifyDataSetChanged()  // Adapter'ı güncelle
    }

//    fun addNote(note: Note) {
//        notes.add(note)
//        notifyItemInserted(notes.size - 1)
//    }

    fun removeNote(nid: Int) {
        val position = notes.indexOfFirst { it.nid == nid }
        if (position != -1) {
            notes.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun updateNote(updatedNote: Note) {
        val position = notes.indexOfFirst { it.nid == updatedNote.nid }
        if (position != -1) {
            notes[position] = updatedNote
            notifyItemChanged(position)
        }
    }

}
