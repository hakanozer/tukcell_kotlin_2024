class Zoo {
    val animalList = mutableListOf<Animal>()

    // bu fonskiyon ile hayvanları hayvanat bahçeçsine ekliyorum
    fun addAnimal(animal: Animal){
        animalList.add(animal)
    }

    // Hayvanları listeleme işlemini for ile yapıyorum
    fun listAnimals() {
        println("Animals in the zoo:")
        for (animal in animalList) {
            animal.displayInfo()
            println()
        }
    }
}