package com.omersungur.omer_sungur_vize_2.service

import com.omersungur.omer_sungur_vize_2.model.Plant

interface IXmlService {
    fun getData() : List<Plant>
}