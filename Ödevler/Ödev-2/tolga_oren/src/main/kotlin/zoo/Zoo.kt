package zoo

class Zoo(private val animals: List<Animal>) {

    fun filterHabitat(habitat: String) : List<Animal> {
        return animals.filter { it.habitat == habitat }
    }

    fun getAnimals() : List<Animal> {
        return animals
    }
}