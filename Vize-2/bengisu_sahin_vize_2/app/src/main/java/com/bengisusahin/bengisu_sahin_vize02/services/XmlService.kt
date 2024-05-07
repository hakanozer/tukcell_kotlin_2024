package com.bengisusahin.bengisu_sahin_vize02.services

import android.util.Log
import com.bengisusahin.bengisu_sahin_vize02.models.Plant
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService {
    fun xmlLoad() : List<Plant> {
        val list = mutableListOf<Plant>()
        try {
            val url = "https://www.w3schools.com/xml/plant_catalog.xml"
            val stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            val doc = Jsoup.parse(stData, Parser.xmlParser())
            val elements = doc.getElementsByTag("PLANT")
            for (item in elements) {
                val COMMON = item.getElementsByTag("COMMON").text()
                val BOTANICAL = item.getElementsByTag("BOTANICAL").text()
                val ZONE = item.getElementsByTag("ZONE").text()
                val LIGHT = item.getElementsByTag("LIGHT").text()
                val PRICE = item.getElementsByTag("PRICE").text()
                val AVAILABILITY = item.getElementsByTag("AVAILABILITY").text()
                val plant = Plant(COMMON, BOTANICAL, ZONE, LIGHT, PRICE, AVAILABILITY)
                list.add(plant)
            }
            Log.d("xml", list.toString())
        }catch (ex: Exception) {
            Log.e("xmlLoad", ex.message.toString() )
        }
        return list
    }
}