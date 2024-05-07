package com.omersungur.omer_sungur_vize_2.service

import com.omersungur.omer_sungur_vize_2.common.Constants.AVAILABILITY
import com.omersungur.omer_sungur_vize_2.common.Constants.BASE_URL
import com.omersungur.omer_sungur_vize_2.common.Constants.BOTANICAL
import com.omersungur.omer_sungur_vize_2.common.Constants.COMMON
import com.omersungur.omer_sungur_vize_2.common.Constants.LIGHT
import com.omersungur.omer_sungur_vize_2.common.Constants.PLANT
import com.omersungur.omer_sungur_vize_2.common.Constants.PRICE
import com.omersungur.omer_sungur_vize_2.common.Constants.ZONE
import com.omersungur.omer_sungur_vize_2.model.Plant
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class XmlService : IXmlService {

    override fun getData(): List<Plant> {
        val plantList = mutableListOf<Plant>()

        try {
            val url = BASE_URL
            val data = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            val doc = Jsoup.parse(data, Parser.xmlParser())
            val elements = doc.getElementsByTag(PLANT)

            for (item in elements) {
                val common = item.getElementsByTag(COMMON).text()
                val botanical = item.getElementsByTag(BOTANICAL).text()
                val zone = item.getElementsByTag(ZONE).text()
                val light = item.getElementsByTag(LIGHT).text()
                val price = item.getElementsByTag(PRICE).text()
                val availability = item.getElementsByTag(AVAILABILITY).text()

                val plant = Plant(common, botanical, zone, light, price, availability)
                plantList.add(plant)
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        return plantList
    }
}