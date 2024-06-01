package com.example.odev10.adapter

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.odev10.NoteActivity
import com.example.odev10.R
import com.example.odev10.UpdatePage
import com.example.odev10.models.Notes
import com.example.odev10.services.ContactServiceNotes

class NoteAdapterHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    lateinit var lessons:List<Notes>
    lateinit var adapter:NoteAdapter
    val contactService= ContactServiceNotes(itemView.context)

    fun bindItem(itemModel: Notes){
        val r_id=itemView.findViewById<TextView>(R.id.lessonId)
        val r_lessonName=itemView.findViewById<TextView>(R.id.lessonName)
        val r_lessonNote=itemView.findViewById<TextView>(R.id.lessonNote)
        val r_delete=itemView.findViewById<Button>(R.id.deletebutton)
        val r_update=itemView.findViewById<Button>(R.id.updatebutton)


        r_id.text=itemModel.id.toString()
        r_lessonName.text=itemModel.lessonName
        r_lessonNote.text=itemModel.note.toString()

        itemView.setOnClickListener {
            Log.d("Tık","Listede şuna tıklandı : "+itemModel.id)

        }

        r_delete.setOnClickListener {
            contactService.deleteNote(itemModel.id)
            Log.d("lessons silindi",lessons.toString())
            adapter.notifyDataSetChanged()
            //val i= Intent(itemView.context,NoteActivity::class.java)
            //itemView.context.startActivity(i)

        }

        r_update.setOnClickListener {
            val i=Intent(itemView.context,UpdatePage::class.java)
            i.putExtra("noteId",itemModel.id)
            itemView.context.startActivity(i)
        }


    }
}