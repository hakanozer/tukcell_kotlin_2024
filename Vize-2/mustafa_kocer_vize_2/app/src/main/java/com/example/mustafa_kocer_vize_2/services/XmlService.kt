package com.example.mustafa_kocer_vize_2.services

import android.util.Log
import com.example.mustafa_kocer_vize_2.models.PlantCatalog
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser

class XmlService {

    fun plantLoad(): List<PlantCatalog>{
        val list = mutableListOf<PlantCatalog>()

        try {
            val url = "https://www.w3schools.com/xml/plant_catalog.xml"
            // hangi servisi tüketeceksen buna göre hareket edeceksin
            // Bunun içi jsoup library'sini kullancağız
            val stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            // timeout koyarak, maximum ne kadar beklemesini söylüyorum 15 saniyeden sonra catch'e düşecek
            // ignoreContentType = true yapınca Jsoup'un içi html ile çalışıyor, true vererek her türlü veriyle çalış diyoruz
            // get() ile verileri getiriyoruz
            // string nesnesi geldi ama bu bizim işimizi görmez, öncelikle bir document nesnesi kuracağız
            val doc: Document = Jsoup.parse(stData, Parser.xmlParser()) // bende stData diye bir data var ve
            // al bunu xml'de parserlayabileceğin bir yapıya dönüştür
            val elements = doc.getElementsByTag("PLANT")
            // bende bir PLANT adında bir şey var. Burası bir dizidir diyebiliyoruz
            // buna göre parçalayacağız bunun için elements oluşturacağız
            // elements'i tüketmemiz lazım
            for (item in elements){
                // item, Element türünde oluyor artık!!
                //println("Item geldi common : "+item.getElementsByTag("COMMON").text())

                val catalog = PlantCatalog(
                    COMMON = item.getElementsByTag("COMMON").text(),
                    BOTANICAL = item.getElementsByTag("BOTANICAL").text(),
                    ZONE = item.getElementsByTag("ZONE").text(),
                    LIGHT = item.getElementsByTag("LIGHT").text(),
                    PRICE = item.getElementsByTag("PRICE").text(),
                    AVAILABILITY = item.getElementsByTag("AVAILABILITY").text()
                )
                // tek tek verileri çekip listeme aktarıyorum
                list.add(catalog)
            }
        }
        catch (e:Exception){
            Log.e("xmlLoad", e.message.toString())
        }
        return list
    }
}