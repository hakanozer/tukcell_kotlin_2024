class Zoo  {
    private val animals: MutableList<Animal> = mutableListOf()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }

    fun listAnimalsByHabitat(habitat: String) {
        println("Animals in habitat $habitat:")
        animals.filter { it.habitat == habitat }
            .forEach { println("${it.name} - ${it.specy}") }
    }
}