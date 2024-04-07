package question_3

// Carnivore extends Animal
class Carnivore : Animal {

    // Secondary Constructor
    // But, If we have only a secondary constructor, we should convert to a primary constructor. It's just example.
    constructor(name: String, type: String, inhabit: String) : super(name, type, inhabit)

    // Polymorphism
    override fun feedAnimal(food: String) {
        super.feedAnimal(food)
        println("The carnivore is full. There is no need to feed")
    }
}