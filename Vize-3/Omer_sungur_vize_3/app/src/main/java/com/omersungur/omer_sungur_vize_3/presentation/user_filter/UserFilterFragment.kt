package com.omersungur.omer_sungur_vize_3.presentation.user_filter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.omersungur.omer_sungur_vize_3.R
import com.omersungur.omer_sungur_vize_3.core.Constants.AGE
import com.omersungur.omer_sungur_vize_3.core.Constants.BLOOD_AB_NEGATIVE
import com.omersungur.omer_sungur_vize_3.core.Constants.BLOOD_A_NEGATIVE
import com.omersungur.omer_sungur_vize_3.core.Constants.BLOOD_A_POSITIVE
import com.omersungur.omer_sungur_vize_3.core.Constants.BLOOD_B_NEGATIVE
import com.omersungur.omer_sungur_vize_3.core.Constants.BLOOD_B_POSITIVE
import com.omersungur.omer_sungur_vize_3.core.Constants.BLOOD_GROUP
import com.omersungur.omer_sungur_vize_3.core.Constants.BLOOD_O_NEGATIVE
import com.omersungur.omer_sungur_vize_3.core.Constants.BLOOD_O_POSITIVE
import com.omersungur.omer_sungur_vize_3.core.Constants.EYE_COLOR
import com.omersungur.omer_sungur_vize_3.core.Constants.FIRST_NAME
import com.omersungur.omer_sungur_vize_3.core.Constants.ID
import com.omersungur.omer_sungur_vize_3.core.Constants.LAST_NAME
import com.omersungur.omer_sungur_vize_3.core.viewBinding
import com.omersungur.omer_sungur_vize_3.databinding.FragmentUserFilterBinding
import com.omersungur.omer_sungur_vize_3.presentation.common.SharedUserListViewModel

class UserFilterFragment : Fragment(R.layout.fragment_user_filter) {

    private val binding by viewBinding(FragmentUserFilterBinding::bind)
    private val viewModel: SharedUserListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFilter.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // sonar comment
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // sonar comment
            }
            override fun afterTextChanged(s: Editable?) {
                checkButtonState()
            }
        }

        binding.tvUserBloodGroupFilter.setOnClickListener {
            showPopUp(it)
        }

        with(binding) {
            tvUserFirstNameFilter.editText?.addTextChangedListener(textWatcher)
            tvUserLastNameFilter.editText?.addTextChangedListener(textWatcher)
            tvUserAgeFilter.editText?.addTextChangedListener(textWatcher)
            tvUserIdFilter.editText?.addTextChangedListener(textWatcher)
            tvUserEyeColorFilter.editText?.addTextChangedListener(textWatcher)
            tvUserBloodGroupFilter.addTextChangedListener(textWatcher)
        }

        binding.btnFilter.setOnClickListener {
            val key = getKey()
            val value = getValue()
            viewModel.filterUsers(key!!, value!!) // We know that key and value are not null
            findNavController().navigate(R.id.action_userFilterFragment_to_userListFragment)
        }
    }

    private fun checkButtonState() {
        with(binding) {
            val isFirstNameFilled = !tvUserFirstNameFilter.editText?.text.isNullOrBlank()
            val isLastNameFilled = !tvUserLastNameFilter.editText?.text.isNullOrBlank()
            val isAgeFilled = !tvUserAgeFilter.editText?.text.isNullOrBlank()
            val isIdFilled = !tvUserIdFilter.editText?.text.isNullOrBlank()
            val isEyeColorFilled = !tvUserEyeColorFilter.editText?.text.isNullOrBlank()
            val isBloodGroupFilled = !tvUserBloodGroupFilter.text.isNullOrBlank()

            val filledCount = listOf(
                isFirstNameFilled,
                isLastNameFilled,
                isAgeFilled,
                isIdFilled,
                isEyeColorFilled,
                isBloodGroupFilled

            ).count { it }

            btnFilter.isEnabled = filledCount == 1
        }
    }

    private fun getKey(): String? {
        with(binding) {
            return when {
                !tvUserFirstNameFilter.editText?.text.isNullOrBlank() -> FIRST_NAME
                !tvUserLastNameFilter.editText?.text.isNullOrBlank() -> LAST_NAME
                !tvUserAgeFilter.editText?.text.isNullOrBlank() -> AGE
                !tvUserIdFilter.editText?.text.isNullOrBlank() -> ID
                !tvUserEyeColorFilter.editText?.text.isNullOrBlank() -> EYE_COLOR
                !tvUserBloodGroupFilter.text.isNullOrBlank() -> BLOOD_GROUP
                else -> null
            }
        }
    }

    private fun getValue(): String? {
        with(binding) {
            return when {
                !tvUserFirstNameFilter.editText?.text.isNullOrBlank() -> tvUserFirstNameFilter.editText?.text.toString()
                !tvUserLastNameFilter.editText?.text.isNullOrBlank() -> tvUserLastNameFilter.editText?.text.toString()
                !tvUserAgeFilter.editText?.text.isNullOrBlank() -> tvUserAgeFilter.editText?.text.toString()
                !tvUserIdFilter.editText?.text.isNullOrBlank() -> tvUserIdFilter.editText?.text.toString()
                !tvUserEyeColorFilter.editText?.text.isNullOrBlank() -> tvUserEyeColorFilter.editText?.text.toString()
                !tvUserBloodGroupFilter.text.isNullOrBlank() -> tvUserBloodGroupFilter.text.toString()
                else -> null
            }
        }
    }

    private fun showPopUp(view: View) {
        val popUp = PopupMenu(requireContext(), view)
        popUp.menuInflater.inflate(R.menu.menu_blood_group, popUp.menu)
        popUp.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.blood_group_a_negative -> {
                    binding.tvUserBloodGroupFilter.setText(BLOOD_A_NEGATIVE)
                    true
                }

                R.id.blood_group_a_positive -> {
                    binding.tvUserBloodGroupFilter.setText(BLOOD_A_POSITIVE)
                    true
                }

                R.id.blood_group_b_negative -> {
                    binding.tvUserBloodGroupFilter.setText(BLOOD_B_NEGATIVE)
                    true
                }

                R.id.blood_group_b_positive -> {
                    binding.tvUserBloodGroupFilter.setText(BLOOD_B_POSITIVE)
                    true
                }

                R.id.blood_group_o_negative -> {
                    binding.tvUserBloodGroupFilter.setText(BLOOD_O_NEGATIVE)
                    true
                }

                R.id.blood_group_o_positive -> {
                    binding.tvUserBloodGroupFilter.setText(BLOOD_O_POSITIVE)
                    true
                }

                R.id.blood_group_ab_negative -> {
                    binding.tvUserBloodGroupFilter.setText(BLOOD_AB_NEGATIVE)
                    true
                }

                else -> false
            }
        }
        popUp.show()
    }
}