package com.example.xmlservice

import android.util.Log
import com.example.xmlservice.models.XmlData
import org.jsoup.Jsoup
import org.jsoup.parser.Parser


class XmlService {
    var list = mutableListOf<XmlData>()
    fun xmlLoad(){
        try {
            val url = "https://www.w3schools.com/xml/plant_catalog.xml"
            val stData = Jsoup.connect(url).timeout(155000).ignoreContentType(true).get().toString()
            val doc=Jsoup.parse(stData, Parser.xmlParser())
            val elements = doc.getElementsByTag("PLANT")
            for(item in elements){
                val Common = item.getElementsByTag("COMMON").text()
                val Botanical = item.getElementsByTag("BOTANICAL").text()
                val Zone = item.getElementsByTag("ZONE").text()
                val Light = item.getElementsByTag("LIGHT").text()
                val Price = item.getElementsByTag("PRICE").text()
                val Availability = item.getElementsByTag("AVAILABILITY").text()
                val data = XmlData(Common,Botanical,Zone,Light,Price,Availability)
                list.add(data)

            }
        }catch (ex:Exception){
            Log.e("XmlLoad",ex.message.toString())
        }

    }//xmlload

}//xmlservices