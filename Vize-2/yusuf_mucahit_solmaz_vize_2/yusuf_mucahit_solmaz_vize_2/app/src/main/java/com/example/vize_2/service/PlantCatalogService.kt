package com.example.vize_2.service

import com.example.vize_2.model.PlantCatalog

interface PlantCatalogService {


    fun getAllData() : List<PlantCatalog>

    fun searchByCommon(commonName: String, plantList: List<PlantCatalog>) : List<PlantCatalog>
}