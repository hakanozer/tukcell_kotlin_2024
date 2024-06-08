package com.tlh.foods.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.tlh.foods.adapter.FoodRecyclerAdapter
import com.tlh.foods.databinding.FragmentFoodlistBinding
import com.tlh.foods.viewmodel.FoodListViewModel

class FoodlistFragment : Fragment() {

    private var _binding: FragmentFoodlistBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : FoodListViewModel
    private val recyclerBesinAdapter = FoodRecyclerAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodlistBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[FoodListViewModel::class.java]
        viewModel.refreshData()

        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = recyclerBesinAdapter

        binding.swipeRefresh.setOnRefreshListener {
            binding.progressBar.visibility = View.VISIBLE
            binding.textView.visibility = View.GONE
            binding.recyclerview.visibility = View.GONE
            viewModel.refreshFromInternet()
            binding.swipeRefresh.isRefreshing = false
        }

        observeLiveData()
    }

    fun observeLiveData(){

        viewModel.foods.observe(viewLifecycleOwner) {
            binding.recyclerview.visibility = View.VISIBLE
            recyclerBesinAdapter.updateFoodList(it)
        }

        viewModel.foodErrorMessage.observe(viewLifecycleOwner) {
            if (it) {
                binding.textView.visibility = View.VISIBLE
                binding.recyclerview.visibility = View.GONE
            } else {
                binding.textView.visibility = View.GONE
            }
        }

        viewModel.foodLoading.observe(viewLifecycleOwner) {
            if (it) {
                binding.recyclerview.visibility = View.GONE
                binding.textView.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}