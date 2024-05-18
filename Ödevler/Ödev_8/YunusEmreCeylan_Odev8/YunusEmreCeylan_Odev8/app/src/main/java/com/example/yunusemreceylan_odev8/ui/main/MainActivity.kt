package com.example.yunusemreceylan_odev8.ui.main

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.yunusemreceylan_odev8.R
import com.example.yunusemreceylan_odev8.databinding.ActivityMainBinding
import com.example.yunusemreceylan_odev8.data.model.Recipe

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        observeViewModel()
    }

    private fun setupViews() {
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.txtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // sonar - comment
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // sonar - comment
            }

            override fun afterTextChanged(s: Editable?) {
                val searchQuery = s.toString().trim()
                if (searchQuery.isNotEmpty()) {
                    viewModel.fetchRecipes(searchQuery)
                    showClearIcon(true)
                } else {
                    viewModel.fetchRecipes("")
                    showClearIcon(false)
                }
            }
        })

        binding.imgClear.setOnClickListener {
            binding.txtSearch.text.clear()
            showClearIcon(false)
        }
    }

    private fun observeViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.recipesLiveData.observe(this, Observer { recipes ->
            if (recipes?.isNotEmpty() == true) {
                val recipesAdapter = ListAdapter(this@MainActivity, recipes)
                binding.listViewRecipes.adapter = recipesAdapter
            } else {
                val defaultRecipes = getDefaultRecipes()
                val defaultRecipesAdapter = ListAdapter(this@MainActivity, defaultRecipes)
                binding.listViewRecipes.adapter = defaultRecipesAdapter
            }
        })
    }

    private fun getDefaultRecipes(): List<Recipe> {
        return emptyList()
    }

    private fun showClearIcon(show: Boolean) {
        val clearIcon: Drawable? = if (show) {
            ContextCompat.getDrawable(this, R.drawable.baseline_close_24)
        } else {
            null
        }
        binding.imgClear.setImageDrawable(clearIcon)
        binding.imgClear.visibility = if (show) View.VISIBLE else View.GONE
    }
}
