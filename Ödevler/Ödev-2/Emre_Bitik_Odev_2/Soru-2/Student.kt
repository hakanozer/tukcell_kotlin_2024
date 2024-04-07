class Student(val name: String, val number: Int, val courses: List<String>) {
    fun displayCourses() {
        println("$name isimli öğrencisinin aldıgı dersler")
        courses.forEach { println("- $it") }
    }
}

fun findWMostCourses(students: List<Student>): Student? {

    return students.maxByOrNull { it.courses.size }
}
