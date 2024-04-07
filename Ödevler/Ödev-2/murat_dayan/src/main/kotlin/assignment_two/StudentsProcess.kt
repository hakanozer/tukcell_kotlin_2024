package assignment_two

class StudentsProcess(val students: List<Student>) : Student(){

    // Student classından gelen fonksiyona dynamic polymorphism uygulandı
    override fun getAllLessons() {
        for (student in students){
            println("${student.studentName} -> ${student.lessons}")
        }
    }

    fun findStudentWithMaxLessons(): List<Student> {
        var maxLessons = 0
        val studentsWithMaxLessons = mutableListOf<Student>()

        for (student in students) {
            val studentLessonCount = student.lessons.size

            if (studentLessonCount > maxLessons) {
                maxLessons = studentLessonCount
                studentsWithMaxLessons.clear() // En son en çok dersi alan öğrencilerin listesini temizle
            }

            if (studentLessonCount == maxLessons) {
                studentsWithMaxLessons.add(student) // En çok dersi alan öğrenciyi listeye ekle
            }
        }

        return studentsWithMaxLessons
    }




}