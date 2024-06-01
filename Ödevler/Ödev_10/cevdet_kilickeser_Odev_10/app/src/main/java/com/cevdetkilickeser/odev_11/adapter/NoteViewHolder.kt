package com.cevdetkilickeser.odev_11.adapter

import android.content.Intent
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cevdetkilickeser.odev_11.DetailActivity
import com.cevdetkilickeser.odev_11.MainActivity
import com.cevdetkilickeser.odev_11.databinding.RowNoteBinding
import com.cevdetkilickeser.odev_11.entity.Notte

class NoteViewHolder(private var binding: RowNoteBinding, private val activity: MainActivity) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(itemModel: Notte) {

        binding.tvTitle.text = itemModel.title
        binding.tvDetail.text = itemModel.detail
        val userId = itemModel.userId

        binding.row.setOnClickListener {
            val intent = Intent(activity,DetailActivity::class.java)
            intent.putExtra("notte",itemModel)
            intent.putExtra("userId",userId)
        }
    }
}
