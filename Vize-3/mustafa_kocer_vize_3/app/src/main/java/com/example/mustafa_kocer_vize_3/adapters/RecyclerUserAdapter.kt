package com.example.mustafa_kocer_vize_3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mustafa_kocer_vize_3.R
import com.example.mustafa_kocer_vize_3.models.User

class RecyclerUserAdapter(val userList: List<User>):
RecyclerView.Adapter<RecyclerUserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerUserViewHolder {
        // row'u oluştur
        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return RecyclerUserViewHolder(rowView)
    }

    override fun getItemCount(): Int {
        // kac eleman gosterilecek
        return userList.size
    }

    override fun onBindViewHolder(holder: RecyclerUserViewHolder, position: Int) {
        // rowlara elemanlarini bagla veya
        holder.bindItem(userList.get(position))
        // bunun icin ViewHolder'daki bindItem fonksiyonuna gonderiyorum

    }


}