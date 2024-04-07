package question_3

fun main() {
    // Animal Instance
    val lion = Animal("Lion", "Mammal", "Grassland")
    val elephant = Animal("Elephant", "Mammal", "Desert")
    val duck = Animal("Duck", "Bird", "River")

    // Zoo Instance
    val zoo = Zoo(listOf(lion, elephant, duck))

    // Print animal info
    zoo.printAnimalInfo()

    // Filter animal by habitat
    zoo.filterAnimalByInhabit("River")
    println()

    // Carnivore Instance
    val eagle = Carnivore("Eagle", "Bird", "Rainforests")
    val piranha = Carnivore("Piranha", "Fish", "South American rivers")

    // Zoo Instance
    val anotherZoo = Zoo(listOf(eagle, piranha))

    // Print animal info
    anotherZoo.printAnimalInfo()

    // Filter animal by habitat
    anotherZoo.filterAnimalByInhabit("Rainforests")
}