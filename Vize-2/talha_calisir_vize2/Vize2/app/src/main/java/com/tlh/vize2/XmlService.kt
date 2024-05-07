package com.tlh.vize2

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService {

    fun xmlLoad(): List<Plant> {
        val listPlant= mutableListOf<Plant>()
        try {
            val url="https://www.w3schools.com/xml/plant_catalog.xml"
            val stData= Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            val doc= Jsoup.parse(stData, Parser.xmlParser())
            val elements=doc.getElementsByTag("PLANT")
            for (item in elements){
                val common=item.getElementsByTag("COMMON").text()
                val botanical=item.getElementsByTag("BOTANICAL").text()
                val zone=item.getElementsByTag("ZONE").text().toInt()
                val light=item.getElementsByTag("LIGHT").text()
                val price=item.getElementsByTag("PRICE").text()
                val availability=item.getElementsByTag("AVAILABILITY").text()

                val result=Plant(common,botanical,zone,light,price,availability)
                listPlant.add(result)

            }
        }
        catch (ex:Exception){
            Log.e("xmlLoad", ex.message.toString() )
        }
        return listPlant

        }

    }


