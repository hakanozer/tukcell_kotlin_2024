class Zoo(private val animals: Set<Animal>) {

    // Firstly, it was checked whether the given habitat parameters were present in the animals' habitats.
    // Then it was printed according to mapping functions.
    fun filterHabitat(habitat: String){
        // Thanks to "filter" function, it filters animals that match the given habitat.
        val filteredList = animals.filter { it.habitat == habitat }
        // If the habitat has an animal, it shows which animal lives in a given habitat.
        if (filteredList.isNotEmpty()){
            println("Animals has habitat $habitat:")
            filteredList.forEach {
                println(it.name)
            }
        }else{
            println("No animals live in $habitat.")
        }
    }
}