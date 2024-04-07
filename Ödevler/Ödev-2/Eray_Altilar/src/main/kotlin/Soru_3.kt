fun main() {
    val zoo = Zoo()

    /// Hayvanat bahçesine hayvanlar ekleniyor
    zoo.addAnimal(Animal("Aslan", "Memeli", "Savanlar"))
    zoo.addAnimal(Animal("Zürafa", "Memeli", "Savanlar"))
    zoo.addAnimal(Animal("Fil", "Memeli", "Orman"))
    zoo.addAnimal(Animal("Kaplan", "Memeli", "Orman"))
    zoo.addAnimal(Animal("Ahtapot", "Kafadan bacaklı", "Okyanus"))
    zoo.addAnimal(Animal("Köpek Balığı", "Balık", "Okyanus"))

    /// Tüm hayvanlar listeleniyor
    val allAnimals = zoo.getAllAnimals()
    if(allAnimals.isEmpty()) {
        println("Hayvanat Bahçesinde hiç hayvan bulunmamaktadır")
    } else {
        println("Hayvanat Bahçesindeki Tüm Hayvanlar:")
        for (animal in allAnimals) {
            println("Hayvan: ${animal.name}, Tür: ${animal.type}, Habitat: ${animal.habitat}")
        }
    }

    println("============================== ")



    /// Belirli bir habitat için hayvanlar listeleniyor
    val habitat = "Orman"
    val filteredByHabitat = zoo.listAnimalsInHabitat(habitat)
    if(filteredByHabitat.isEmpty()) {
        println("Hayvanat Bahçesinde Belirtilen Habitattan Hayvan Bulunmamaktadır")
    } else {
        println("$habitat Habitatındaki Hayvanlar:")
        for (animal in filteredByHabitat) {
            println("Hayvan: ${animal.name}, Tür: ${animal.type}, Habitat: ${animal.habitat}")
        }
    }
}

data class Animal(val name: String, val type: String, val habitat: String)

 class Zoo {
    /// Eger bu listeye bu classi miras alan bir classtan ulasacaksak protected yapabiliriz.
    private val animals: MutableList<Animal> = mutableListOf()

    fun getAllAnimals(): List<Animal> {
        return animals.toList()
    }

    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }

    fun listAnimalsInHabitat(habitat: String): List<Animal> {
        return animals.filter { it.habitat == habitat }
    }
}
