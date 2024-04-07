package Soru1

fun main(){
    val yemekListesi: MutableList<String> = mutableListOf(
        "Karnabahar Yemeği",
        "Mercimek Çorbası",
        "Tavuklu Pilav",
        "Ispanak Yemeği",
        "Köfte",
        "Fırın Tavuk",
        "Balık Tava",
        "Mantar Sote",
        "Fırın Makarna",
        "Sebzeli Pilav"
    )

    val fiyatListesi: MutableList<Double> = mutableListOf(
        15.99,
        6.50,
        20.75,
        12.25,
        18.50,
        22.99,
        28.75,
        14.99,
        10.25,
        16.50
    )

    val menum = Menu(yemekListesi, fiyatListesi)
   val aralikMenum = menum.araliktaListele(43.0,15.0)

    aralikMenum.forEach{ k,v->
        println("Aralikta kalan yemek ismi: $k, fiyati: $v")
    }

    val tatilYemekListesi: MutableList<String> = mutableListOf(
        "Hindi Dolması",
        "Kuzu Tandır",
        "Deniz Mahsulleri Güveci",
        "Kestaneli Piliç",
        "Kadayıf Dolması"
    )

    val tatilFiyatListesi: MutableList<Double> = mutableListOf(
        35.99,
        42.50,
        48.75,
        39.25,
        28.50
    )

    val tatilMenum = TatilMenu(yemekListesi, fiyatListesi, tatilYemekListesi, tatilFiyatListesi)


    val tatilAralikMenum = tatilMenum.araliktaListele(43.0,15.0)

    tatilAralikMenum.forEach{ k,v->
        println("Tatil menusunde aralikta kalan yemek ismi: $k, fiyati: $v")
    }

}