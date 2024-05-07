package com.example.eray_altilar_vize_2.services

import android.util.Log
import com.example.eray_altilar_vize_2.model.CatalogData
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class PlantCatalogService {

    private lateinit var catalogDataList: List<CatalogData>
    fun plantCatalogLoad() {
        try {
            val url = "https://www.w3schools.com/xml/plant_catalog.xml"
            val stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            Log.d("xml", stData)
            val doc = Jsoup.parse(stData, Parser.xmlParser())
            val elements = doc.getElementsByTag("PLANT")
            catalogDataList = mutableListOf()


            for (item in elements) {
                val common = item.getElementsByTag("COMMON").text()
                val botanical = item.getElementsByTag("BOTANICAL").text()
                val zone = item.getElementsByTag("ZONE").text().toString()
                val light = item.getElementsByTag("LIGHT").text()
                val price = item.getElementsByTag("PRICE").text().toString()
                val availability = item.getElementsByTag("AVAILABILITY").text()

                val catalogData = CatalogData(common, botanical, zone, light, price, availability)
                (catalogDataList as MutableList<CatalogData>).add(catalogData)

            }

                Log.d("CatalogData", catalogDataList.toString())

        } catch (ex: Exception) {
            Log.e("catalogLoad", ex.message.toString())
        }

    }
    fun searchCounter(text: String): Int {
        var count = 0
        for (data in catalogDataList) {
            if (data.common.contains(text, ignoreCase = true)
            ) {
                count++
            }
        }
        return count
    }

    fun searchByInput(text: String): List<CatalogData> {
        if (!::catalogDataList.isInitialized) {
            plantCatalogLoad()
        }
        val result = mutableListOf<CatalogData>()
        for (data in catalogDataList) {
            if (data.common.contains(text, ignoreCase = true)
            ) {
                result.add(data)
            }
        }
        return result
    }
}