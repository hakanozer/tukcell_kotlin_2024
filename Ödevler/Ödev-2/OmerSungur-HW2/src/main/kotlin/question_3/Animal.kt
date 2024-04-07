package question_3

open class Animal(val name: String, val type: String, val inhabit: String) {
    open fun feedAnimal(food: String) {
        println("It was fed with $food")
    }
}