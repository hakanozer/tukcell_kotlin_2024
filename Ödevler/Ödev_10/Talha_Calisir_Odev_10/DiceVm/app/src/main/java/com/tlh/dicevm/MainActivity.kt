package com.tlh.dicevm

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.tlh.dicevm.viewmodel.RollViewmodel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var text: TextView


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        text = findViewById(R.id.textView)
        val viewmodel: RollViewmodel by viewModels()
        lifecycleScope.launch {
            viewmodel.uiState.collect { roll ->
                button.setOnClickListener {
                //   roll.rollOne = (1..6).random()
                    viewmodel.rollDice()
                    text.text = roll.rollOne.toString()
                }
            }
        }


    }
}