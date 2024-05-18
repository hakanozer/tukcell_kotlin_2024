package com.muratdayan.odev8.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.muratdayan.odev8.DetailActivity
import com.muratdayan.odev8.R
import com.muratdayan.odev8.models.Recipe
import com.squareup.picasso.Picasso
import java.io.Serializable

class RecipeAdapter(
    private val context:Activity,
    private var recipeList:List<Recipe>
) : ArrayAdapter<Recipe>(
    context,
    R.layout.recipe_item,
    recipeList
) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.recipe_item,null,true)
        val recipe = recipeList.get(position)

        val recipeName: TextView = rootView.findViewById(R.id.recipeItemTxtName)
        val recipeCaloriesPerServing : TextView = rootView.findViewById(R.id.recipeItemTxtCaloriesPerSaving)
        val recipeImgView : ImageView = rootView.findViewById(R.id.recipeItemImgView)

        recipeName.setText(recipe.name)
        recipeCaloriesPerServing.setText(recipe.caloriesPerServing.toString())

        // itemdeki imageview'a Picasso sayesinde resmi yerleştirme işlemi
        Picasso.get()
            .load(recipe.image)
            .into(recipeImgView)

        /*
        // mevcut item'e tıklandığında detay sayfasına gider ve mevcut itemi gönderir
        rootView.setOnClickListener {
            // DetailActivity'e geçiş yap
            val intent = Intent(context, DetailActivity::class.java)
            // Seçilen öğenin ID'sini intent ile gönder
            intent.putExtra("recipe", recipe)
            // Activity'yi başlat
            context.startActivity(intent)
        }
        */


        return rootView
    }


}