package com.omersungur.omer_sungur_odev_10.presentation.note_list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.snackbar.Snackbar
import com.omersungur.omer_sungur_odev_10.databinding.RowNoteBinding
import com.omersungur.omer_sungur_odev_10.domain.model.Note
import com.omersungur.omer_sungur_odev_10.domain.repository.util.RoomOperation

class NoteListAdapter(
    private val noteList: List<Note>,
    private val onClickListener: RoomOperation
) : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

    class NoteViewHolder(val binding: RowNoteBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = RowNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = noteList[position]

        holder.binding.apply {

            tvRowNoteTitle.text = note.title
            tvRowNoteContent.text = note.description

            ivDeleteNote.setOnClickListener {
                Snackbar.make(
                    it,
                    "Seçilen Notu Silmek İstiyor Musunuz?",
                    Snackbar.LENGTH_LONG
                )
                    .setAction("EVET") {
                        onClickListener.deleteNote(note)
                        Toast.makeText(holder.itemView.context, "Not Başarıyla Silindi!", Toast.LENGTH_SHORT).show()
                    }.setActionTextColor(0xFF22FF22.toInt())
                    .show()
            }

            imageView.setOnClickListener {
                val noteArg = Note(note.id, note.title, note.description)

                val action = NoteListFragmentDirections.actionNoteListFragmentToNoteDetailFragment(noteArg)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}