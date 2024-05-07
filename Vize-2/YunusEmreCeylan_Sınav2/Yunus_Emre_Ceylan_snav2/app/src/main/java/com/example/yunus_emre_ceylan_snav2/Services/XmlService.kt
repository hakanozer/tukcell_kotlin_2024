package com.example.yunus_emre_ceylan_snav2.Services

import android.util.Log
import com.example.yunus_emre_ceylan_snav2.Plant
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService {

    fun xmlLoad(): MutableList<Plant> {
        var list = mutableListOf<Plant>()

        try {
            val url="https://www.w3schools.com/xml/plant_catalog.xml"
            val strData = Jsoup.connect(url)
                .ignoreContentType(true).get().toString()
            val doc = Jsoup.parse(strData, Parser.xmlParser())
            val elements = doc.getElementsByTag("PLANT")
            for(item in elements){
                val Common = item.getElementsByTag("COMMON").text()
                val Botanical =item.getElementsByTag("BOTANICAL").text()
                val Zone =item.getElementsByTag("ZONE").text()
                val Light =item.getElementsByTag("LIGHT").text()
                val Price =item.getElementsByTag("PRICE").text()
                val Availabilty =item.getElementsByTag("AVAILABILITY").text()

                val obj =Plant(Common = Common,Botanical,Zone,Light,Price,Availabilty)
                Log.d("sa", obj.toString())
                list.add(obj)
            }

        }catch (e:Exception){
            Log.e("xmlLoad",e.message.toString())
        }
        return list
    }
}