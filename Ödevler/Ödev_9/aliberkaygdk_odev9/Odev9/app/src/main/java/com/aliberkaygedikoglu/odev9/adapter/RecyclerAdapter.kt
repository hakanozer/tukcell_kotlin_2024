package com.aliberkaygedikoglu.odev9.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aliberkaygedikoglu.odev9.R
import com.aliberkaygedikoglu.odev9.databinding.RecyclerItemBinding
import com.aliberkaygedikoglu.odev9.model.Product

class RecyclerAdapter(private val list: List<Product>,private val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val product = list[position]

        holder.itemBinding.productTitle.text=product.title
        holder.itemBinding.productPrice.text=product.price.toString()
        holder.itemBinding.productBrand.text = product.brand


    }
    class ViewHolder(val itemBinding: RecyclerItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {


    }
}