package number3

class Zoo(val hayvanlar: MutableList<Animal>) {


    fun alanaGoreListe(yasamAlanı: String) {

        hayvanlar.forEach { index ->
            if (yasamAlanı == index.yasamAlani) {
                println(index.ad)
            }
        }
    }
}



