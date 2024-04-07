package soru_3

class Zoo {
    private val hayvanlar = mutableListOf<Animal>()

    fun hayvanEkle(hayvan: Animal) {
        hayvanlar.add(hayvan)
    }

    fun yasamAlaninaGoreHayvanlar(yasamAlani: String) {
        val yasamalAnindakiHayvanlar = hayvanlar.filter { it.yasamAlani == yasamAlani }
        if (yasamalAnindakiHayvanlar.isNotEmpty()) {
            println("$yasamAlani içindeki hayvanlar: ")
            yasamalAnindakiHayvanlar.forEach { println(it) }
        } else {
            println("Hayvan yok")
        }
    }
}