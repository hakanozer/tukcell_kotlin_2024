package soru2

class StudentList : ArrayList<Student>() {
    fun listAllCourses() {
        for (student in this) {
            student.listCourses()
        }
    }
    fun findStudentMostCourses(): Student? {
        return this.maxByOrNull {
            it.courses.size
        }
    }

}