package com.works.days_7.services

import android.util.Log
import com.works.days_7.models.Currency
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser

class XmlService {

    fun xmlLoad() : List<Currency> {
        val list = mutableListOf<Currency>()
        try {
            val url = "https://www.tcmb.gov.tr/kurlar/today.xml"
            val stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            val doc = Jsoup.parse(stData, Parser.xmlParser())
            val elements = doc.getElementsByTag("Currency")
            for (item in elements) {
                val CurrencyName = item.getElementsByTag("CurrencyName").text()
                val ForexBuying = item.getElementsByTag("ForexBuying").text()
                val c = Currency(CurrencyName, ForexBuying)
                list.add(c)
            }
        }catch (ex: Exception) {
            Log.e("xmlLoad", ex.message.toString() )
        }
        return list
    }


}