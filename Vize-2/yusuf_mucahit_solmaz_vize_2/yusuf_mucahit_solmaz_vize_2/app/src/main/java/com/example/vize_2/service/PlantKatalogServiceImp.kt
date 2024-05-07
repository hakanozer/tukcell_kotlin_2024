package com.example.vize_2.service

import com.example.vize_2.model.PlantCatalog
import com.example.vize_2.utils.Utils.BASE_URL
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class PlantKatalogServiceImp: PlantCatalogService {


    override fun getAllData(): List<PlantCatalog> {
        val plantList = mutableListOf<PlantCatalog>()
        try {
            val url = BASE_URL
            val stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            val doc = Jsoup.parse(stData, Parser.xmlParser())
            val plants = doc.getElementsByTag("PLANT")
            for (plant in plants) {
                val common = plant.getElementsByTag("COMMON").text()
                val botanical = plant.getElementsByTag("BOTANICAL").text()
                val zone = plant.getElementsByTag("ZONE").text()
                val light = plant.getElementsByTag("LIGHT").text()
                val price = plant.getElementsByTag("PRICE").text()
                val availability = plant.getElementsByTag("AVAILABILITY").text()

                val plantCatalog = PlantCatalog(common, botanical, zone, light, price, availability)
                plantList.add(plantCatalog)
            }
        } catch (e: Exception) {
            println(e.localizedMessage)
        }
        return plantList
    }

    override fun searchByCommon(commonName: String, plantList: List<PlantCatalog>): List<PlantCatalog> {
        return plantList.filter { it.common.contains(commonName, ignoreCase = true) }
    }



}

