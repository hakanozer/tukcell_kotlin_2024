package org.example
//3. Soru
class Zoo {
    private val animals = mutableListOf<Animal>()

    fun addNewAnimal(animal: Animal) {
        animals.add(animal)
    }

    fun listAnimalsHabitat(habitat: String) {
        animals.filter { it.habitat == habitat }.forEach { println("${it.name}: ${it.type}") }
    }
}
