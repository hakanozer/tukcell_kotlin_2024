package question_3

class Zoo(
    private val zooList: List<Animal>
) {
    fun filterAnimalByInhabit(inhabit: String) {
        val filteredAnimal = zooList.filter {
            it.inhabit.equals(inhabit, ignoreCase = true)
        }
        println(filteredAnimal.joinToString { animal ->

            "Filtered by $inhabit: ${animal.name}"
        })
    }

    fun printAnimalInfo() {
        println(zooList.joinToString(separator = "") { animal ->
            "***\nName: ${animal.name}\nType: ${animal.type}\nInhabit: ${animal.inhabit}\n"
        })
    }
}