package org.example

// Öğrenci sınıfı
class Student(val name: String, val number: Int, val courses: List<String>) {
    // Öğrencinin aldığı dersleri listeleyen metod
    fun listCourses() {
        println("$name's lessons:")
        courses.forEach { println("- $it") }
    }
}