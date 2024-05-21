package com.omersungur.omer_sungur_vize_3.presentation.user_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.omersungur.omer_sungur_vize_3.R
import com.omersungur.omer_sungur_vize_3.core.viewBinding
import com.omersungur.omer_sungur_vize_3.databinding.FragmentUserDetailBinding

class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {

    private val binding by viewBinding(FragmentUserDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUserDetail()
    }

    private fun getUserDetail() {
        val bundle: UserDetailFragmentArgs by navArgs()
        val userDetail = bundle.userDetail

        with(binding) {
            tvFirstNameDetail.text = getString(R.string.first_name_label, userDetail.firstName)
            tvLastNameDetail.text = getString(R.string.last_name_label, userDetail.lastName)
            tvMaidenNameDetail.text = getString(R.string.maiden_name_label, userDetail.maidenName)
            tvAgeDetail.text = getString(R.string.age_label, userDetail.age.toString())
            tvGenderDetail.text = getString(R.string.gender_label, userDetail.gender)
            tvEmailDetail.text = getString(R.string.email_label, userDetail.email)
            tvPhoneDetail.text = getString(R.string.phone_label, userDetail.phone)
            tvUsernameDetail.text = getString(R.string.username_label, userDetail.username)
            tvPasswordDetail.text = getString(R.string.password_label, userDetail.password)
            tvBirthDateDetail.text = getString(R.string.birth_date_label, userDetail.birthDate)
            tvBloodGroupDetail.text = getString(R.string.blood_group_label, userDetail.bloodGroup)
            tvHeightDetail.text = getString(R.string.height_label, userDetail.height.toString())
            tvWeightDetail.text = getString(R.string.weight_label, userDetail.weight.toString())
            tvEyeColorDetail.text = getString(R.string.eye_color_label, userDetail.eyeColor)
            tvHairColorDetail.text = getString(R.string.hair_color_label, userDetail.hair.color)
            tvHairStyleDetail.text = getString(R.string.hair_style_label, userDetail.hair.type)
            tvDomainDetail.text = getString(R.string.domain_label, userDetail.domain)
            tvCityDetail.text = getString(R.string.city_label, userDetail.address.city)
            tvAddressDetail.text = getString(R.string.address_label, userDetail.address.address)
            tvUniversityDetail.text = getString(R.string.university_label, userDetail.university)

            Glide.with(requireView()).load(userDetail.image).into(ivUserImageDetail)
        }
    }
}