package com.aliberkaygedikoglu.odev8.adapter

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.aliberkaygedikoglu.odev8.DetailActivity
import com.aliberkaygedikoglu.odev8.R
import com.aliberkaygedikoglu.odev8.databinding.ListviewItemBinding
import com.aliberkaygedikoglu.odev8.model.Recipe

class RecipesAdaptor(private val context:Activity,private val arr: List<Recipe>)
    : ArrayAdapter<Recipe>(context, R.layout.listview_item,arr) {

        lateinit var binding: ListviewItemBinding
        val hashMap: HashMap<Int,Boolean> = HashMap()



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val binding = ListviewItemBinding.inflate(context.layoutInflater)
        val view = binding.root

        val item = arr.get(position)


        for (i in arr.indices){
            hashMap[i]
        }
        if (hashMap[position] ==true){
            view.setBackgroundColor(Color.RED)
        }

        binding.recipeName.setText(item.name)
        binding.recipePrice.setText(item.caloriesPerServing.toString())

        view.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("detail",item)
            if (hashMap[position] == true){
                view.setBackgroundColor(Color.TRANSPARENT)

                hashMap[position] = false

            }else{
                view.setBackgroundColor(Color.RED)
                hashMap[position] = true

            }

            context.startActivity(intent)
        }

        return view
    }

}