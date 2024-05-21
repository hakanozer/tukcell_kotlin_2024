package com.aliberkaygedikoglu.vize3practices.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aliberkaygedikoglu.vize3practices.R
import com.aliberkaygedikoglu.vize3practices.databinding.RecyclerItemBinding
import com.aliberkaygedikoglu.vize3practices.model.User
import com.bumptech.glide.Glide

class UsersAdapter(private val list : List<User>): RecyclerView.Adapter<UsersAdapter.ModelViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.ModelViewHolder {
        val binding =RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return ModelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersAdapter.ModelViewHolder, position: Int) {

        val person = list[position]
        holder.itemBinding.userName.text="${person.firstName} ${person.lastName}"
        holder.itemBinding.age.text = "Age: ${person.age}"
        holder.itemBinding.blood.text = person.bloodGroup

        Glide.with(holder.itemBinding.root).load(person.image).into(holder.itemBinding.imageView)




    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ModelViewHolder(val itemBinding: RecyclerItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {


    }
}