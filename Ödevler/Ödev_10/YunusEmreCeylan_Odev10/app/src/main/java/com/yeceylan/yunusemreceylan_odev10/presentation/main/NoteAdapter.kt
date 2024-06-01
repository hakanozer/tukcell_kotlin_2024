package com.yeceylan.yunusemreceylan_odev10.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeceylan.yunusemreceylan_odev10.databinding.NoteItemBinding
import com.yeceylan.yunusemreceylan_odev10.model.entity.Note
import java.text.SimpleDateFormat
import java.util.*

class NoteAdapter(private var notes: List<Note>, private val onEdit: (Note) -> Unit, private val onDelete: (Note) -> Unit) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int = notes.size

    fun updateNotes(newNotes: List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }

    inner class NoteViewHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.tvTitle.text = note.title
            binding.tvContent.text = note.content
            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
            val dateString = dateFormat.format(Date(note.timestamp))
            binding.timeStamp.text = dateString
            binding.btnEdit.setOnClickListener { onEdit(note) }
            binding.btnDelete.setOnClickListener { onDelete(note) }
        }
    }
}

