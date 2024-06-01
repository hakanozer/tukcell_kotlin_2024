package com.example.yusuf_mucahit_solmaz_odev_10.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yusuf_mucahit_solmaz_odev_10.R
import com.example.yusuf_mucahit_solmaz_odev_10.db.entitiy.NoteDao
import com.example.yusuf_mucahit_solmaz_odev_10.db.service.NoteService
import com.example.yusuf_mucahit_solmaz_odev_10.ui.UpdateNoteActivity


class NoteAdapter(val noteList:List<NoteDao>):RecyclerView.Adapter<NoteAdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapterHolder {
        return NoteAdapterHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_row,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteAdapterHolder, position: Int) {
        holder.bindItem(noteList.get(position))
    }

}

class NoteAdapterHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    lateinit var adapter: NoteAdapter
    val contactService = NoteService(itemView.context)

    @SuppressLint("NotifyDataSetChanged")
    fun bindItem(itemModel: NoteDao) {
        val noteTitle = itemView.findViewById<TextView>(R.id.noteTitle)
        val noteText = itemView.findViewById<TextView>(R.id.noteText)
        val deleteBtn = itemView.findViewById<Button>(R.id.deleteBtn)
        val updateBtn = itemView.findViewById<Button>(R.id.updateBtn)


        noteTitle.text = itemModel.noteTitle
        noteText.text = itemModel.note

        deleteBtn.setOnClickListener {
            contactService.deleteNoteById(itemModel.id)
            adapter.notifyDataSetChanged()

        }

        updateBtn.setOnClickListener {
            val intent = Intent(itemView.context, UpdateNoteActivity::class.java)
            intent.putExtra("noteId", itemModel.id)
            itemView.context.startActivity(intent)
        }


    }
}

