package com.tlh.foods.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tlh.foods.databinding.FragmentFoodDetailBinding
import com.tlh.foods.util.downloadImage
import com.tlh.foods.util.makePlaceHolder

import com.tlh.foods.viewmodel.FoodDetailViewModel


class FoodDetailFragment : Fragment() {

    private var _binding: FragmentFoodDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : FoodDetailViewModel
    private var besinId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            besinId = FoodDetailFragmentArgs.fromBundle(it).foodId
        }

        viewModel = ViewModelProvider(this)[FoodDetailViewModel::class.java]
        viewModel.takeRoomData(besinId)
        observeLiveData()

    }

    fun observeLiveData(){
        viewModel.foodLiveData.observe(viewLifecycleOwner) { food ->
            binding.besinIsim.text = food.foodName
            binding.besinKalori.text = food.foodCalorie
            binding.besinKarbonhidrat.text = food.foodCarbohHydrate
            binding.besinProtein.text = food.foodProtein
            binding.besinYag.text = food.foodOil
            binding.besinImage.downloadImage(food.foodImage, makePlaceHolder(requireContext()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}