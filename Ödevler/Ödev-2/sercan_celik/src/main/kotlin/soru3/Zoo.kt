package soru3

class Zoo {
    private val animals = mutableListOf<Animal>()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
        println("${animal.name} eklendi.")
    }

    fun listAnimalsByHabitat(habitat: String) {
        val filteredAnimals = animals.filter {
            it.habitat.equals(habitat, ignoreCase = true)
        }
        if (filteredAnimals.isNotEmpty()) {
            println("$habitat alanında yaşayan hayvanlar:")
            filteredAnimals.forEach {
                println(it.name)
            }
        } else {
            println("$habitat yaşam alanına sahip hayvan bulunmamaktadır.")
        }
    }
}
