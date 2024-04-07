package question_3

interface Zoo {

    fun addAnimal(animal: Animal)

    fun getAnimalByHabitat(habitat:String) : List<Animal>
}