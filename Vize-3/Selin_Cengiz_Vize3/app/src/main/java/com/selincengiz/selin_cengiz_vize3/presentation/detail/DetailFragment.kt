package com.selincengiz.selin_cengiz_vize3.presentation.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.selincengiz.selin_cengiz_vize3.R
import com.selincengiz.selin_cengiz_vize3.common.Extensions.loadUrlCenterCrop
import com.selincengiz.selin_cengiz_vize3.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = args.user
        with(binding) {
            ivImage.loadUrlCenterCrop(user.image)
            tvName.text = user.firstName + " " + user.lastName
            tvAge.text = user.age.toString()
            tvEmail.text = user.email
            tvUniversity.text = user.university
            tvAddress.text = "Address: " + user.address?.address
            tvCity.text = "City: " + user.address?.city
            tvState.text = "State: " + user.address?.state
            tvHairColor.text = "Hair Color: " + user.hair?.color
            tvEyeColor.text = "Eye Color: " + user.eyeColor
            tvWeight.text = "Weight: " + user.weight.toString()
            tvHeight.text = "Height: " + user.height.toString()
            tvBloodGroup.text = "Blood Group: " + user.bloodGroup
            tvGender.text = "Gender: " + user.gender
            tvTitle.text = "Title: " + user.company?.title
            tvCompanyName.text = "Company: " + user.company?.name
            tvCompanyAddress.text = "Address: " + user.company?.address?.address
            tvCardExpire.text = "Card Expire: " + user.bank?.cardExpire
            tvCardIban.text = "IBAN: " + user.bank?.iban
            tvCardNumber.text = "Card Number: " + user.bank?.cardNumber
            tvCardType.text = "Card Type: " + user.bank?.cardType
        }
    }
}