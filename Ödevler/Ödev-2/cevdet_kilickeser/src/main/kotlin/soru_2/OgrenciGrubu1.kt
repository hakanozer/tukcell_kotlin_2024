package soru_2

class OgrenciGrubu1 (name: String, number: Int, courses: List<String>) : Student(name, number, courses) {
    override fun dersleriListele() {
        println("$name dersleri:")
        super.dersleriListele()
    }
}