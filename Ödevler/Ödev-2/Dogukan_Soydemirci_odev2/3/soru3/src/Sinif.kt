// Animal sınıfı
open class Animal(val name: String, val species: String, val habitat: String) {

    override fun toString(): String {
        return "Ad: $name, Cins: $species, Bölge: $habitat"
    }
}


class Zoo {
    private val animals: MutableList<Animal> = mutableListOf()


    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }


    fun habitataGoreHayvanListele(habitat: String) {
        val animalsInHabitat = animals.filter { it.habitat == habitat }
        if (animalsInHabitat.isNotEmpty()) {
            println("Buradaki hayvanlar: $habitat:")
            animalsInHabitat.forEach { println(it) }
        } else {
            println("Burada hayvan yok: $habitat")
        }
    }
}

fun main() {

    val kaplan = Animal("Kappy", "Kaplan", "Orman")
    val yilan = Animal("Vrat", "Yılan", "Çöl")
    val maymun = Animal("Mayb", "Maymun", "Orman")


    val zoo = Zoo()


    zoo.addAnimal(kaplan)
    zoo.addAnimal(yilan)
    zoo.addAnimal(maymun)


    zoo.habitataGoreHayvanListele("Orman")
}
