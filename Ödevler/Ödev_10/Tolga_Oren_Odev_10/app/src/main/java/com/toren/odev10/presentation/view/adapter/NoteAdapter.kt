package com.toren.odev10.presentation.view.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.toren.odev10.R
import com.toren.odev10.databinding.NoteRowBinding
import com.toren.odev10.domain.model.Note

class NoteAdapter(
    private val noteList: MutableList<Note>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>()
{

    inner class NoteViewHolder(val binding: NoteRowBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(noteList[position])
            }
        }

        fun getColor(position: Int): Int {
            return when (position % 10) {
                0 -> ContextCompat.getColor(itemView.context, R.color.cardColor0)
                1 -> ContextCompat.getColor(itemView.context, R.color.cardColor1)
                2 -> ContextCompat.getColor(itemView.context, R.color.cardColor2)
                3 -> ContextCompat.getColor(itemView.context, R.color.cardColor3)
                4 -> ContextCompat.getColor(itemView.context, R.color.cardColor4)
                5 -> ContextCompat.getColor(itemView.context, R.color.cardColor5)
                6 -> ContextCompat.getColor(itemView.context, R.color.cardColor6)
                7 -> ContextCompat.getColor(itemView.context, R.color.cardColor7)
                8 -> ContextCompat.getColor(itemView.context, R.color.cardColor8)
                9 -> ContextCompat.getColor(itemView.context, R.color.cardColor9)
                else -> ContextCompat.getColor(itemView.context, R.color.cardColorDefault)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.noteListTitle.text = noteList[position].title
        holder.binding.noteListContent.text = noteList[position].note

        holder.binding.rowCardView.setCardBackgroundColor(holder.getColor(position))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateNotes(newNotes: List<Note>) {
        noteList.clear()
        noteList.addAll(newNotes)
        notifyDataSetChanged()
    }
}