package com.muratdayan.vize2.services

import android.util.Log
import com.muratdayan.vize2.models.PlantModel
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser

class Service {

    fun xmlLoad() : List<PlantModel>{

        val plantList = mutableListOf<PlantModel>()


        try {

            val url = "https://www.w3schools.com/xml/plant_catalog.xml"

            val data = Jsoup
                .connect(url)
                .timeout(15000)
                .ignoreContentType(true)
                .get()
                .toString()

            val doc: Document = Jsoup.parse(data, Parser.xmlParser())
            val elements = doc.getElementsByTag("PLANT")

            for (item in elements){
                val common = item.getElementsByTag("COMMON").text()
                val botanical = item.getElementsByTag("BOTANICAL").text()
                val zone = item.getElementsByTag("ZONE").text()
                val light = item.getElementsByTag("LIGHT").text()
                val price = item.getElementsByTag("PRICE").text()
                val availability = item.getElementsByTag("AVAILABILITY").text()

                val plant = PlantModel(common,botanical,zone,light,price,availability)
                plantList.add(plant)

            }

        }catch (e:Exception){
            println("service exc $e")
        }
        return plantList
    }


}