open class Student(val name: String, val number: Int, val courses: List<String>) {
    open fun displayCourses() {
        println("$name kurslar:")
        for (course in courses) {
            println(course)
        }
    }
}



fun enCokDersAlanOgrenci(students: List<Student>): Student? {
    var maxDersOgrenci: Student? = null
    var maxKurslar = 0
    for (student in students) {
        if (student.courses.size > maxKurslar) {
            maxKurslar = student.courses.size
            maxDersOgrenci = student
        }
    }
    return maxDersOgrenci
}

fun main() {
    val student1 = Student("Ali", 808, listOf("Türkçe", "İngilizce", "Fizik"))
    val student2 = Student("Ayse", 222, listOf("Kimya", "Fizik"))
    val student3 = Student("Mehmet", 234, listOf("Fizik", "Biyoloji"))

    val students = listOf(student1, student2, student3)

    for (student in students) {
        student.displayCourses()
    }

    val enCokDersAlanOgrenci = enCokDersAlanOgrenci(students)
    if (enCokDersAlanOgrenci != null) {
        println("En çok ders alan öğrenci: ${enCokDersAlanOgrenci.name}")
    } else {
        println("Böyle bir öğrenci yok.")
    }
}
