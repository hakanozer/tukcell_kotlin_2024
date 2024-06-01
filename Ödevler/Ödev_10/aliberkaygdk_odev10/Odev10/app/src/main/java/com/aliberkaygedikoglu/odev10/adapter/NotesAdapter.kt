package com.aliberkaygedikoglu.odev10.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliberkaygedikoglu.odev10.DetailActivity
import com.aliberkaygedikoglu.odev10.databinding.RecyclerItemBinding
import com.aliberkaygedikoglu.odev10.entity.UserNote
import com.aliberkaygedikoglu.odev10.room.DB


class NotesAdapter(list : List<UserNote>): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    private var listData: MutableList<UserNote> = list as MutableList<UserNote>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = listData[position]
        holder.binding.name.text = note.name
        holder.binding.detail.text = note.detail

        holder.binding.delete.setOnClickListener {
            val database = DB.getDatabase(holder.binding.root.context)
            database?.userNoteDao()?.delete(note)

            deleteItem(position)


        }
        holder.binding.detail.setOnClickListener {
            val intent = Intent(holder.binding.root.context,DetailActivity::class.java)
            intent.putExtra("note",note)
            holder.binding.root.context.startActivity(intent)
        }

    }

    class ViewHolder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    fun deleteItem(index: Int){
        listData.removeAt(index)
        notifyDataSetChanged()
    }

}