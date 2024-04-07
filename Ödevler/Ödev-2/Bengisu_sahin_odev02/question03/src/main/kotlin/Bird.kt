class Bird (name: String, habitat: String) : Animal(name, "Bird", habitat) {
    override fun makeSound() {
        println("$name chirps.")
    }
}