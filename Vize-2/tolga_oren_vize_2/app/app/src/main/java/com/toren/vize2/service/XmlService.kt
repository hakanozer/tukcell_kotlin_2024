package com.toren.vize2.service

import android.util.Log
import com.toren.vize2.model.Plant
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService {

    fun plantLoad() : MutableList<Plant> {
        val plantList = mutableListOf<Plant>()
        try {
            val url = "https://www.w3schools.com/xml/plant_catalog.xml"
            val plantData = Jsoup.connect(url).timeout(15000)
                .ignoreContentType(true)
                .get().toString()
            val doc = Jsoup.parse(plantData, Parser.xmlParser())
            val element = doc.getElementsByTag("PLANT")
            for (i in element) {
                val common = i.getElementsByTag("COMMON").text()
                val botanical = i.getElementsByTag("BOTANICAL").text()
                val zone = i.getElementsByTag("ZONE").text()
                val light = i.getElementsByTag("LIGHT").text()
                val price = i.getElementsByTag("PRICE").text()
                val availability = i.getElementsByTag("AVAILABILITY").text().toInt()
                val plant = Plant(common, botanical, zone, light, price, availability)
                plantList.add(plant)
            }
            Log.d("plantLoad", "success")
        } catch (e: Exception) {
            Log.d("plantLoad", "error")
        }
        return plantList
    }


}