package com.cevdetkilickeser.odev_11.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cevdetkilickeser.odev_11.MainActivity
import com.cevdetkilickeser.odev_11.databinding.RowNoteBinding
import com.cevdetkilickeser.odev_11.entity.Notte


class NotteAdapter(private val noteList: List<Notte>, private val activity: MainActivity) : RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = RowNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding,activity)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val notte = noteList[position]
        holder.bindItem(notte)
    }


    override fun getItemCount(): Int {
        return noteList.size
    }
}