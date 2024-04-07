package question_2

class StudentTransactionImp: StudentTransactions() {

    val studentList = mutableListOf<Student>()
    override fun getLessonsByStudentNu(studentNu: Long): Array<Course>? {
        val student = studentList.find {
            it.studentNu == studentNu
        }

        return student?.courses
    }

    override fun getStudentByHighestLessonNumber(): Student? {
        var student : Student? = null
        var highestLessonNu = 0

        studentList.forEach {
            if (highestLessonNu < it.courses.size){
                highestLessonNu = it.courses.size
                student = it
            }
        }
        return student
    }

    override fun addStudent(student: Student) {
       studentList.add(student)
    }
}