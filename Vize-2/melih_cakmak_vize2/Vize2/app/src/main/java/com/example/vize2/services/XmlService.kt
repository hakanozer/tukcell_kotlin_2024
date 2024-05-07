package com.example.vize2.services

import android.util.Log
import com.example.vize2.model.Plant
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService {

    fun xmlSearch(key:String): List<Plant> {
        val plantList= mutableListOf<Plant>()
        try {
            val url="https://www.w3schools.com/xml/plant_catalog.xml"
            val stData= Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            val doc= Jsoup.parse(stData, Parser.xmlParser())
            val elements=doc.getElementsByTag("PLANT")
            for (item in elements){
                val Common=item.getElementsByTag("COMMON").text()
                val Botanical=item.getElementsByTag("BOTANICAL").text()
                val Zone=item.getElementsByTag("ZONE").text().toInt()
                val Light=item.getElementsByTag("LIGHT").text()
                val Price=item.getElementsByTag("PRICE").text()
                val Availability=item.getElementsByTag("AVAILABILITY").text()

                val dataObject=Plant(Common,Botanical,Zone,Light,Price,Availability)
                plantList.add(dataObject)


            }


        }
        catch (ex:Exception){
            Log.e("xmlLoad", ex.message.toString() )
        }
        return plantList.filter { plant ->
            plant.common.contains(key)&&key.isNotEmpty()

        }

    }

}