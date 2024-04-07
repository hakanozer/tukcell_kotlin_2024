package Soru_3

fun main() {
    val zoo = Zoo()
    val animal1 = Animal("Aslan","Lion","Savana")
    val animal2 = Animal("Zürafa","Giraffe","Savana")

    val animals = listOf(
        Animal("Penguen","Penguin","Kutup"),
        Animal("Ayı","Bear","Orman"),
        Animal("Kurt","Wolf","Orman"),
        Animal("Çöl Tilkisi", "Fox", "Çöl")
    )

    zoo.addAnimal(animal1)
    zoo.addAnimal(animal2)
    zoo.addAnimal(animals)

    val animalList = zoo.listAnimalsByHabitat("Savana")
    for (it in animalList){
        println(it)
    }
}