package com.aliberkaygedikoglu.vize2.services

import android.util.Log
import com.aliberkaygedikoglu.vize2.models.Plant
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService {

    fun xmlReader():List<Plant>{
        val list = mutableListOf<Plant>()
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



                val c = Plant(common, botanical, zone, light, price, availability)
                list.add(c)

            }

        }catch (ex: Exception) {
            Log.e("xmlReader", ex.message.toString() )
        }
        return list
    }

}