package com.tlh.foods.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.tlh.foods.databinding.FoodRecyclerRowBinding
import com.tlh.foods.model.Food
import com.tlh.foods.util.downloadImage
import com.tlh.foods.util.makePlaceHolder
import com.tlh.foods.view.FoodlistFragmentDirections

class FoodRecyclerAdapter(val foodList : ArrayList<Food>) : RecyclerView.Adapter<FoodRecyclerAdapter.FoodViewHolder>() {

    class FoodViewHolder(var view : FoodRecyclerRowBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val recyclerRowBinding: FoodRecyclerRowBinding = FoodRecyclerRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateFoodList(newFoodList: List<Food>){
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {

        holder.view.name.text = foodList[position].foodName
        holder.view.calorie.text = foodList[position].foodCalorie

        holder.itemView.setOnClickListener {
            val action = FoodlistFragmentDirections.actionFoodlistFragment2ToFoodDetailFragment3(
                foodList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }

        holder.view.imageView.downloadImage(foodList.get(position).foodImage, makePlaceHolder(holder.itemView.context))

    }


}