package question_3

class ZooImp: Zoo {

    val animalList = mutableListOf<Animal>()
    override fun addAnimal(animal: Animal) {
        animalList.add(animal)
    }

    override fun getAnimalByHabitat(habitat: String): List<Animal> {
        val animalListByHabitat = animalList.filter { it.animalHabitat == habitat }
        return animalListByHabitat
    }
}