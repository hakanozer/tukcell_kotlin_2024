open class Animal (
    // Animal Variables
    var name: String,
    var type: String,
    var habitat: String
) {
    // For applying polymorphism, it was created makeSound method.
    open fun makeSound() {
        println("$name makes a sound.")
    }
}