package com.works.days_10.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.works.days_10.R
import com.works.days_10.models.Post

class PostAdapter(val list: List<Post>) :
RecyclerView.Adapter<PostItemHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemHolder {
        return PostItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostItemHolder, position: Int) {
        holder.bindItem(list.get(position))
        /*
        holder.itemView.setOnClickListener {
            Log.d("click", "onBindViewHolder: click")
        }
         */
    }


}