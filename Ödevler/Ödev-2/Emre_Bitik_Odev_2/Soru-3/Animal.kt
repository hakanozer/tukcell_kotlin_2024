class Animal(val name: String, val species: String, val habitat: String)

class Zoo {
    private val animals: MutableList<Animal> = mutableListOf()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }

    fun listAnimalsInHabitat(habitat: String) {
        val animalsInHabitat = animals.filter { it.habitat == habitat }
        if (animalsInHabitat.isNotEmpty()) {
            println("Animals in $habitat:")
            animalsInHabitat.forEach { println("- ${it.name}, ${it.species}") }
        } else {
            println("Hayvan bulunamadı $habitat.")
        }
    }
}