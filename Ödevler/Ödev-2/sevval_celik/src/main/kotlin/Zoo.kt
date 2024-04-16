class Zoo {
    private val hayvanlar: MutableList<Animal> = mutableListOf()

    // Hayvan ekleme işlemi
    fun hayvanEkle(hayvan: Animal) {
        hayvanlar.add(hayvan)
    }

    fun yasamAlaninaSahipHayvanlariListele(yasamAlani: String): List<Animal> {
        return hayvanlar.filter { it.yasamAlani == yasamAlani }
    }

}