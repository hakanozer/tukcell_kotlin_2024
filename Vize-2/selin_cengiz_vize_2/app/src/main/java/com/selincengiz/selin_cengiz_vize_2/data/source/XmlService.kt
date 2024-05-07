package com.selincengiz.selin_cengiz_vize_2.data.source

import com.selincengiz.selin_cengiz_vize_2.common.Constants.BASE_URL
import com.selincengiz.selin_cengiz_vize_2.common.Resource
import com.selincengiz.selin_cengiz_vize_2.data.entities.PlantResponse
import org.jsoup.Jsoup
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

class XmlService {

    companion object {
        val plantList by lazy {
            mutableListOf<PlantResponse>()
        }
    }

    fun xmlLoadPlant(): Resource<Boolean> {
        return try {
            val xmlData = Jsoup.connect(BASE_URL)
                .timeout(15000)
                .ignoreContentType(true)
                .get()
                .toString()

            val doc = Jsoup.parse(xmlData, Parser.xmlParser())
            val elements = doc.getElementsByTag("PLANT")
            plantList.clear()

            elementsToPlantResponse(elements)

        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    private fun elementsToPlantResponse(elements: Elements): Resource<Boolean> {
        return try {
            for (item in elements) {
                val common = item.getElementsByTag("COMMON").text()
                val botanical = item.getElementsByTag("BOTANICAL").text()
                val zone = item.getElementsByTag("ZONE").text()
                val light = item.getElementsByTag("LIGHT").text()
                val price = item.getElementsByTag("PRICE").text()
                val availability = item.getElementsByTag("AVAILABILITY").text()

                val plant = PlantResponse(
                    availability,
                    botanical,
                    common,
                    light,
                    price,
                    zone,
                )
                plantList.add(plant)
            }
            Resource.Success(true)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

}