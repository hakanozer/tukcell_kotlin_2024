package number4

class Library {
    private val kitapListesi = mutableListOf<Book>()

    fun ekle(kitap: Book) {
        kitapListesi.add(kitap)
    }

    fun listele() {
        for (index in kitapListesi) {
            println("Kitap: ${index.kitapAdi}-- Yazar: ${index.yazar}")
        }
    }

    fun yazaraGoreListe(yazar: String) {

        println("$yazar Kitapları:")
        for (index in kitapListesi.filter { it.yazar == yazar }) {
            println("/ ${index.kitapAdi}")
        }

        /* for (i in kitapListesi){
             if (i.yazar == yazar){
                 println(i.kitapAdi)
             }
         }
         */

    }
}