package com.omersungur.omer_sungur_vize_3.presentation.user_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omersungur.omer_sungur_vize_3.R
import com.omersungur.omer_sungur_vize_3.databinding.UserRowBinding
import com.omersungur.omer_sungur_vize_3.domain.model.UserX

class UserListRecyclerAdapter(
    private val context: Context,
    private val userList: List<UserX>
) : RecyclerView.Adapter<UserListRecyclerAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: UserRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val adapterLayout = UserRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return UserViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

        with(holder.binding) {
            tvFirstNameLastName.text = context.getString(R.string.full_name, user.firstName, user.lastName)
            tvBirthdate.text = context.getString(R.string.birthdate_label, user.birthDate)
            tvUsername.text = user.username
            tvContact.text = user.email
            tvAge.text = context.getString(R.string.age_label, user.age.toString())

            Glide.with(holder.itemView).load(user.image).into(ivUser)

            btnDetail.setOnClickListener {
                val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(
                    userDetail = user
                )
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int = userList.size
}