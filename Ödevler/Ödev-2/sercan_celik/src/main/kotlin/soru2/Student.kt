package soru2

open class Student(val name: String, val number: Int, val courses: List<String>) {
    fun listCourses() {
        println("$name Adlı öğrencinin aldığı dersler (Numarası: $number):")
        for (course in courses) {
            println(course)
        }
    }
}
