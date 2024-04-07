package question_3

class Zoo  {
    val commonHabitatList: MutableList<Animal> = mutableListOf()
    var animals = mutableListOf<Animal>()

    constructor(animals: MutableList<Animal>)  {
        this.animals = animals
    }


    fun commonHabitat(habitatName: String) {
        animals.forEach {
            if (it.habitat == habitatName){
                commonHabitatList.add(it)
            }
        }
        var animalsName = ""
        commonHabitatList.forEach {
            animalsName += "${it.name}, "
        }
        println("Habitat : $habitatName -> $animalsName")
    }



}