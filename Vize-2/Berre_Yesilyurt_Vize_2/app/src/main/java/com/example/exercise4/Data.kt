package com.example.exercise4

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class Data {

    val dataList= mutableListOf<Plant>()

fun load():MutableList<Plant>?{

try{
    val url="https://www.w3schools.com/xml/plant_catalog.xml"
    val strData= Jsoup.connect(url).timeout(12000).ignoreContentType(true).get().toString()
    Log.d("datalar",strData)
    //println(strData)
    val doc= Jsoup.parse(strData, Parser.xmlParser())
    val elements=doc.getElementsByTag("PLANT")
    Log.d("plants",elements.toString())
    println(elements.toString())

    for(item in elements){
        val common=item.getElementsByTag("COMMON").text()
        val botanical=item.getElementsByTag("BOTANICAL").text()
        val zone=item.getElementsByTag("ZONE").text()
        val light=item.getElementsByTag("LIGHT").text()
        val price=item.getElementsByTag("PRICE").text()
        val availability=item.getElementsByTag("AVAILABILITY").text()

        val plant=Plant(common, botanical, zone, light, price, availability)

        dataList.add(plant)

        Log.d("list",dataList.toString())



    }

}catch (err:Exception){
    Log.e("hata",err.message.toString())

}
    return dataList;
}
}