package com.bengisusahin.bengisu_sahin_odev_08.adapters

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.bengisusahin.bengisu_sahin_odev_08.R
import com.bengisusahin.bengisu_sahin_odev_08.models.Recipe
import com.bengisusahin.bengisu_sahin_odev_08.view.DetailActivity

class RecipeAdapter(private val context: Activity, private val originalList: List<Recipe>) :
    ArrayAdapter<Recipe>(context, R.layout.recipe_row, originalList), Filterable {

    private var filteredList: List<Recipe> = originalList

    // parent parameter refers to the ViewGroup to which the created view should be added
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // we pass to the parent parameter the ViewGroup to which the created view should be added
        // By using false we indicate that we do not want the view to be immediately added to the parent when it is returned
        val rootView = convertView ?: context.layoutInflater.inflate(R.layout.recipe_row, parent, false)

        val dt = filteredList[position]

        val rowName = rootView.findViewById<TextView>(R.id.row_name)
        val rowCaloriesPerServing = rootView.findViewById<TextView>(R.id.row_caloriesPErServing)

        rowName.text = dt.name
        rowCaloriesPerServing.text = "${dt.caloriesPerServing} cal"

        // Every time getView runs a click listener is set for each element
        rootView.setOnClickListener {
            startDetailActivity(dt)
        }
        return rootView
    }

    // ListView gets how many rows it should create when drawing itself
    override fun getCount(): Int {
        return filteredList.size
    }

    // ListView uses this method when retrieving the item at a specific position
    override fun getItem(position: Int): Recipe? {
        return filteredList[position]
    }

    // used to uniquely identify items
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // When click the item in the list, it shows the details of the item
    private fun startDetailActivity(recipe: Recipe) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("detail", recipe)
        context.startActivity(intent)
    }

    // performs the search and updates the list
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val searchText = constraint?.toString()?.trim() ?: ""
                val filterResults = FilterResults()
                // If the search text is empty, the original list is used
                // Otherwise, recipes containing search text (filteredList) are used
                filterResults.values = if (searchText.isEmpty()) {
                    originalList
                } else {
                    originalList.filter { it.name.contains(searchText, ignoreCase = true) }
                }
                return filterResults
            }

            // updated filteredList and notified the adapter for the new list
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                // type conversion is safe because that the results?.values object is a List<Recipe>
                filteredList = results?.values as List<Recipe>
                notifyDataSetChanged()
            }
        }
    }
}
