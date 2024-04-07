package org.example.soru_3

class Reptile(name: String, habitat: String) : Animal(name, habitat) {
    override fun getInfo(): String {
        return "Sürüngen -> ${super.getInfo()}"
    }
}