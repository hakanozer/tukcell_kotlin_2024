package com.cevdetkilickeser.cevdetkilickeservize2.services

import android.util.Log
import com.cevdetkilickeser.cevdetkilickeservize2.models.Plant
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import java.lang.Exception

class XmlService {

    private val plantList = mutableListOf<Plant>()

    fun plantLoad() : List<Plant> {
        try {
            val url = "https://www.w3schools.com/xml/plant_catalog.xml"
            val stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString() //timeout : servis tetiklendiğinde servisin toplamda 15 saniye veri gelmezse catch'e düşmesini sağlar
            val doc: Document = Jsoup.parse(stData, Parser.xmlParser())
            val elements = doc.getElementsByTag("PLANT")
            for (item in elements) {
                val common = item.getElementsByTag("COMMON").text()
                val botanical = item.getElementsByTag("BOTANICAL").text()
                val zone = item.getElementsByTag("ZONE").text()
                val light = item.getElementsByTag("LIGHT").text()
                val price = item.getElementsByTag("PRICE").text()
                val availability = item.getElementsByTag("AVAILABILITY").text()

                val plant = Plant(common, botanical, zone, light, price, availability)

                plantList.add(plant)

            }
        }catch (e: Exception){
            Log.e("şş", e.message.toString())
        }

        return plantList

    }
}