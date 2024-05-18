package com.example.emre_bitik_odev_8

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class DetailActivity : AppCompatActivity() {

    lateinit var txtName : TextView
    lateinit var txtIngredients : TextView
    lateinit var txtInstructions : TextView
    lateinit var txtCalori : TextView
    lateinit var txtServings : TextView
    lateinit var txtCuisine : TextView
    lateinit var imgRecipe: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        txtName = findViewById(R.id.txtName)
        txtIngredients = findViewById(R.id.txtIngredients)
        txtInstructions = findViewById(R.id.txtInstructions)
        txtCalori = findViewById(R.id.txtCalori)
        txtServings = findViewById(R.id.txtServings)
        txtCuisine = findViewById(R.id.txtCuisine)
        imgRecipe = findViewById(R.id.imgRecipe)


        txtName.setText(intent.getStringExtra("Name"))
        txtIngredients.setText(intent.getStringExtra("Ingredients"))
        txtInstructions.setText(intent.getStringExtra("Instructions"))
        txtCalori.setText(intent.getLongExtra("Calories",0L).toString())
        txtServings.setText(intent.getLongExtra("Servings",0L).toString())
        txtCuisine.setText(intent.getStringExtra("Cuisine"))
        val url = intent.getStringExtra("Image")
        Glide.with(this)
            .load(intent.getStringExtra("Image"))
            .centerCrop()
            .into(imgRecipe)
    }
}