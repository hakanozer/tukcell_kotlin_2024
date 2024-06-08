package com.tlh.dicevm

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.tlh.dicevm.repository.DiceRollRepositoryImpl
import com.tlh.dicevm.viewmodel.RollViewModel
import com.tlh.dicevm.viewmodel.RollViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var text: TextView
    private lateinit var text2: TextView

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        text = findViewById(R.id.textView)
        text2 = findViewById(R.id.textView2)


        val repository = DiceRollRepositoryImpl()
        val factory = RollViewModelFactory(repository)
        val viewmodel: RollViewModel by viewModels { factory }

        button.setOnClickListener {
            viewmodel.rollDices()
        }

        lifecycleScope.launch {
            viewmodel.uiState.collect { roll ->
                text.text = roll.rollOne.toString()
                text2.text = roll.rollTwo.toString()
            }
        }
    }
}
