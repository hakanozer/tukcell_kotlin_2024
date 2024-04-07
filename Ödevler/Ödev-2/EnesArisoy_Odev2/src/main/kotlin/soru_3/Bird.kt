package org.example.soru_3

class Bird(name: String, habitat: String) : Animal(name, habitat) {
    override fun getInfo(): String {
        return "Kuş -> ${super.getInfo()}"
    }
}