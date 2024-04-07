package number1

 open class Menu {

    //listeye erişimi sınırlamak
    private val liste = mutableMapOf<String, Int>("beyti" to 200, "pide" to 250)

    open fun ekle(isim: String, fiyat: Int) {
        liste[isim] = fiyat
        println("$isim eklendi")
    }

    open fun listele(min: Int, max: Int) {
        //araştırma yaparken fiyat aralığını bu şekilde listelemenin pratik olduğunu gördüm
        //amacım döngü kurup denemekti
        // incelediğimde bu methodun da aynı mantıkta çalıştığını gördüm

        val yeniListe = liste.filterValues { it in min..max }
        println(yeniListe)

    }

}