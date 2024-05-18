package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    lateinit var  nametx : TextView
    lateinit var tagstxt: TextView
    lateinit var ingredstxt : TextView
    lateinit var instructxt : TextView
    lateinit var detailstxt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

            val recipe = intent.getSerializableExtra("recipe") as Recipe

            nametx = findViewById(R.id.nametx)
            ingredstxt = findViewById(R.id.ingredstxt)
            instructxt  = findViewById(R.id.instructxt )
            detailstxt = findViewById(R.id.detailstxt)
            tagstxt = findViewById(R.id.tagstxt)

            nametx.text = recipe.name
            ngredstxt.text = " \n" + recipe.ingredients.joinToString("\n")
            instructxt.text = " \n" + recipe.instructions.joinToString("\n")
            val details = """
             ${recipe.prepTimeMinutes} 
             ${recipe.cookTimeMinutes} 
             ${recipe.servings}
             ${recipe.difficulty}
             ${recipe.cuisine}
             ${recipe.caloriesPerServing}
             ${recipe.rating} (${recipe.reviewCount} 
        """.trimIndent()
            detailstxt.text = details
            tagstxt.text = " " + recipe.tags.joinToString(", ")

        }





    }
}