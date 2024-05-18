package com.example.myapplication.adaptors
import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Recipe

class RecipeAdaptors(private val context:Activity, private val array : List<Recipe>)
    : ArrayAdapter<Recipe>(context, R.layout.recipes_row, array)
{
    private lateinit var binding: RecipeAdaptors
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.recipes_row, null,true)
        val datas = array.get(position)

        val r_tit : TextView = rootView.findViewById(R.id.r_tit)
        val r_clr : TextView = rootView.findViewById(R.id.r_clr)
        val Dets : Button = rootView.findViewById(R.id.Dets)

        r_tit.setText(data.name)
        r_clr.setText(data.caloriesPerServing.toString())

        Dets.setOnClickListener {
            val intent = Intent(context, ActivityMain2Binding::class.java).apply {
                putExtra("recipe", datas)
            }
            context.startActivity(intent)
        }
        return rootView
    }


}