package com.example.omerfaruk_arslan_vize_2.service

import android.util.Log
import com.example.omerfaruk_arslan_vize_2.model.Plant
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService {
    fun xmlLoad(): List<Plant> {
        val list = mutableListOf<Plant>()
        try {
            val url = "https://www.w3schools.com/xml/plant_catalog.xml"
            val stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            val doc = Jsoup.parse(stData, Parser.xmlParser())


            val elements = doc.getElementsByTag("PLANT")

            for (item in elements) {
                val commonName = item.getElementsByTag("COMMON").text()
                val botanical = item.getElementsByTag("BOTANICAL").text()
                val zone = item.getElementsByTag("ZONE").text()
                val light = item.getElementsByTag("LIGHT").text()
                val price = item.getElementsByTag("PRICE").text()


                val c = Plant(commonName, botanical, zone, light, price)
                list.add(c)
            }
        } catch (ex: Exception) {
            Log.e("xmlLoad", "Error while loading XML data", ex)
        }

        return list
    }
}