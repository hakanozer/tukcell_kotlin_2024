package com.muratdayan.vize3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muratdayan.vize3.R
import com.muratdayan.vize3.databinding.UserRowBinding
import com.muratdayan.vize3.models.User

class UserAdapter(
    private var userList: List<User>
) : RecyclerView.Adapter<UserAdapter.UserRowHolder>() {

    // user row bağlğanması
    inner class UserRowHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = UserRowBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRowHolder {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return UserRowHolder(design)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserRowHolder, position: Int) {

        val user = userList[position]

        holder.binding.userRowTxtFirstName.setText(user.firstName)
        holder.binding.userRowTxtLastName.setText(user.lastName)

        // resimlerin Glide ile çekilmesi
        Glide.with(holder.binding.root).load(user.image).into(holder.binding.userRowImgView)



    }
    }