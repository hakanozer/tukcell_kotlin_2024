package school

class Students(private val students: List<Student>) {

    fun getStudentLessons() : Map<String, List<String>> {
        val studentsLessons = mutableMapOf<String, List<String>>()
        students.forEach {
            studentsLessons.put(it.name, it.lessons)
        }
        return studentsLessons
    }

    fun mostLessonStudent() : Student? {
        return students.maxByOrNull { it.lessons.size }
    }
}