open class hayvanlar(val name: String, val turu: String, val habitat: String)

class hayvanatBahcesi {
    private val hayvanlarınListesi = mutableListOf<hayvanlar>()

    fun hayvanEkleme(animal: hayvanlar) {
        hayvanlarınListesi.add(animal)
    }

    fun hayvanlarınlistesi(habitat: String): List<hayvanlar> {
        return hayvanlarınListesi.filter { it.habitat == habitat }
    }
}