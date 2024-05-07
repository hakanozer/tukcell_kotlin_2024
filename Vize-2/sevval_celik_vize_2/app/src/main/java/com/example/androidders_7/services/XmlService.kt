package com.example.androidders_7.services

import android.util.Log
import com.example.androidders_7.cdData
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser

class XmlService {

    fun cdLoad(): MutableList<cdData> {
        val cdList = mutableListOf<cdData>()
        try {
            val url="https://www.w3schools.com/xml/plant_catalog.xml"
            val cdData=Jsoup.connect(url).timeout(150000).ignoreContentType(true).get().toString()
            Log.d("plant",cdData)
            val doc:Document=Jsoup.parse(cdData, Parser.xmlParser())
            val elements=doc.getElementsByTag("plant")
            for (item in elements){
                val common = item.getElementsByTag("COMMON").text()
                Log.d("common", common)
                val botanical = item.getElementsByTag("BOTANICAL").text()
                val zone = item.getElementsByTag("ZONE").text()
                val light = item.getElementsByTag("LIGHT").text()
                val price = item.getElementsByTag("PRICE").text()
                val availability = item.getElementsByTag("AVAILABILITY").text()

                val cdData= cdData(common ,botanical,zone,light,price,availability)
                cdList.add(cdData)
//                Log.d("COMMON",common)
//                Log.d("AVAILABILITY",availability)
            }


        }catch (ex:Exception){
            Log.e("xmlLoad",ex.message.toString())
        }

        return cdList

    }


}