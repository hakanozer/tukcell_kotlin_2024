package com.beyzaparlak.vize2.service

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XMLService {

    fun xmlLoad(): MutableList<Plant> {
        val list = mutableListOf<Plant>()

        try {
            val url = "https://www.w3schools.com/xml/plant_catalog.xml"
            val stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            val doc = Jsoup.parse(stData, Parser.xmlParser())
            val elements = doc.getElementsByTag("Plant")

            // for içinde tüm elementleri gezniyorum
            for (item in elements) {
                val COMMON = item.getElementsByTag("COMMON").text()
                val BOTANICAL = item.getElementsByTag("BOTANICAL").text()
                val ZONE = item.getElementsByTag("ZONE").text()
                val LIGHT = item.getElementsByTag("LIGHT").text()
                val PRICE = item.getElementsByTag("PRICE").text()
                val AVAILABILITY = item.getElementsByTag("AVAILABILITY").text()
                val c = Plant(COMMON, BOTANICAL, ZONE, LIGHT, PRICE, AVAILABILITY)

                // her elementi listeye ekliyorum
                list.add(c)
            }
        }catch (ex: Exception) {
            Log.e("xmlLoad", ex.message.toString())
        }

        return list
    }



}