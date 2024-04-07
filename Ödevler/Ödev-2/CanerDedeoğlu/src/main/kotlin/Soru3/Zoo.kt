package Soru3

class Zoo {

    private val animal = mutableListOf<Animal>()

    //Hayvan ekleme
    fun addAnimal(animals : Animal)
    {
        animal.add(animals)
    }
    // Hayvan Listeleme
    fun animalList(habitat : String)
    {
        println("Yaşam alanı $habitat olan hayvanlar :" )

        animal.filter { it.habitat == habitat }.forEach { animal ->
            println("${animal.animalName} - Türü : ${animal.animalType}")
        }

        }

}