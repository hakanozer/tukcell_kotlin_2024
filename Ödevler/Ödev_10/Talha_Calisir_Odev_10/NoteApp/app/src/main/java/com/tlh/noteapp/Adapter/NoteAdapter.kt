package com.tlh.noteapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tlh.noteapp.databinding.NoteRowBinding
import com.tlh.noteapp.model.Note

class NoteAdapter(private val noteList: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val binding: NoteRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val recyclerRowBinding =
            NoteRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(recyclerRowBinding)
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.binding.titleText.text = noteList[position].noteTitle
        holder.binding.bodyText.text = noteList[position].noteMain

    }

    override fun getItemCount(): Int {
        return noteList.size

    }


}