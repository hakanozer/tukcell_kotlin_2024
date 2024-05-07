package com.works.vize_2.Services

import android.util.Log
import com.works.vize_2.Models.Catalog
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService {

    fun xmlLoad(): List<Catalog>{

        val catalogDatas = mutableListOf<Catalog>()

        try{
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
                val catalogData = Catalog(common, botanical, zone, light, price, availability)
                catalogDatas.add(catalogData)
            }

        }catch(ex: Exception){
            Log.d("xmlLoad", ex.message.toString())
        }

        return catalogDatas

    }


}