package org.example.soru_2

fun main() {
    val highSchoolStudent = HighSchoolStudent("Ali", 123, listOf("Matematik", "Fizik", "Kimya"))
    val universityStudent =
        UniversityStudent(
            "Ayşe",
            456,
            listOf("Diferansiyel Denklemler", "Bilgisayar Bilimi", "Yapay Zeka", "Veri Madenciliği")
        )

    val students = listOf(highSchoolStudent, universityStudent)

    students.forEach {
        it.displayLessons()
    }

    val studentWithMostCourses = findStudentWithMostLessons(students)
    if (studentWithMostCourses.isNotEmpty()) {
        println("En fazla ders alan öğrenci(ler) -> ${studentWithMostCourses.size} kişi ${studentWithMostCourses[0].lessons.size} ders alıyor")
        studentWithMostCourses.forEach {
            println(it.name)
        }
    } else {
        println("Hiçbir öğrencinin aldığı ders yok.")
    }
}


fun findStudentWithMostLessons(students: List<Student>): List<Student> {
    var maxLessonCount = 0
    val studentsWithMostLessons = mutableListOf<Student>()

    for (student in students) {
        if (student.lessons.size > maxLessonCount) {
            maxLessonCount = student.lessons.size
            studentsWithMostLessons.clear()
            studentsWithMostLessons.add(student)
        } else if (student.lessons.size == maxLessonCount) {
            studentsWithMostLessons.add(student)
        }
    }
    return studentsWithMostLessons
}
