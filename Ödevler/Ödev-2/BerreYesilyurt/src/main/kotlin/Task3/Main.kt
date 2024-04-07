package org.example.Task3

fun main() {
    val zoo=Zoo()

    val animal1=Animal("Kedi","Memeli","")
    val animal2=Animal("Yunus","Memeli","Okyanus")
    val animal3=Animal("Deve Kuşu","Kuş","Çöl")
    val animal4=Animal("Karınca","Böcek","Yer altı")
    val animal5=Animal("Fare","Memeli","")
    val animal6=Animal("Kertenkele","Sürüngen","Çöl")
    val animal7=Animal("Hamsi","Balık","Deniz")

    zoo.addAnimals(animal1)
    zoo.addAnimals(animal2)
    zoo.addAnimals(animal3)
    zoo.addAnimals(animal4)
    zoo.addAnimals(animal5)
    zoo.addAnimals(animal6)
    zoo.addAnimals(animal7)

    zoo.animalsOnZoo.forEach {
        println(it.name)
    }

    println(zoo.isThereHabitat())

}