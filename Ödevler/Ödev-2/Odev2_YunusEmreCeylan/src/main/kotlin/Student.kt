package org.example
// 2. Soru
class Student(val name: String, val studentNumber: Int, val courses: List<String>) {
    fun listCourses() {
        println("Courses taken by $name:")
        courses.forEach { println(it) }
    }

    //bu kısımda en çok dersi alan öğrenci sayısı birden fazla olması durumu için ve ders sayısını da
    // döndürebilmek için yeni bir class oluşturdum ve o classı döndürdüm
    //companion pbject kullanmak istemedim fakat aklıma başka bir çözüm gelmedi
    companion object {
        fun findStudentsWithMostCourses(students: List<Student>): List<StudentCourseCount> {
            val maxCourseCount = students.maxOfOrNull { it.courses.size }
            return students.filter { it.courses.size == maxCourseCount }.map {
                StudentCourseCount(it, it.courses.size)
            }
        }
    }
}
