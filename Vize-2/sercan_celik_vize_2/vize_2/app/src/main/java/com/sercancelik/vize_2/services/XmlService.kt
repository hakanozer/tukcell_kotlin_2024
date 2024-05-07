package com.sercancelik.vize_2.services

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService {
    fun xmlLoad(callback: (List<Catalog>) -> Unit) {
        val thread = Thread {
            val plants = mutableListOf<Catalog>()
            try {
                val url = "https://www.w3schools.com/xml/plant_catalog.xml"
                val stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
                val doc = Jsoup.parse(stData, Parser.xmlParser())
                val elements = doc.getElementsByTag("PLANT")

                for (item in elements) {
                    val common = item.getElementsByTag("COMMON").text()
                    val botanical = item.getElementsByTag("BOTANICAL").text()
                    val zone = item.getElementsByTag("ZONE").text()
                    val light = item.getElementsByTag("LIGHT").text()
                    val price = item.getElementsByTag("PRICE").text()
                    val availability = item.getElementsByTag("AVAILABILITY").text()

                    val catalog = Catalog(common, botanical, zone, light, price, availability)
                    plants.add(catalog)
                }
            } catch (e: Exception) {
                Log.e("xmlLoad", e.message.toString())
            } finally {
                callback(plants)
            }
        }
        thread.start()
    }
}