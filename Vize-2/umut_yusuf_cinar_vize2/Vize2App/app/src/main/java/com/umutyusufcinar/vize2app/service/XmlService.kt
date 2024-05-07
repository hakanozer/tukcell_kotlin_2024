package com.umutyusufcinar.vize2app.service

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService {

    fun xmlLoad(): List<Common> {
        val list = mutableListOf<Common>()
        try {
            val url = "https://www.w3schools.com/xml/plant_catalog.xml"
            val stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            val doc = Jsoup.parse(stData, Parser.xmlParser())


            val elements = doc.getElementsByTag("PLANT") //Tag doğru mu diye kontrol yapıyorum

            for (item in elements) {
                val commonName = item.getElementsByTag("COMMON").text()
                val botanical = item.getElementsByTag("BOTANICAL").text()
                val zone = item.getElementsByTag("ZONE").text()
                val light = item.getElementsByTag("LIGHT").text()
                val price = item.getElementsByTag("PRICE").text()

                //data class sayesinde veri oluşturup listeye ekliyorum
                val c = Common(commonName, botanical, zone, light, price) //
                list.add(c)
            }
        } catch (ex: Exception) {
            Log.e("xmlLoad", "Error while loading XML data", ex) // Hata yakalama
        }

        return list  // Listeyi döndür
    }
}
