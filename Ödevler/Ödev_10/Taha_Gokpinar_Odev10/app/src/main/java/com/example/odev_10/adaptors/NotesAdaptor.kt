package com.example.odev_10.adaptors

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.odev_10.EditNote
import com.example.odev_10.NotesActivity
import com.example.odev_10.R
import com.example.odev_10.models.Note
import com.example.odev_10.services.NoteService

class NotesAdaptor(private val context: Activity, private val notesList: List<Note>) :
    ArrayAdapter<Note>(context, R.layout.note_row, notesList) {

    private val noteService = NoteService(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.note_row, null, true)

        val titleTextView = rootView.findViewById<TextView>(R.id.textViewNoteTitle)
        val contentTextView = rootView.findViewById<TextView>(R.id.textViewNoteContent)
        val editButton = rootView.findViewById<ImageButton>(R.id.btnEditNote)
        val deleteButton = rootView.findViewById<ImageButton>(R.id.btnDeleteNote)

        val note = notesList[position]

        titleTextView.text = note.title
        contentTextView.text = note.content

        editButton.setOnClickListener {
            val intent = Intent(context, EditNote::class.java)
            intent.putExtra("note", note)
            context.startActivity(intent)
        }

        deleteButton.setOnClickListener {
            deleteNoteDialog(note)
        }

        rootView.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Note Details")
            builder.setMessage("Title: ${note.title}  \n" +
                               "Content: ${note.content}")
            builder.setPositiveButton("OK") { dialog, which ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }


        return rootView
    }

    private fun deleteNoteDialog(note: Note) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Delete Note")
        builder.setMessage("Are you sure you want to delete this note?")

        builder.setPositiveButton("Yes") { dialog, which ->
            val deleteStatus = noteService.deleteNote(note.nid)
            if (deleteStatus > 0) {
                Toast.makeText(context, "Note deleted successfully", Toast.LENGTH_SHORT).show()
                reloadNotes()
            } else {
                Toast.makeText(context, "Failed to delete note", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setNegativeButton("No") { dialog, which ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun reloadNotes() {
        val notesActivity = context as NotesActivity
        notesActivity.loadNotes()
    }
}