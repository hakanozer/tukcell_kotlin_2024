package assignment_three

import kotlin.math.E

open class Zoo() {


    var animalList = mutableListOf<Animal>()

    init {
        val Lion = Animal("Lion","Carnivore","Forest")
        val Monkey = Animal("Monkey","Herbivore","Forest")
        val Snake = Animal("Snake","Carnivore","All")
        val Eagle = Animal("Eagle","Carnivore","Forest")
        val animalList = mutableListOf(Lion,Monkey,Snake,Eagle)
        this.animalList = animalList
    }



}