package com.emrecura.homework_10.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.emrecura.homework_10.R
import com.emrecura.homework_10.model.NoteModel
import com.emrecura.homework_10.presentation.DetailActivity

class NoteAdapter(var list: List<NoteModel>) : RecyclerView.Adapter<NoteItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemHolder {

        return NoteItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_row, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NoteItemHolder, position: Int) {
        holder.bindItem(list.get(position))

    }
    fun updateList(newList: List<NoteModel>) {
        list = newList
        notifyDataSetChanged()
    }
}