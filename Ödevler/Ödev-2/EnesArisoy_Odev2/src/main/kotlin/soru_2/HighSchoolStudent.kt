package org.example.soru_2

class HighSchoolStudent(name: String, number: Int, lessons: List<String>) : Student(name, number, lessons) {
    override fun displayLessons() {
        print("Lise öğrencisi ")
        super.displayLessons()
    }
}