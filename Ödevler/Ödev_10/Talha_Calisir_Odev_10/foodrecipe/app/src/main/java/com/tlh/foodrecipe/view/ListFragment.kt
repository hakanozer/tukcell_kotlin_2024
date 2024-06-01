package com.tlh.foodrecipe.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.tlh.foodrecipe.adapter.RecipeAdapter
import com.tlh.foodrecipe.databinding.FragmentListBinding
import com.tlh.foodrecipe.model.Recipe
import com.tlh.foodrecipe.room.RecipeDao
import com.tlh.foodrecipe.room.RecipeDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: RecipeDatabase
    private lateinit var dao: RecipeDao
    private val mDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(requireContext(), RecipeDatabase::class.java, "Recipes").build()
        dao = db.recipeDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener { addNew(it) }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getDatas()
    }


    private fun getDatas() {
        mDisposable.add(
            dao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)

        )
    }

    private fun handleResponse(list: List<Recipe>) {
        val recipeAdapter = RecipeAdapter(list)
        binding.recyclerView.adapter = recipeAdapter

    }

    private fun addNew(view: View) {
        val action =
            ListFragmentDirections.actionListFragmentToRecipeFragment(info = "new", id = 0)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mDisposable.clear()//perform cleanup
    }

}
