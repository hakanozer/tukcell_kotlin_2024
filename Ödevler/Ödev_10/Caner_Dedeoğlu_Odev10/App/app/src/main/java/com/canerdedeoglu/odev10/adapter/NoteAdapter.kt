package com.canerdedeoglu.odev10.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.canerdedeoglu.odev10.R
import com.canerdedeoglu.odev10.models.Notes
import com.canerdedeoglu.odev10.services.NoteService

class NoteAdapter(private val context: Context, private val notes: MutableList<Notes>):
    ArrayAdapter<Notes>(context, R.layout.notes_row, notes) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Kullanılan görünümü yeniden kullanma veya yeniden oluşturma
        val view: View = convertView ?: inflater.inflate(R.layout.notes_row, parent, false)

        val data = notes[position]

        val n_title: TextView = view.findViewById(R.id.n_title)
        val n_description: TextView = view.findViewById(R.id.n_description)
        val n_date: TextView = view.findViewById(R.id.n_date)
        val img_delete : ImageView = view.findViewById(R.id.img_delete)

        img_delete.setOnClickListener {
            val noteService = NoteService(context)
            noteService.deleteNote(data.noteId)
            notes.removeAt(position)
            notifyDataSetChanged()
        }

        n_title.text = data.title
        n_description.text = data.description
        n_date.text = data.date

        return view
    }
}
