package com.selincengiz.selin_cengiz_odev10.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.selincengiz.selin_cengiz_odev10.databinding.ItemNoteBinding
import com.selincengiz.selin_cengiz_odev10.domain.entities.NotesUI

class NoteAdapter(private val itemListener: ItemListener) :
    ListAdapter<NotesUI, NoteAdapter.NoteViewHolder>(NoteDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
        NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), itemListener
        )

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) =
        holder.bind(getItem(position))

    class NoteViewHolder(
        private val binding: ItemNoteBinding,
        private val listener: ItemListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(note: NotesUI) = with(binding) {
            tvBody.text = note.body
            tvTitle.text = note.title
            root.setOnClickListener {
                listener.onClicked(note)
            }
        }

    }

    class NoteDiffCallBack : DiffUtil.ItemCallback<NotesUI>() {
        override fun areItemsTheSame(oldItem: NotesUI, newItem: NotesUI): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NotesUI, newItem: NotesUI): Boolean {
            return oldItem == newItem
        }

    }
}

interface ItemListener {
    fun onClicked(note: NotesUI)
}
