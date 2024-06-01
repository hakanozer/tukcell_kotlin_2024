package com.example.odev10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.odev10.R
import com.example.odev10.models.Notes

class NoteAdapter(val list:List<Notes>):RecyclerView.Adapter<NoteAdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapterHolder {
        return NoteAdapterHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_row,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NoteAdapterHolder, position: Int) {
        holder.bindItem(list.get(position))
    }


}