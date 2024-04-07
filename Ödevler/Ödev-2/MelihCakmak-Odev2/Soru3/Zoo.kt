package Soru3

class Zoo() {
    private val animals = mutableListOf<Animal>()
    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }
    fun removeAnimal(animal: Animal) {
        animals.remove(animal)
    }

    fun getAnimalsByHabitat(habitat: String): List<Animal> {
        val filteredList=animals.filter { it.habitat == habitat }
        println("Animals for this habitat: $habitat")
        filteredList.forEach {
            println("Animal Name : ${it.name}\nType : ${it.type}\nHabitat : ${it.habitat}\n")
        }



        return filteredList
    }

    fun printAnimals(){

            println("------Animals------")

            animals.forEach {
                println("Animal Name : ${it.name}\nType : ${it.type}\nHabitat : ${it.habitat}\n")

            }
            println("---------------------")


    }
}