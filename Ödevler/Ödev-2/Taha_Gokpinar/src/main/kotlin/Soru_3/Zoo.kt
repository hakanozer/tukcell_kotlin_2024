package Soru_3

class Zoo{

    val animalList = mutableListOf<Animal>()


    fun listAnimalsByHabitat(habitat: String): List<String>{
        val animals = mutableListOf<String>()
        println("$habitat habitatıdan yaşayan hayvanlar: ")
        for (it in animalList){
            if (it.habitat.lowercase() == habitat.lowercase()){
                animals.add("${it.name} - ${it.species}")
            }
        }
        if (animals.size == 0){
            println("Hayvanat bahçesinde $habitat habitatından hayvan bulunmamaktadır.")
        }
        return animals
    }

    fun addAnimal(animal: Animal){
        animalList.add(animal)
    }

    fun addAnimal(list: List<Animal>){
        for (it in list){
            animalList.add(it)
        }
    }
}