class Mammal(name: String, habitat: String) : Animal(name, "Mammal", habitat,) {
    override fun makeSound() {
        println("$name shouts.")
    }
}