package com.muratdayan.odev10.presentation.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.muratdayan.odev10.R
import com.muratdayan.odev10.databinding.NoteRowBinding
import com.muratdayan.odev10.models.Note

class NotesAdapter(
    private val itemListeners: ItemListeners
) : RecyclerView.Adapter<NotesAdapter.NoteRowHolder>() {
    private var notesList = listOf<Note>()
    private var detailVisibility = false

    inner class NoteRowHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = NoteRowBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteRowHolder {
        val designRow =
            LayoutInflater.from(parent.context).inflate(R.layout.note_row, parent, false)
        return NoteRowHolder(designRow)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: NoteRowHolder, position: Int) {
        val note = notesList[position]

        // get color işlemleri
        holder.binding.noteRowTxtTitle.text = note.title
        val highColor = ContextCompat.getColor(holder.binding.root.context, R.color.myGreen)
        val mediumColor = ContextCompat.getColor(holder.binding.root.context, R.color.myPink)

        // checkbox işlemleri
        when (note.isDone) {
            1 -> {
                holder.binding.noteRowTxtTitle.paintFlags =
                    holder.binding.noteRowTxtTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                holder.binding.imgViewArrowDropIcon.visibility = View.INVISIBLE
            }

            0 -> {
                holder.binding.noteRowTxtTitle.paintFlags = 0
                holder.binding.imgViewArrowDropIcon.visibility = View.VISIBLE
            }
        }

        when (note.priority) {
            1 -> holder.binding.consLayoutNoteRow.setBackgroundColor(highColor)
            2 -> holder.binding.consLayoutNoteRow.setBackgroundColor(mediumColor)
        }

        holder.binding.imgViewArrowDropIcon.setOnClickListener {
            detailVisibility = !detailVisibility
            if (detailVisibility) {

                // animation
                holder.binding.txtNoteDetail.apply {
                    text = note.detail
                    visibility = View.VISIBLE
                    alpha = 0f
                    translationY = 50f
                    animate()
                        .alpha(1f)
                        .translationY(0f)
                        .setDuration(300)
                        .setListener(null)
                }
                holder.binding.txtNoteRowDate.apply {
                    text = note.date
                    visibility = View.VISIBLE
                    alpha = 0f
                    translationY = 50f
                    animate()
                        .alpha(1f)
                        .translationY(0f)
                        .setDuration(300)
                        .setListener(null)
                }
            } else {
                holder.binding.txtNoteDetail.visibility = View.GONE
                holder.binding.txtNoteRowDate.visibility = View.GONE
            }

        }

        // itemlere tıklama işlemleri
        holder.binding.root.setOnClickListener {
            val isLongPresssed=itemListeners.onItemClick(note)
            if (!isLongPresssed){
                holder.binding.root.setBackgroundColor(Color.WHITE)
            }
        }

        holder.binding.root.setOnLongClickListener {
            val isLongPresssed =itemListeners.onLongItemClick(note)
            if (isLongPresssed){
                holder.binding.root.setBackgroundColor(Color.RED)
            }
            true
        }
    }

    // search , sort gibi işlemlerden sonra listeyi günceller
    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<Note>) {
        notesList = newList
        notifyDataSetChanged()
    }
}

// itemlere uzun ve kısa tıklama işlemleri için interface
interface ItemListeners {
    fun onLongItemClick(note: Note): Boolean
    fun onItemClick(note: Note) : Boolean
}