package org.example

// Hayvan sınıfı
class Animal(val name: String, val species: String, val habitat: String)

// Hayvanat bahçesi sınıfı
class Zoo {
    private val animals: MutableList<Animal> = mutableListOf()

    // Hayvanat bahçesine hayvan ekleyen metod
    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }

    // Belirli bir yaşam alanına sahip hayvanları listeleme metod
    fun listAnimalsByHabitat(habitat: String) {
        println("Animals that stay in their $habitat zone in the zoo:")
        val filteredAnimals = animals.filter { it.habitat == habitat }
        if (filteredAnimals.isNotEmpty()) {
            filteredAnimals.forEach { println("- ${it.name} (${it.species})") }
        } else {
            println("Couldn't find any animals with specified filter.")
        }
    }
}
