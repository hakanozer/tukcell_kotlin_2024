fun main() {
    val animal = Bird("Bird","Trees")
    val animal2 = Mammal("Cat","Forests")
    val animal3 = Mammal("Dog","Prairies")
    val animal4 = Mammal("Elephant","Woodlands")
    val animal5 = Animal("Crocodile","Reptiles","Rivers")

    val listOfAnimal = mutableSetOf(animal,animal2,animal3,animal4,animal5)

    val zoo = Zoo(listOfAnimal)
    zoo.filterHabitat("Woodlands")
}