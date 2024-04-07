package assignment_three

fun main() {



    val animals = Animals()

    val animalsLiveForest = animals.getLiveAreaLiveAnimals("Forest")

    println("live Area Animals")
    for (animal in animalsLiveForest){
        println(animal.animalName)
    }

    println("All Animals")
    animals.animalList.forEach { animal->
        println(animal.animalName)
    }

}