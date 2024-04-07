fun main(){
    // zoo objesi oluşturuyorum
    val zoo = Zoo()

    // animal objeleri oluşturuyorum
    val horse = Animal("Horse","English Horse", "Forest")
    val bee = Animal("Bee","Anatolian Bee", "Mountain")
    val snake = Animal("Snake","Python", "Forest")

    // hayvanları hayvanat bahçesine ekliyorum
    zoo.addAnimal(horse)
    zoo.addAnimal(bee)
    zoo.addAnimal(snake)

    // hayvanat bahçesindeki hayvanları listeliyorum
    zoo.listAnimals()
}