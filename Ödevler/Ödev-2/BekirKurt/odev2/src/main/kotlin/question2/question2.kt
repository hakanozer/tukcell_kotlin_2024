fun main() {
    // student list from Student class
    val students = listOf(
        Student("Ali", 10, listOf("Matematik", "Fizik", "Kimya")),
        Student("Ayşe", 38, listOf("Biyoloji","Kimya", "Coğrafya")),
        Student("Mehmet", 45, listOf("Biyoloji", "Fizik", "Kimya", "Matematik")),
        Student("Fatma", 54, listOf("Türkçe", "Matematik","Felsefe","Din"))
    )

    // list all students' lessons
    println("Students lessons")
    students.forEach { it.listCourses() }
    // list lessons by name
    listLessonsByName(students, "Ali")

    val studentsWithMaxCourses = findStudentsWithMaxLessons(students)
    if (studentsWithMaxCourses.isNotEmpty()) {
        println("\nStudents with max lessons:")
        studentsWithMaxCourses.forEach { println(it.name) }
    } else {
        println("\nStudent not found")
    }
}

// find the student with max lessons
fun findStudentsWithMaxLessons(students: List<Student>): List<Student> {
    val maxLessonCount = students.maxOfOrNull { it.lessons.size } ?: return emptyList()
    return students.filter { it.lessons.size == maxLessonCount }
}

// list lessons by name
fun listLessonsByName(students: List<Student>, name: String) {
    val student = students.find { it.name == name }
    if (student != null) {
        println("------------------------------")
        println("${student.name}'s lessons:")
        student.lessons.forEach { println(it) }
    } else {
        println("$name adında bir öğrenci bulunamadı.")
    }
}