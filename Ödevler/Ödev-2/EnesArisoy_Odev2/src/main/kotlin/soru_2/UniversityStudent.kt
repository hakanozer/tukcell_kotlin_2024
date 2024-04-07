package org.example.soru_2

class UniversityStudent(name: String, number: Int, lessons: List<String>) : Student(name, number, lessons) {
    override fun displayLessons() {
        print("Üniversite öğrencisi ")
        super.displayLessons()
    }
}