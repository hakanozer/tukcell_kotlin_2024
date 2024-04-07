package org.example.soru_3

class Mammal(name: String, habitat: String) : Animal(name, habitat) {
    override fun getInfo(): String {
        return "Memeli -> ${super.getInfo()}"
    }
}