package com.example.odev_8

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev_8.Models.Recipe
import android.util.Log
import android.widget.TextView


class Details : AppCompatActivity() {
    lateinit var textName:TextView
    lateinit var ingredients:TextView
    lateinit var instructions:TextView
    lateinit var prepTimeMinutes:TextView
    lateinit var cookTimeMinutes:TextView
    lateinit var servings:TextView
    lateinit var difficulty:TextView
    lateinit var cuisine:TextView
    lateinit var caloriesPerServing:TextView
    lateinit var tags:TextView
    lateinit var userId:TextView
    lateinit var rating:TextView
    lateinit var reviewCount:TextView
    lateinit var mealType:TextView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recipeDetails=intent.getSerializableExtra("recipe") as Recipe
        Log.d("deneme",recipeDetails.toString())

        textName=findViewById(R.id.textName)
        ingredients=findViewById(R.id.ingredients)
        instructions=findViewById(R.id.instructions)
        prepTimeMinutes=findViewById(R.id.prepTimeMinutes)
        cookTimeMinutes=findViewById(R.id.cookTimeMinutes)
        servings=findViewById(R.id.servings)
        difficulty=findViewById(R.id.difficulty)
        cuisine=findViewById(R.id.cuisine)
        caloriesPerServing=findViewById(R.id.caloriesPerServing)
        tags=findViewById(R.id.tags)
        userId=findViewById(R.id.userId)
        rating=findViewById(R.id.rating)
        reviewCount=findViewById(R.id.reviewCount)
        mealType=findViewById(R.id.mealType)


        textName.text=recipeDetails.name
        ingredients.text=recipeDetails.ingredients.toString()
        instructions.text=recipeDetails.instructions.toString()
        prepTimeMinutes.text=recipeDetails.prepTimeMinutes.toString()+" dakika"
        cookTimeMinutes.text=recipeDetails.cookTimeMinutes.toString()+" dakika"
        servings.text=recipeDetails.servings.toString()
        difficulty.text=recipeDetails.difficulty.toString()
        cuisine.text=recipeDetails.cuisine.toString()
        caloriesPerServing.text=recipeDetails.caloriesPerServing.toString()
        tags.text=recipeDetails.tags.toString()
        userId.text=recipeDetails.userId.toString()
        rating.text=recipeDetails.rating.toString()
        reviewCount.text=recipeDetails.reviewCount.toString()
        mealType.text=recipeDetails.mealType.toString()







    }


}