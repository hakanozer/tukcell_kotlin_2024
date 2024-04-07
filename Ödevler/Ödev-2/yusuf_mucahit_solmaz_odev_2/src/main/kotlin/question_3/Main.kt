package question_3

fun main() {
    val animals = arrayOf(
        Animal("Lion", "Mammal", "Grassland"),
        Animal("Elephant", "Mammal", "Savanna"),
        Animal("Tiger", "Mammal", "Jungle"),
        Animal("Parrot", "Bird", "Rainforest"),
        Animal("Snake", "Reptile", "Desert"),
        Animal("Shark", "Fish", "Ocean"),
        Animal("Frog", "Amphibian", "Pond"),
        Animal("Giraffe", "Mammal", "Savanna"),
        Animal("Zebra", "Mammal", "Grassland")
    )

    val zooTransaction = ZooImp()

    for (animal in animals) {
        zooTransaction.addAnimal(animal)
    }

    val animalsByHabitat = zooTransaction.getAnimalByHabitat("Savanna")
    animalsByHabitat.forEach {
        println("Animal: ${it.animalName}, Type: ${it.animalType}, Habitat: ${it.animalHabitat}")
    }

    /*
    Output:

    Animal: Elephant, Type: Mammal, Habitat: Savanna
    Animal: Giraffe, Type: Mammal, Habitat: Savanna*/
}