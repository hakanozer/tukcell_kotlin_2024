package org.example.soru_3

class Zoo {
    private val animals: MutableList<Animal> = mutableListOf()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }

    fun getAnimals(): List<Animal> {
        return animals.toList()
    }

    fun listAnimalsInHabitat(habitat: String): List<Animal> {
        return animals.filter { it.habitat == habitat }
    }
}