package com.selincengiz.selin_cengiz_vize3.presentation.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.selincengiz.selin_cengiz_vize3.R
import com.selincengiz.selin_cengiz_vize3.databinding.FragmentFilterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterFragment : BottomSheetDialogFragment(), AdapterView.OnItemClickListener {
    private lateinit var binding: FragmentFilterBinding
    private lateinit var spinnerList: List<String>
    private var selectedSpinner: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_filter, container, false)
        binding.filterFragment = this
        binding.act.onItemClickListener = this@FilterFragment
        setAdapterToSpinner()
        return binding.root
    }

    fun onSave() = with(binding)
    {
        val age = tvAge.text.toString()
        val firstName = tvFirstName.text.toString()
        val lastName = tvLastName.text.toString()
        val texts = mapOf(
            "age" to age,
            "firstName" to firstName,
            "lastName" to lastName,
            "bloodGroup" to selectedSpinner
        )

        val filledTexts = texts.values.filter { !it.isNullOrEmpty() }

        if (filledTexts.size > 1) {
            Snackbar.make(saveButton, "You have to fill only one field!", Snackbar.LENGTH_SHORT)
                .show()
        } else if (filledTexts.isEmpty()) {
            Snackbar.make(saveButton, "Okey!", Snackbar.LENGTH_SHORT).show()
            findNavController().navigate(
                FilterFragmentDirections.filterToHome(
                    key = "key",
                    value = "value"
                )
            )
        } else {
            Snackbar.make(saveButton, "Okey!", Snackbar.LENGTH_SHORT).show()
            val selected = texts.entries.find {
                it.value.equals(filledTexts[0])
            }
            findNavController().navigate(
                FilterFragmentDirections.filterToHome(
                    key = selected!!.key,
                    value = selected.value!!
                )
            )
        }
    }

    private fun setAdapterToSpinner() {
        spinnerList =
            listOf(" ", "0+", "0-", "A+", "A-", "B+", "B-", "AB+", "AB-")

        val saveTypeAdapter = ArrayAdapter(
            requireContext(),
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            spinnerList
        )
        binding.act.setAdapter(saveTypeAdapter)
    }


    override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        selectedSpinner = if (spinnerList[position] == " ") {
            null
        } else {
            spinnerList[position]
        }
    }

}