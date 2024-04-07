package org.example.soru_3

fun main() {
    val zoo = Zoo()

    zoo.addAnimal(Mammal("Aslan", "Savanna"))
    zoo.addAnimal(Mammal("Zürafa", "Savanna"))
    zoo.addAnimal(Mammal("Kaplan", "Orman"))
    zoo.addAnimal(Mammal("Fil", "Orman"))
    zoo.addAnimal(Bird("Papağan", "Ağaçlık Alan"))
    zoo.addAnimal(Reptile("Timsah", "Göl"))

    val savannaAnimals = zoo.listAnimalsInHabitat("Savanna")
    println("Savanna'da bulunan hayvanlar:")
    savannaAnimals.forEach { println(it.getInfo()) }

    println()

    val allAnimals = zoo.getAnimals()
    println("Tüm hayvanlar:")
    allAnimals.forEach { println(it.getInfo()) }
}