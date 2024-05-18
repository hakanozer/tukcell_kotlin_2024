package com.selincengiz.selin_cengiz_odev8.presentation.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.selincengiz.selin_cengiz_odev8.R
import com.selincengiz.selin_cengiz_odev8.common.Extensions.loadUrl
import com.selincengiz.selin_cengiz_odev8.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val argsRecipe=args.recipe
        with(binding){
            imageSlide.loadUrl(argsRecipe.image)
            tvCalories.text=argsRecipe.caloriesPerServing.toString()+" Kcal"
            tvDifficulty.text=argsRecipe.difficulty
            tvTitle.text=argsRecipe.name
            tvRatings.text=argsRecipe.rating.toString()
            tvClock.text=argsRecipe.cookTimeMinutes.toString()+" min"
            tvInstructions.text=argsRecipe.instructions.toString()
            tvIngredients.text=argsRecipe.ingredients.toString()
        }

    }
}